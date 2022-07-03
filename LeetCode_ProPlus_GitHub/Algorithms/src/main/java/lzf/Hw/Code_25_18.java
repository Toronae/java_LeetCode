package lzf.Hw;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://blog.csdn.net/qq_34465338/article/details/124497822
 */
public class Code_25_18 {
    public static void main(String[] args) {
        int n = 2;
        int[][] nums = {{1,0},{0,1}};
        if (solution(nums,n)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    private static boolean solution(int[][] nums, int n) {
        int[] inDegrees = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int[] temp = nums[i];
            inDegrees[temp[1]]++;
            //一个temp[0]可能有多个temp[1]
            list.get(temp[0]).add(temp[1]);
        }
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] ==0 ){
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int po = queue.poll();
            count++;
            for (int i: list.get(po)) {
                inDegrees[i] --;
                if (inDegrees[i] == 0){
                    queue.add(i);
                }
            }
        }
        return count == n;
    }
}
