package lzf.BFS;

import java.util.PriorityQueue;

/**
 * 邻接矩阵
 * Kruskal ，prim
 * kruskal算法就是贪心的将最小的&&属于不同联通分量的边加进来，直到个数达标。并查集的作用是判断属不属于同个联通分量
 */
public class Code_1584 {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(new Code_1584().minCostConnectPoints(points));
    }
    //prim
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // 典型稠密图，邻接矩阵存图。
        // 注意，用什么存图，和是否自定义Node没有关系。取决于图的疏密程度。
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            g[i][i] = 0;
            for (int j = i + 1; j < n; j++) {
                g[i][j] = g[j][i] = Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);
            }
        }

        // 和最短路径一样，用这两个数据结构就够了
        int[] dis = g[0]; // 0 表示已遍历，大于0表示 距离已遍历点群的最短距离
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            heap.add(new Node(i, dis[i]));
        }

        // 开始遍历
        int rs = 0;
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if(dis[node.val] == 0) {
                // Java 优先队列没有删除方法，使用延迟删除：遇到遍历过的点就跳过。
                continue;
            }
            dis[node.val] = 0;
            rs += node.dis;

            for(int i = 0; i < dis.length; i++) {
                if(dis[i] == 0) {
                    continue;
                }
                // 新距离是到刚加入的点的距离 g[node.val][i]。
                // 如果是最短路径，还要加上 刚加入的点到起点的距离 node.val。
                int newDis = g[node.val][i];
                if(newDis < dis[i]) {
                    dis[i] = newDis;
                    // 更新的话，直接再存一个，反正有延迟删除
                    heap.add(new Node(i, newDis));
                }
            }
        }

        return rs;
    }
    // 和 Dijkstra 一样，堆优化都必须自定义数据结构（Java中）
    class Node implements Comparable<Node> {
        int val;
        int dis;

        public Node(int v, int d) {
            val = v;
            dis = d;
        }

        @Override
        public int compareTo(Node node) {
            if (dis == node.dis) {
                return val - node.val; // 养成习惯，不轻易定义相等
            }
            return dis - node.dis;
        }
    }

    //Kruskal
    public int minCostConnectPoints1(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b)->a[2]-b[2] );
        int n = points.length;
        for(int i = 0; i < n; i++ ){
            for(int j = i+1; j < n; j++ ){
                int xi = points[i][0]; int yi = points[i][1];
                int xj = points[j][0]; int yj = points[j][1];
                int[] edge = new int[]{i, j, Math.abs(xi-xj) + Math.abs(yi-yj) };
                pq.offer(edge);
            }
        }

        UF uf = new UF(n);
        int weigth  = 0;
        while( !pq.isEmpty() ){
            if( uf.count == 1 ){
                return weigth;
            }
            int[] edge = pq.poll();
            int p = edge[0];
            int q = edge[1];
            if( uf.connected(p,q) ){
                continue;
            }
            uf.union(p, q );
            weigth += edge[2];
        }
        return weigth;
    }

    static class UF{
        int[] parent;
        public int count;

        public UF(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++ ){
                parent[i] = i;
            }
            this.count = n;
        }

        public int find(int p){
            if( p !=parent[p] ){
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q){
            parent[find(p)] = find(q);
            count--;
        }

        public boolean connected(int p, int q){
            return find(p) == find(q);
        }
    }
}
