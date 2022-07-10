package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * 某通信网络中有N个网络结点，用1到N进行标识。网络中的结点互联互通，且结点之间的消息传递有时延，相连结点的时延均为一个时间单位。
 * 现给定网络结点的连接关系link[i]={u,v}，其中u和v表示网络结点。
 * 当指定一个结点向其他结点进行广播，所有被广播结点收到消息后都会在原路径上回复一条响应消息，请计算发送结点至少需要等待几个时间单位才能收到所有被广播结点的响应消息。
 * 注：
 * 1、N的取值范围为[1,100]；
 * 2、连接关系link的长度不超过3000，且1 <= u,v <= N；
 * 3、网络中任意结点间均是可达的；
 * 输入描述:
 * 输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的长度I；
 * 接下来的I行输入，表示结点间的连接关系列表；
 * 最后一行的输入为一个正整数，表示指定的广播结点序号；
 * 输出描述:
 * 输出一个整数，表示发送结点接收到所有响应消息至少需要等待的时长。
 * 示例1
 * 输入
 * 5 7
 * 2 1
 * 1 4
 * 2 4
 * 2 3
 * 3 4
 * 3 5
 * 4 5
 * 2
 * 输出
 * 4
 * 说明
 * 2到5的最小时延是2个时间单位，而2到其他结点的最小时延是1个时间单位，所以2收到所有结点的最大响应时间为2*2=4。
 */
public class Code_最长广播响应 {
    private static int[][] arr;//邻接表
    private static int[] dis;//表示从某个点到其他点位的最小距离
    private static boolean[] mark;
    private static int from;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nms = sc.nextLine().split(" ");
        int count = Integer.parseInt(nms[0]);
        int line = Integer.parseInt(nms[1]);
        arr = new int[count+1][count+1];
        for (int i = 0; i < line; i++) {
            String[] dis = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(dis[0]);
            int y1 = Integer.parseInt(dis[1]);
            arr[x1][y1] = 1;
        }
        from = Integer.parseInt(sc.nextLine());//从哪个点开始广播
        dis = new int[count+1];
        for (int i = 0; i <= count; i++) {
            if (i == from){
                dis[i] = 0;
            }else {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        mark = new boolean[count+1];
        calcTls(from,count);
    }

    private static void calcTls(int local,int count){
        //广播的点初始化距离
        mark[local] = true;
        for (int i = 1; i <= count; i++) {
            if (arr[local][i] != 0){
                dis[i] = arr[local][i];
            }
        }

        int used = 0;
        while (used< count){
            //计算下一个加入进来的坐标
            int tempLocal = 0;
            int distMin = Integer.MAX_VALUE;
            for (int i = 1; i <= count; i++) {
                //距离最近的点先加进来
                if (!mark[i] && dis[i] < distMin){
                    distMin = dis[i];
                    tempLocal = i;
                }
            }
            local = tempLocal;

            //逐个点的加入到图中
            mark[local] = true;
            for (int i = 1; i <= count; i++) {
                if (arr[local][i] != 0){
                    dis[i] = Math.min(dis[local] + arr[local][i],dis[i]);
                }
            }
            used++;
        }
        int maxDis = Integer.MIN_VALUE;
        for (int i = 1; i <= count; i++) {
            System.out.println(from + "到" + i + "的距离" + dis[i]);
            maxDis = Math.max(maxDis,dis[i]);
        }
        System.out.println(maxDis * 2);//时间要花双倍
    }

}
//ddijkstra
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        ArrayList<Edge>[] head = new ArrayList[n+1];
        int[] dis = new int[n+1];
        boolean[] vit = new boolean[n+1];
        for(int i=1;i<=n;++i){
            dis[i]=1000;
            vit[i]=false;
            head[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<m;++i){
            int from = in.nextInt(), to = in.nextInt();
            addEdge(from, to, head);
            addEdge(to, from, head);
        }
        int start = in.nextInt();
        dis[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->(a.value-b.value));
        q.add(new Node(start,dis[start]));
        while(!q.isEmpty()){
            int i = q.poll().key;
            if(vit[i]) continue;
            vit[i]=true;
            for(int j=0;j<head[i].size();++j){
                Edge edge = head[i].get(j);
                int x = edge.to;
                if(dis[i]+edge.dis<dis[x]){
                    dis[x]=dis[i]+edge.dis;
                    q.add(new Node(x,dis[x]));
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;++i){
            max = Math.max(max, dis[i]);
        }
        System.out.println(max*2);
    }
    public static void addEdge(int from, int to, ArrayList<Edge>[] head){
        Edge edge = new Edge(to);
        head[from].add(edge);
    }
}
class Edge{
    int to;
    int dis=1;

    public Edge(int to){
        this.to = to;
    }
}
class Node{
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}*/
