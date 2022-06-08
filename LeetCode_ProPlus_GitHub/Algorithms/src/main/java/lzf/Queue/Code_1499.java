package lzf.Queue;

import java.util.Deque;
import java.util.LinkedList;

public class Code_1499 {
    public static void main(String[] args) {
        int[][] points = {{1,3},{2,0},{5,10},{6,-10}};
        int k =1;
        System.out.println(new Code_1499().findMaxValueOfEquation(points,k));
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for(int[] tmp : points) {
            while(!deque.isEmpty() && tmp[0] - deque.peekFirst()[0] > k){
                deque.pollFirst();
            }
            if(!deque.isEmpty()){
                res = Math.max(res, tmp[0] + tmp[1] + deque.peekFirst()[1] - deque.peekFirst()[0]);
            }
            while(!deque.isEmpty() && deque.peekLast()[1] - deque.peekLast()[0] <= tmp[1] - tmp[0]){
                deque.pollLast();
            }
            deque.offerLast(tmp);
        }
        return res;
    }
}
