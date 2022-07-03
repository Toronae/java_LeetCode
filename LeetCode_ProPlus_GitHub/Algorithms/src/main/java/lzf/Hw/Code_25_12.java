package lzf.Hw;

import java.util.Arrays;

public class Code_25_12 {
    public static void main(String[] args) {
        int n = 5,m=5;
        String s = "HELLOWORLD";
        char[][] input = {{'C','P','U','C','Y'},{'E','K','L','Q','H'},{'C','H','E','L','L'},{'L','R','O','W','O'},{'D','G','R','B','C'}};
        int[] ans = solution(n,m,s,input);
        if (ans[0] == -1){
            System.out.println("No");
        }else {
            System.out.println(Arrays.toString(ans));
        }
    }

    private static int[] solution(int n, int m, String s, char[][] input) {
        int[] res = new int[2];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j]==s.charAt(0)){
                    if (dfs(input,s,i,j,0,visited)){
                        res[0] = i+1;
                        res[1] = j+1;
                        return res;
                    }
                }
            }
        }
        return new int[]{-1,-1};
    }

    private static boolean dfs(char[][] input, String s, int i, int j, int startIndex, boolean[][] visited) {
        if (startIndex == s.length()-1){
            return true;
        }
        if (input[i][j] != s.charAt(startIndex)){
            return false;
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir:dirs) {
            int nx = i + dir[0],ny = j+dir[1];
            if (nx>=0&&nx<input.length&&ny>=0&&ny<input[0].length){
                if (!visited[nx][ny]){
                    boolean flag = dfs(input, s, nx, ny, startIndex+1, visited);
                    if (flag){
                        res = true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }

}
