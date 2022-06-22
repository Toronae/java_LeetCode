package lzf.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_802 {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{}};
        System.out.println(new Code_802().eventualSafeNodes(graph));
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 反图，邻接表存储
        List<List<Integer>> new_graph = new ArrayList<List<Integer>>();
        // 节点入度
        int[] Indeg = new int[n];
        for(int i = 0; i < n; i++) {
            new_graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                new_graph.get(graph[i][j]).add(i);
            }
            // 原数组记录的节点出度，在反图中就是入度
            Indeg[i] = graph[i].length;
        }

        // 拓扑排序
        Queue<Integer> q = new LinkedList<Integer>();

        // 首先将入度为 0 的点存入队列
        for(int i = 0; i < n; i++) {
            if(Indeg[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            // 每次弹出队头元素
            int cur = q.poll();
            for(int x : new_graph.get(cur)) {
                // 将以其为起点的有向边删除，更新终点入度
                Indeg[x]--;
                if(Indeg[x] == 0) q.offer(x);
            }
        }

        // 最终入度（原图中出度）为 0 的所有点均为安全点
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if(Indeg[i] == 0) {
                ret.add(i);
            }
        }
        return ret;
    }

    //DFS+记忆化搜索
    /*boolean[] visited; // 记录访问过的节点
    boolean[] OK; // 记录该节点是否是安全节点--默认false
    List<Integer> lastNode;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> list = new ArrayList<>(); // 存储结果
        lastNode = new ArrayList<>();
        visited = new boolean[n];
        OK = new boolean[n];

        // 第一个for循环是找到终端节点
        for (int i = 0; i < n; i++) {
            if(graph[i].length == 0){
                lastNode.add(i);
                visited[i] = true;
                OK[i] = true;
            }
        }

        // 第二个for循环是遍历所有节点，并且用DFS+记忆化搜索来判断是否是安全节点
        for (int i = 0; i < n; i++) {
            if(DFS(graph, i)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean DFS(int[][] graph, int start){
        // 如果被拜访过 直接返回该节点是否是安全节点
        if(visited[start]){
            return OK[start];
        }
        // 进来就标记，这是因为可能存在环，如果我们进来就标记了，后面出现重复遍历的时候，因为我们是用DFS，所以我们就知道该节点是在一个环路中的
        visited[start] = true;
        for (int i : graph[start]) {
            // 判断是否有一条路径不能到达终端节点，只要有一条不满足就直接返回，并且把该节点标记为false
            if(!DFS(graph, i)){
                OK[start] = false;
                return false;
            }
        }
        OK[start] = true;
        return true;
    }*/
}
