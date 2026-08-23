package p566_reshape_the_matrix;

class SolutionVariants {

    interface Solver {
        int[][] matrixReshape(int[][] mat, int r, int c);
    }

    static class FlattenThenReshapeSolver implements Solver {
        public int[][] matrixReshape(int[][] mat, int r, int c) {

            int m = mat.length, n = mat[0].length;
            if (m * n != r * c) {
                return mat;
            } else {
                int[][] output = new int[r][c];
                int[] temp = new int[m * n];
                int index = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        temp[index] = mat[i][j];
                        index++;
                    }
                }
                index = 0;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        output[i][j] = temp[index];
                        index++;
                    }
                }
                return output;
            }
        }
    }

    static class DirectIndexMappingSolver implements Solver {
        public int[][] matrixReshape(int[][] mat, int r, int c) {

            int m = mat.length, n = mat[0].length;
            if (m * n != r * c) {
                return mat;
            } else {
                int[][] output = new int[r][c];
                int index = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        //row = index / c;
                        //col = index % c;
                        output[index / c][index % c] = mat[i][j];
                        index++;
                    }
                }

                return output;
            }
        }
    }
}
