package lzf.Hwod;

import java.util.ArrayList;

/**
 * http://dl2.kerwin.cn:8063/csdn/key/article-weixin_44219664-124029080/auth/1657356080-2022110616411952-0-799d8e715a73da7fb51348b96a7da0c6
 * 给定一个 n 个节点的邻接矩阵 m。 节点定义为城市，如果 a 城市与 b 城市相连， b 与 c 城市相连，尽管 a 与 c 并不直接相连，但可以认为 a 与 c 相连，定义 a,b,c 是一个城市群。
 * 矩阵 m[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，否则表示不相连。
 * 请你找出共有多少个城市群。
 *
 * 数据范围： \1≤n≤200 ， 矩阵中只包含0 和 1
 * 示例1
 * 输入
 * [[1,1,0],[1,1,0],[0,0,1]]
 * 输出
 * 2
 * 说明
 * 1 2 相连，3 独立，因此是 3 个城市群。
 * 示例2
 * 输入
 * [[1,1,0,0],[1,1,1,0],[0,1,1,0],[0,0,0,1]]
 * 输出
 * 2
 * 说明
 * 1 ， 2相连 ；2 ，3相连，4独立，因此是 1,2,3 属于一个城市群，4属于一个城市群。
 */
public class Code_找城市 {
    public static void main(String[] args) {

    }

    public int citys (ArrayList<ArrayList<Integer>> m) {
        int n = m.size();
        int k = m.get(0).size();
        int[] visited = new int[n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            System.out.println(i);
            if(visited[i] == 0){
                ans++;
                dfs(m,visited,i);
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> m,int[] visited,int node){
        visited[node] = 1;
        ArrayList<Integer> arr = m.get(node);
        for(int i = 0;i<arr.size();i++){
            if(arr.get(i)!=0 && visited[i] == 0){
                dfs(m,visited,i);
            }
        }
    }

}
