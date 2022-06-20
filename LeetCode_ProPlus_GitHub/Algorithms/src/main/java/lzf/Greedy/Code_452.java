package lzf.Greedy;

import java.util.Arrays;

public class Code_452 {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(new Code_452().findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int res = 1;
        int pre = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;
    }
}
