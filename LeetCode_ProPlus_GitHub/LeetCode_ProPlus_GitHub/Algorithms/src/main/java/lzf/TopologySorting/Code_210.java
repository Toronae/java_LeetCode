package lzf.TopologySorting;

import java.util.*;

public class Code_210 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites ={{1,0}};
        System.out.println(Arrays.toString(new Code_210().findOrder3(numCourses, prerequisites)));
    }
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 放入答案中
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

    // 方法 1 最简单的 BFS,
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();
            // 将可以学完的课程加入结果当中
            res[count++] = curr;
            for (int[] p : prerequisites) {
                if (p[1] == curr){
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0){
                        queue.offer(p[0]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

    // 方法 2：邻接矩阵 + DFS   由于用的数组，每次都要遍历，效率比较低

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        // 建立邻接矩阵
        int[][] graph = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            graph[p[1]][p[0]] = 1;
        }
        // 记录访问状态的数组，访问过了标记 -1，正在访问标记 1，还未访问标记 0
        int[] status = new int[numCourses];
        // 用栈保存访问序列
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            // 只要存在环就返回
            if (!dfs(graph, status, i, stack)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean dfs(int[][] graph, int[] status, int i, Stack<Integer> stack) {
        // 当前节点在此次 dfs 中正在访问，说明存在环
        if (status[i] == 1) {
            return false;
        }
        if (status[i] == -1) {
            return true;
        }

        status[i] = 1;
        for (int j = 0; j < graph.length; j++) {
            // dfs 访问当前课程的后续课程，看是否存在环
            if (graph[i][j] == 1 && !dfs(graph, status, j, stack)) {
                return false;
            }
        }
        // 标记为已访问
        status[i] = -1;
        stack.push(i);
        return true;
    }

    // 方法 2 升级版：用 HashSet 作为邻接矩阵，加速查找速度
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        // HashSet 作为邻接矩阵
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }
        int[] mark = new int[numCourses]; // 标记数组
        Stack<Integer> stack = new Stack<>(); // 结果栈
        for (int i = 0; i < numCourses; i++) {
            if(!isCycle(graph, mark, i, stack)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean isCycle(HashSet<Integer>[] graph, int[] mark, int i, Stack<Integer> stack) {
        if (mark[i] == -1) {
            return true;
        }
        if (mark[i] == 1) {
            return false;
        }

        mark[i] = 1;
        for (int neighbor : graph[i]) {
            if (!isCycle(graph, mark, neighbor, stack)) {
                return false;
            }
        }
        mark[i] = -1;
        stack.push(i);
        return true;
    }

}
