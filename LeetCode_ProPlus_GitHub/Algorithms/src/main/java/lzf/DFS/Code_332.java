package lzf.DFS;

import java.util.*;

/**
 * 邻接表
 */
public class Code_332 {
    public static void main(String[] args) {

    }
    HashMap<String,List<String>> map=new HashMap<>();
    List<String>  res=new ArrayList<>();
    HashMap<String,boolean []> visited=new HashMap<>();
    // 边的数目
    int n;

    public List<String> findItinerary(List<List<String>> tickets) {
        n=tickets.size();
        // 建立邻接表
        for(List<String> t:tickets){
            if(!map.containsKey(t.get(0))){
                map.put(t.get(0),new ArrayList<String>());
            }
            map.get(t.get(0)).add(t.get(1));
        }
        for(List<String> list:map.values()){
            Collections.sort(list);
        }

        //  建立  访问标志映射
        for(String key:map.keySet()){
            boolean []a=new boolean[map.get(key).size()];
            visited.put(key,a);
        }

        dfs("JFK",0);
        return res;
    }

    public boolean dfs(String cur,int count){
        res.add(cur);
        if(count>=n){
            return true;
        }

        List<String> list=map.get(cur);

        if(list!=null){
            for(int i=0;i<list.size();i++){
                if(visited.get(cur)[i]==false){
                    visited.get(cur)[i]=true;
                    if(dfs(list.get(i),count+1)){
                        return true;
                    }
                    // 回溯
                    visited.get(cur)[i]=false;
                }
            }
        }
        res.remove(res.size()-1);
        return false;

    }

     /*private Deque<String> res;
    private Map<String, Map<String, Integer>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                //升序Map
                temp = new TreeMap<>();
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();
        //防止出现null
        if(map.containsKey(last)){
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)) {
                        return true;
                    }
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }*/


    /*Map<String,List<String>> map=new HashMap<>();
    List<String> res=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String>ticket:tickets){
            if(!map.containsKey(ticket.get(0))){
                List<String> list=new LinkedList<>();
                list.add(ticket.get(1));
                map.put(ticket.get(0),list);
            }
            else{
                map.get(ticket.get(0)).add(ticket.get(1));
            }
        } // 建立图的邻接表

        for(List<String> list:map.values()){
            list.sort(String::compareTo);
        }

        dfs(map,"JFK");
        return res;

    }

    void dfs(Map<String,List<String>> map,String start){
        List<String> neighbors=map.get(start);
        while(neighbors!=null&&neighbors.size()>0){
            String dest=neighbors.get(0);
            neighbors.remove(0);
            dfs(map,dest);
        }
        res.add(start);
    }*/


}
