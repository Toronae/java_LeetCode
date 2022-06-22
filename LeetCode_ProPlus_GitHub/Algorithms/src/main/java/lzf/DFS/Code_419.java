package lzf.DFS;

public class Code_419 {
    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(new Code_419().countBattleships(board));
    }
    //每一艘战舰要么是竖着的，要么是横着的，而且两艘不同的战舰之间至少包含一个空格，
    // 也就是说每艘战舰的起点的上方和左方都不会是 'X'，所以，我们只需要统计起点即可

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int ans = 0;

        // 一次扫描
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 起点为X，左边不为X，上边不为X
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int countBattleships1(char[][] board) {
        int count=0,m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    dfs(board,i,j,m,n);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if(i<0||i>=m||j<0||j>=n||board[i][j]!='X') {
            return;
        }
        board[i][j]='.';
        dfs(board,i+1,j,m,n);
        dfs(board,i-1,j,m,n);
        dfs(board,i,j+1,m,n);
        dfs(board,i,j-1,m,n);
    }

}
