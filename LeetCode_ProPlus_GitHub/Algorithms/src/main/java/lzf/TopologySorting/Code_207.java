package lzf.TopologySorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有向无环图，把一个 有向无环图 转成 线性的排序 就叫 拓扑排序,是专门应用于有向图的算法
 * 这道题用 BFS 和 DFS 都可以完成,BFS 的写法就叫「拓扑排序」
 * 邻接表
 */
public class Code_207 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites ={{1,0},{0,1}};
        System.out.println(new Code_207().canFinish(numCourses,prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //用于存储每个点（数字）的度
        int[] indegrees=new int[numCourses];
        //邻接表的准备
        List<List<Integer>> adjacency=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }//事先创建空的arraylist
        for(int[]cp:prerequisites){
            //cp[0]这个数前面连接了一个数cp[1]，所以度+1
            indegrees[cp[0]]++;
            //创建连接表,在cp[1]对应的位置,放入后连接的一个数字也就是cp[0],
            adjacency.get(cp[1]).add(cp[0]);
            //一个cp[0]可能对应多个cp[1],例如[2,3][2,4],list里的对应2的list便放入3,4两个数字，这里一定要理清楚
        }
        for(int i=0;i<numCourses;i++){
            //如果度为0入队列
            if(indegrees[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            //弹出度为0的数，其实也就是准备删除
            int pre=queue.poll();
            //删除后个数减少1，对应作者的图可以理解
            numCourses--;
            //找到入度0连接后面的数字们遍历，例如遍历上面2后连接的3,4
            for(int cur:adjacency.get(pre)){
                indegrees[cur]--;
                //并且将他们的入度同时-1，如果此时度为0，继续入队列
                if(indegrees[cur]==0){
                    queue.add(cur);
                }
            }
        }
        return numCourses==0;
    }

    // 深度优先遍历
    // 定义建立每个节点u对应的邻接表

    List<List<Integer>> edges;
    // 每个节点u的访问状态值数组（0：未搜索 1：搜索中 2：搜索完成）
    int[] visited;
    // 返回结果状态 默认是可以的（是否能构成拓扑排序）
    boolean valid = true;
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 邻接表初始化
        edges = new ArrayList<List<Integer>>();
        // 根据课程数量进一步初始化内层list
        for(int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        // 节点u个数就是numCourses个数
        visited = new int[numCourses];
        // 开始建立有向依赖关系（类似与哈希表的key-value映射关系 但是有方向）
        // 原数组每一个课程和其前置课程对应位置是info[0] <-- info[1]
        // 即要想完成课程info[0] 必须先完成课程info[1]
        // 这里在邻接表中我们让前置课程作为list的下标，对应的值存储的是当前课程，依次遍历prerequisites复制依赖关系
        for(int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 从第一个节点开始遍历探寻验证其有向邻接表是否能和他刚好组成一条从当前节点开始单向依次串联其他节点的拓扑排序
        // dfs前判断当前节点i是否访问过
        for(int i = 0; i < numCourses && valid; ++i) {
            if(visited[i] == 0) {
                dfs(i);
            }
        }
        // 等所有课程节点都尝试拓扑排序后如果都没有环（不存在矛盾的情况，或者中断）就返回true，否则返回false
        return valid;
    }

    private void dfs(int u) {
        // 当前正在尝试dfs找拓扑排序关系的节点u更换标记状态为1（搜索中）
        visited[u] = 1;
        // 遍历当前节点u的有向邻接表，dfs他的邻接节点v 有三种状态
        for(int v : edges.get(u)) {
            if(visited[v] == 0) {
                // 如果 v 为「未搜索」，那么我们开始搜索 v，待搜索完成回溯到 u
                dfs(v);
                if(!valid) {
                    return;
                }
            } else if(visited[v] == 1) {
                // 如果 v 为「搜索中」，那么我们就找到了图中的一个环，因此是不存在拓扑排序的
                valid = false;
                return;
            } // else {} // 如果 v 为「已完成」，那么说明 v 已经在栈中了，而 u 还不在栈中，因此 u 无论何时入栈
            // 都不会影响到 (u, v) 之前的拓扑关系，此时不用进行任何操作
        }
        // 当前节点u邻接表都访问完了还未发现环，证明从该节点出发的拓扑排序有效，更新其状态为已完成
        visited[u] = 2;
    }
}
