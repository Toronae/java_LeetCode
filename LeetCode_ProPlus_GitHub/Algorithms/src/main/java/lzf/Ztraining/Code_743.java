package lzf.Ztraining;

import org.w3c.dom.Node;

import java.util.*;

public class Code_743 {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4,k=2;
        System.out.println(new Code_743().networkDelayTime(times,n,k));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time:times) {
            int start = time[0],end = time[1],weight = time[2];
            graph[start].add(new int[]{end,weight});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance-o2.distance);
        queue.offer(new Node(k,0));
        dist[k] = 0;
        while (!queue.isEmpty()){
            Node currNode = queue.poll();
            if (currNode.distance > dist[currNode.id]){
                continue;
            }
            for (int[] temp:graph[currNode.id]) {
                int nextId = temp[0],nextDistance = temp[1];
                if (dist[nextId] > nextDistance + currNode.distance){
                    dist[nextId] = nextDistance + currNode.distance;
                    queue.offer(new Node(nextId,dist[nextId]));
                }
            }
        }
        int res = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res,dist[i]);
        }
        return res;
    }
    class Node{
        int id;
        int distance;
        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    /*int N = 101;
    int[][] w = new int[N][N];
    int INF = Integer.MAX_VALUE/2;

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
               w[i][j] = i==j ? 0 :INF;
            }
        }
        for (int[] temp:times) {
            int u = temp[0], v = temp[1], c = temp[2];
            w[u][v] = c;
        }
        floyd(n);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res,w[k][i]);
        }
        return res == INF ? -1 : res;
    }

    private void floyd(int n) {
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = Math.min(w[i][j],w[i][p]+w[p][j]);
                }
            }
        }
    }*/
}
