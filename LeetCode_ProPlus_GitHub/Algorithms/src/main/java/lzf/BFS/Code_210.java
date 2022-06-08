package lzf.BFS;

import java.util.*;

public class Code_210 {
    public static void main(String[] args) {
        int n = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(Arrays.toString(new Code_210().findOrder(n, prerequisites)));
    }
    // BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 统计节点的入度
        for(int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        // 将入度为0的点入队
        for(int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            res[idx++] = temp;
            // 修改节点入度
            for(int[] edge : prerequisites) {
                if (edge[1] == temp) {
                    input[edge[0]]--;
                    if (input[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        // 出现环了(res中没包括所有点, idx没走完)
        if(idx != numCourses) {
            return new int[] {};
        }
        return res;
    }
    /*List<List<Integer>> courses = new ArrayList<>(); // 保存依赖关系
    Set<Integer> studied = new HashSet<>(); // 已经学习过
    int[] r; // 结果集
    int ri = 0; // 结果集下标

    public int[] findOrder(int n, int[][] prerequisites) {
        r = new int[n];
        for(int i = 0; i < n; i++) {
            courses.add(new ArrayList<>());
        }

        for(int[] pq : prerequisites) {
            courses.get(pq[0]).add(pq[1]);
        }

        for(int i = 0; i < n; i++){
            if(!addSuc(i, courses.get(i))) {
                return new int[0]; // 深度优先添加i课程
            }
        }

        return r;
    }

    Set<Integer> used = new HashSet<>(); // 是否访问过（用来判断环）

    boolean addSuc(int p, List<Integer> cs){
        if(studied.contains(p)) {
            return true; // 已经学过
        }
        if(used.contains(p)) {
            return false; // 有环
        }

        used.add(p); // 记录访问路径
        for(int i : cs){
            if(!addSuc(i, courses.get(i))) {
                return false; // 有环
            }
        }

        used.remove(p); // 访问结束，移除访问路径

        r[ri++] = p; // 添加结果
        studied.add(p); // 添加已学课程
        return true;
    }*/
}
