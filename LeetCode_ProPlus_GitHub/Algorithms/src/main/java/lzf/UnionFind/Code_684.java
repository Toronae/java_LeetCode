package lzf.UnionFind;

import java.util.Arrays;

public class Code_684 {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(new Code_684().findRedundantConnection(edges)));
    }
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind unionFind = new UnionFind(len+1);
        for(int i = 0;i<len;i++){
            if(unionFind.connected(edges[i][0],edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
            else{
                unionFind.union(edges[i][0],edges[i][1]);
            }
        }
        return new int[0];
    }
    class UnionFind {
        private int count; //记录连通分量
        private int[]parent; //节点x的根节点是parent[x]
        public UnionFind(int n){
            //一开始互不相通
            this.count=n;
            //一开始，每个节点是自己的父节点
            parent=new int[n];
            for (int i = 0; i <n ; i++) {
                parent[i]=i;
            }
        }
        /*
        将p和q连接, 如果两个节点被连通，那么则让其中的一个根节点连接到另一个节点的根节点上
        */
        public void union(int p,int q){
            int rootP=find(p);
            int rootQ=find(q);
            if(rootP==rootQ){
                return;
            }
            //将两颗树合并为一颗
            parent[rootP]=rootQ; //parent[rootQ]=rootP 效果是一样的
            count--; //两个分量合二为一
        }
        //返回某个节点x的根节点
        private int find(int x){
            //根节点的parent[x]==x
            while (parent[x]!=x){
                x=parent[x];
            }
            return x;
        }
        /*
         判断p和q是否连通:如果两个节点是连通的，那么他们一定拥有相同的根节点
         */
        public boolean connected(int p,int q){
            int rootP=find(p);
            int rootQ=find(q);
            return rootP==rootQ;
        }
        /*
        返回具体有多少个连通分量
         */
        public int count(){
            return count;
        }
    }
    /*public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }*/
}
