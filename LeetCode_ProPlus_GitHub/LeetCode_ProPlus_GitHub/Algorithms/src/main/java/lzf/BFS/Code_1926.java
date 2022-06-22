package lzf.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Code_1926 {
    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};
        System.out.println(new Code_1926().nearestExit(maze,entrance));
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        //bfs查找出口
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        int m = maze.length;
        int n= maze[0].length;
        //队列保存坐标
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int res = 0;
        //广度优先遍历
        while(!queue.isEmpty()) {
            int len = queue.size();
            res++;
            for(int i=0;i<len;i++) {
                int[] site = queue.poll();
                int x= site[0],y=site[1];
                for(int[] dir:dirs) {
                    int row = dir[0]+x;
                    int column = dir[1]+y;
                    if(row>=0&&column>=0&&row<m&&column<n) {
                        if(maze[row][column]=='.') {
                            maze[row][column] = '+';
                            queue.add(new int[] {row,column});
                        }
                    }else if(res>1){
                        return res-1;
                    }
                }
            }
        }
        return -1;
    }
}
