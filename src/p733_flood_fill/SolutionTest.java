package p733_flood_fill;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldFillConnectedPixels() {
        int[][] input = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

        int[][] expected = { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } };

        assertArrayEquals(expected, s.floodFill(input, 1, 1, 2));
    }

    @Test
    void shouldReturnOriginalImageWhenColorsAreEqual() {
        int[][] input = { { 0, 0, 0 }, { 0, 0, 0 } };

        int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 } };

        assertArrayEquals(expected, s.floodFill(input, 0, 0, 0));
    }

    @Test
    void shouldFillSinglePixelImage() {
        int[][] input = { { 1 } };
        int[][] expected = { { 2 } };

        assertArrayEquals(expected, s.floodFill(input, 0, 0, 2));
    }

    @Test
    void shouldFillEntireImage() {
        int[][] input = { { 1, 1 }, { 1, 1 } };

        int[][] expected = { { 2, 2 }, { 2, 2 } };

        assertArrayEquals(expected, s.floodFill(input, 0, 0, 2));
    }

    @Test
    void shouldFillOnlyConnectedPixels() {
        int[][] input = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };

        int[][] expected = { { 2, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };

        assertArrayEquals(expected, s.floodFill(input, 0, 0, 2));
    }

    @Test
    void shouldFillSingleRow() {
        int[][] input = { { 1, 1, 0, 1, 1 } };
        int[][] expected = { { 2, 2, 0, 1, 1 } };

        assertArrayEquals(expected, s.floodFill(input, 0, 0, 2));
    }

    @Test
    void shouldFillSingleColumn() {
        int[][] input = { { 1 }, { 1 }, { 0 }, { 1 }, { 1 } };

        int[][] expected = { { 2 }, { 2 }, { 0 }, { 1 }, { 1 } };

        assertArrayEquals(expected, s.floodFill(input, 0, 0, 2));
    }

    @Test
    void shouldFillConnectedPixelsFromBottomRightCorner() {
        int[][] input = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        int[][] expected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 2 } };

        assertArrayEquals(expected, s.floodFill(input, 2, 2, 2));
    }

    @Test
    void shouldHandleNegativeColors() {
        int[][] input = { { -1, -1 }, { -1, 0 } };

        int[][] expected = { { -2, -2 }, { -2, 0 } };

        assertArrayEquals(expected, s.floodFill(input, 0, 0, -2));
    }
}
