package p766_toeplitz_matrix;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        for (int row = rows - 1; row > 0; row--) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
