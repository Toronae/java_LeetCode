package lzf.BFS;

public class Code_1958 {
    public static void main(String[] args) {

    }

    public boolean check(char[][] board, int r, int c, int dx, int dy, char color) {
        int x = r + dx;
        int y = c + dy;
        int step = 1;
        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (step == 1) {
                if (board[x][y] == '.' || board[x][y] == color) {
                    return false;
                }
            } else {
                if (board[x][y] == '.') {
                    return false;
                }
                if (board[x][y] == color) {
                    return true;
                }
            }
            step++;
            x += dx;
            y += dy;
        }
        return false;
    }

    public boolean checkMove(char[][] board, int r, int c, char color) {
        int[] dx = {1, 1, 0, -1, -1, 0, 1, -1};
        int[] dy = {0, 1, 1, 0, -1, -1,-1, 1};

        for (int k = 0; k < 8; k++) {
            if (check(board, r, c, dx[k], dy[k], color)) {
                return true;
            }
        }
        return false;
    }
}
