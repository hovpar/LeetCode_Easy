package p661_image_smoother;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldSmoothSinglePixel() {
        assertArrayEquals(new int[][] { { 5 } }, s.imageSmoother(new int[][] { { 5 } }));
    }

    @Test
    void shouldSmoothSingleRow() {
        assertArrayEquals(new int[][] { { 1, 2, 2 } }, s.imageSmoother(new int[][] { { 1, 2, 3 } }));
    }

    @Test
    void shouldSmoothSingleColumn() {
        assertArrayEquals(new int[][] { { 1 }, { 2 }, { 2 } }, s.imageSmoother(new int[][] { { 1 }, { 2 }, { 3 } }));
    }

    @Test
    void shouldSmoothThreeByThreeImage() {
        int[][] img = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

        int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        assertArrayEquals(expected, s.imageSmoother(img));
    }

    @Test
    void shouldHandleDifferentNeighborhoodSizes() {
        int[][] img = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };

        int[][] expected = { { 137, 141, 137 }, { 141, 138, 141 }, { 137, 141, 137 } };

        assertArrayEquals(expected, s.imageSmoother(img));
    }

    @Test
    void shouldHandleLargerImage() {
        int[][] img = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        int[][] expected = { { 3, 4, 5, 5 }, { 5, 6, 7, 7 }, { 7, 8, 9, 9 } };

        assertArrayEquals(expected, s.imageSmoother(img));
    }

}
