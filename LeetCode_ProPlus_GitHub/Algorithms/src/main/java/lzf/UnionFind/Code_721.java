package lzf.UnionFind;

import java.util.*;

public class Code_721 {
    public static void main(String[] args) {

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 作用：存储每个邮箱属于哪个账户 ，同时 在遍历邮箱时，判断邮箱是否出现过[去重]
        // 格式：<邮箱，账户id>
        Map<String, Integer> emailToId = new HashMap<>();
        int n = accounts.size();//id个数
        UnionFind4 myUnion = new UnionFind4(n);
        for(int i = 0; i < n; i++){
            int num = accounts.get(i).size();
            for(int j = 1; j < num; j++){
                String curEmail = accounts.get(i).get(j);
                //当前邮箱没有出现过
                if(!emailToId.containsKey(curEmail)){
                    emailToId.put(curEmail, i);
                }else{//当前邮箱已经出现过，那么代表这两个用户是同一个
                    myUnion.union(i, emailToId.get(curEmail));
                }
            }
        }
        //进行完上面的步骤，同一个用户的所有邮箱已经属于同一个连通域了，但是就算在同一个连通域，不同的邮箱还是可能会对应不同的id
        // 作用： 存储每个账户下的邮箱
        // 格式： <账户id, 邮箱列表> >
        // 注意：这里的key必须是账户id，不能是账户名称，名称可能相同，会造成覆盖
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        //将同一个连通域内的邮箱对应到同一个id【也就是第一次出现的id，比如4、5在同一个连通域，那么这个连通域对应的id就是4】
        for(Map.Entry<String, Integer> entry : emailToId.entrySet()){
            int id = myUnion.find(entry.getValue());
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());
            idToEmails.put(id,emails);
        }
        //经过上面的步骤，已经做到了id和邮箱集合对应起来，接下来把用户名对应起来就可以了
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()){
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(entry.getKey()).get(0));//先添加用户名
            tmp.addAll(emails);
            res.add(tmp);
        }
        return res;
    }
}
class UnionFind4 {
    int[] parent;

    public UnionFind4(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
    /*Map<String, String> q;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        q = new HashMap<>();
        // 这个映射存储每个邮箱对应账户的名字
        Map<String, String> names = new HashMap<>();

        // 遍历所有账户构建并查集
        for(List<String> a : accounts) {
            for(int i = 1; i < a.size(); i++) {
                if(!q.containsKey(a.get(i))){
                    // 如果并查集中没有这个邮箱，则添加邮箱，其根元素就是本身
                    q.put(a.get(i), a.get(i));
                    // 添加该邮箱对应的账户名
                    names.put(a.get(i), a.get(0));
                }

                if(i > 1) {
                    // 并查集的合并操作，合并一个账户中的所有邮箱
                    q.put(find(a.get(i)), find(a.get(i - 1)));
                }
            }
        }

        // 暂时存储答案中的邮箱列表，每个键值对的键就是每个并查集集合的根元素
        Map<String, List<String>> temp = new HashMap<>();
        for(String email : q.keySet()) {
            // 获取当前邮箱对应并查集的根元素
            String root = find(email);
            // 将当前邮箱放入根元素对应的列表中
            if(!temp.containsKey(root)) {
                temp.put(root, new ArrayList<>());
            }
            temp.get(root).add(email);
        }

        // 将答案从映射中放到列表
        List<List<String>> res = new ArrayList();
        for(String root : temp.keySet()) {
            // 获取当前根元素对应的列表
            List<String> layer = temp.get(root);
            // 题目要求的排序
            Collections.sort(layer);
            // 添加姓名
            layer.add(0, names.get(root));
            // 将当前列表加入答案
            res.add(layer);
        }

        return res;
    }

    // 并查集查找模板函数，这里用字符串替换了之前的整型
    // find就是一个寻根归祖的方法，寻找当前元素最终将属于哪个根元素，这个根元素来表示一个联通集合
    // 如果x映射的值等于x，那就可以说明x是个根元素，例如一个集合中只有一个元素，那么它当然可以代表自己
    // 这样做可以让一个集合中的所有元素都能直接或者间接指向根元素，一个集合中只有一个元素的映射是本身
    private String find(String x) {
        // 判断x是不是就是一个根元素
        if(!q.get(x).equals(x)) {
            // x不是根，那就通过递归find函数来找到x映射的元素的根元素（寻根）
            // 找到根元素之后，通过put方法将x直接映射到根元素，这样就免去中间的多次递归（归祖）
            q.put(x, find(q.get(x)));
        }

        // 最终，x映射的元素就是x所在的集合的根元素，返回x的根元素
        return q.get(x);
    }*/




