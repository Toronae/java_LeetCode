package lzf.BinarySearch;

public class Code_74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(new Code_74().searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col-1;
            while (left <= right) {
                int mid = left +(right-left)/2;
                if (matrix[i][mid] == target) {
                    return true;
                }else if (target > matrix[i][mid]) {
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return false;
    }

    // 暴力破解
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }*/
}
