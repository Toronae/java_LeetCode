package lzf.Matrix;

public class Code_36 {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] >= '0' && board[i][j] <= '9'){
                    if(!getEffective(i, j, board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean getEffective(int i, int j, char[][] board){
        // 验证一行
        for(int k = 0; k < board[i].length; k++){
            if(board[i][k] == board[i][j] && k != j){
                return false;
            }
        }
        // 验证一列
        for(int k = 0; k < board.length; k++){
            if(board[k][j] == board[i][j] && k != i){
                return false;
            }
        }
        // 验证当前 3 * 3 数组
        int heng = (i / 3) * 3;
        int zhong = (j / 3) * 3;

        for(int k1 = heng; k1 < heng + 3; k1++){
            for(int k2 = zhong; k2 < zhong + 3; k2++){
                if((board[k1][k2] == board[i][j]) && (k1 != i && k2 != j)){
                    return false;
                }
            }
        }

        return true;
    }
}
