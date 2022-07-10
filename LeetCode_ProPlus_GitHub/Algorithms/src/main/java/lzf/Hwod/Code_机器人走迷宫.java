package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * 1、 房间由XY的方格组成，例如下图为64的大小。每一个方格以坐标(x，y)描述。
 * 2、 机器人固定从方格(0，0)出发，只能向东或者向北前进。出口固定为房间的最东北角，如下图的方格(5，3)。用例保证机器人可以从入口走到出口。
 * 3、 房间有些方格是墙壁，如(4，1)，机器人不能经过那儿。
 * 4、 有些地方是一旦到达就无法走到出口的，如标记为B的方格，称之为陷阱方格。
 * 5、 有些地方是机器人无法到达的的，如标记为A的方格，称之为不可达方格，不可达方格不包括墙壁所在的位置。
 * 6、 如下示例图中，陷阱方格有2个，不可达方格有3个。
 * 7、 请为该机器人实现路径规划功能：给定房间大小、墙壁位置，请计算出陷阱方格与不可达方格分别有多少个。
 */
public class Code_机器人走迷宫 {
    private static int n1;
    private static int m1;
    private static int endX1;
    private static int endY1;
    private static int[][] arr;
    private static boolean[][] mark;
    private static int trip =0;

    public static void main(String[] args) {
        // BFS解决在不在一起的问题
        // DFS解决路径问题
        Scanner sc = new Scanner(System.in);
        String[] nms = sc.nextLine().split(" ");
        n1 = Integer.parseInt(nms[1]);
        m1 = Integer.parseInt(nms[0]);
        arr = new int[n1][m1];
        mark = new boolean[n1][m1];
        int x1 = n1 - 1;
        int y1 = 0;
        endX1 = 0;
        endY1 = m1 - 1;
        int wellCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < wellCount; i++) {
            String[] wall = sc.nextLine().split(" ");
            int weX1 = n1 -1 - Integer.parseInt(wall[1]);
            int weY1 = Integer.parseInt(wall[0]);
            arr[weX1][weY1] = 1;
        }
        arr[x1][y1] = 2;//初始化点位
        dfs(x1, y1);
        //遍历所有坐标 结果是0的就是A
        int unReach = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                if (arr[i][j] == 0){
                    unReach++;
                    System.out.println(i + ":" + j);
                }
            }
        }
        System.out.println(trip + " " + unReach);
    }

    private static boolean dfs(int x1,int y1){
        boolean flag = false;
        if (x1 == endX1 && y1 == endY1){
            return true;
        }
        int[][] next = {{-1,0},{0,1}};
        int nextX1 = 0;
        int nextY1 = 0;
        for (int i = 0; i < 2; i++) {
            nextX1 = x1 + next[i][0];
            nextY1 = y1 + next[i][1];
            if (nextX1 < 0 || nextY1 >=m1 ){
                continue;
            }
            if (arr[nextX1][nextY1] != 1 && !mark[nextX1][nextY1]){
                mark[nextX1][nextY1] = true;
                arr[nextX1][nextY1] = 2;//为了区别出未曾经过的坐标A
                boolean dfs = dfs(nextX1, nextY1);
                if (flag || dfs){
                    flag = true;
                }
                mark[nextX1][nextY1] = false;
            }
        }
        if (!flag){//坐标点B
            trip++;
            System.out.println(x1 + ":" + y1);
        }
        return flag;
    }
}
