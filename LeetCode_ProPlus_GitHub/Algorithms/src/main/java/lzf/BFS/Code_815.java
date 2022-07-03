package lzf.BFS;

import java.util.*;
import java.util.concurrent.locks.Lock;

/**
 * 建图题
 */
public class Code_815 {
    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        int source = 1;
        int target = 6;
        System.out.println(new Code_815().numBusesToDestination(routes,source,target));
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //存放<站点，有该站点的路线>
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
        //存放已到过的路线
        Set<Integer> set = new HashSet<>();
        //存放已去过的站点
        Set<Integer> set1 = new HashSet<>();
        //将起点加入已去过的站点
        set1.add(source);
        //Queue存放<没去过的路线，去这条路线需要转车的次数>
        Queue<int[]> queue = new LinkedList<int[]>();
        //路线数
        int M = routes.length;
        //特殊情况处理，起点就是终点
        if(source == target) {
            return 0;
        }
        //将每个站点所在的线路存放到map中，以站点为键值，站点所在路线的list为value
        for(int i = 0;i < M;i++)
        {
            for(int j = 0;j < routes[i].length;j++)
            {
                LinkedList<Integer> te = new LinkedList<>();
                te = map.getOrDefault(routes[i][j],te);
                te.add(i);
                map.put(routes[i][j],te);
            }
        }
        //如果目标站点不在map中，去不了
        if(!map.containsKey(target)) {
            return -1;
        }
        //将起点所包含的路线加入到queue队列中
        for(int cd1 : map.get(source)) {
            queue.offer(new int[]{cd1,0});
        }
        //只要还有可选的路线，就一直重复以下操作
        while(!queue.isEmpty()) {
            //取queue队首的<路线,转车次数>
            int[] rou = queue.poll();
            //如果该路线没有来过
            if (!set.contains(rou[0])) {
                //去这个路线并将它标记为来过（放入set中）
                set.add(rou[0]);
                //遍历路线中的站点
                for (int k = 0; k < routes[rou[0]].length; k++) {
                    //如果站点没有来过
                    if (!set1.contains(routes[rou[0]][k])) {
                        //去这个站点，如果它就等于target，返回转车数
                        if (routes[rou[0]][k] == target) {
                            return rou[1]+1;
                        }
                        else {
                            //不等于target，去这个站点并标记为来过（放入set1）
                            set1.add(routes[rou[0]][k]);
                            //遍历该站点能去的路线
                            for (int cd : map.get(routes[rou[0]][k])) {
                                //如果这个站点能去的路线存在未去过的路线
                                if (!set.contains(cd)) {
                                    //把这些未去过的路线添加到queue队列中，同时转车数+1
                                    queue.offer(new int[]{cd,rou[1]+1});
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

}
