class Solution {
    public void setZeroes(int[][] matrix) {
    // int r = matrix.length;
    // int c = matrix[0].length;
    // boolean row[] = new boolean[r];
    // boolean col[] = new boolean[c];
    // for (int i = 0; i < r; i++) {
    //     for (int j = 0; j < c; j++) {
    //         if (matrix[i][j] == 0) {
    //             row[i] = true;
    //             col[j] = true;
    //         }
    //     }
    // }
    // for (int i = 0; i < r; i++) {
    //     for (int j = 0; j < c; j++) {
    //         if (row[i] || col[j]) {
    //             matrix[i][j] = 0;
    //         }
    //     }
    // }

    int r = matrix.length;
    int c = matrix[0].length;
    boolean check[][] = new boolean[r][c];
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (matrix[i][j] == 0 && check[i][j] == false) {
                Fill(i, j, matrix, check);
                check[i][j] = true;
            }
        }
    }
    }
        public static void Fill(int row, int col, int matrix[][], boolean check[][]) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] != 0 && check[row][i] == false) {
                matrix[row][i] = 0;
                check[row][i] = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0 && check[i][col] == false) {
                matrix[i][col] = 0;
                check[i][col] = true;
            }
        }
    }
}
