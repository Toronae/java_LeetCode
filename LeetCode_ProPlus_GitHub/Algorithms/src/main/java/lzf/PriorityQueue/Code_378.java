package lzf.PriorityQueue;


import java.util.PriorityQueue;

public class Code_378 {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(new Code_378().kthSmallest(matrix,k));
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(((a,b)->a[0]-b[0]));
        int x=matrix.length;
        int y=matrix[0].length;
        for(int i=0;i<x;i++){
            queue.offer(new int[]{matrix[0][i],0,i});
        }
        int res=0;
        for(int i=0;i<k;i++){
            assert queue.peek() != null;
            int dx=queue.peek()[1];
            int dy=queue.peek()[2];
            res=queue.poll()[0];
            if(dx<y-1){
                queue.offer(new int[]{matrix[dx+1][dy],dx+1,dy});
            }
        }
        return res;
    }
}
