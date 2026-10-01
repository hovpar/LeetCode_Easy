package p661_image_smoother;

class Solution {

    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[row][col] = calculateSmoothedPixel(img, row, col, rows, cols);
            }
        }

        return result;
    }

    private int calculateSmoothedPixel(int[][] img, int row, int col, int rows, int cols) {
        int sum = 0;
        int count = 0;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                //Checking the boundaries correctly handles corners and edges
                if (r < 0 || r >= rows || c < 0 || c >= cols) {
                    continue;
                }

                sum += img[r][c];
                count++;
            }
        }

        return sum / count;
    }

}
