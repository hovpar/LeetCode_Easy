package p463_island_perimeter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsPerimeterForLeetCodeExample() {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        assertEquals(16, s.islandPerimeter(grid));
    }

    @Test
    void returnsFourForSingleLandCell() {
        int[][] grid = { { 1 } };
        assertEquals(4, s.islandPerimeter(grid));
    }

    @Test
    void returnsFourForSingleLandCellInRow() {
        int[][] grid = { { 1, 0 } };
        assertEquals(4, s.islandPerimeter(grid));
    }

    @Test
    void returnsSixForTwoHorizontalLandCells() {
        int[][] grid = { { 1, 1 } };
        assertEquals(6, s.islandPerimeter(grid));
    }

    @Test
    void returnsSixForTwoVerticalLandCells() {
        int[][] grid = { { 1 }, { 1 } };
        assertEquals(6, s.islandPerimeter(grid));
    }

    @Test
    void returnsEightForTwoDiagonalLandCells() {
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        assertEquals(8, s.islandPerimeter(grid));
    }

    @Test
    void returnsEightForTwoByTwoSquareIsland() {
        int[][] grid = { { 1, 1 }, { 1, 1 } };
        assertEquals(8, s.islandPerimeter(grid));
    }

    @Test
    void returnsEightForThreeCellHorizontalLine() {
        int[][] grid = { { 1, 1, 1 } };
        assertEquals(8, s.islandPerimeter(grid));
    }

    @Test
    void returnsEightForThreeCellVerticalLine() {
        int[][] grid = { { 1 }, { 1 }, { 1 } };
        assertEquals(8, s.islandPerimeter(grid));
    }

    @Test
    void returnsTenForLShapedIsland() {
        int[][] grid = { { 1, 0 }, { 1, 0 }, { 1, 1 } };
        assertEquals(10, s.islandPerimeter(grid));
    }

    @Test
    void returnsTenForThreeByTwoRectangle() {
        int[][] grid = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        assertEquals(10, s.islandPerimeter(grid));
    }

    @Test
    void returnsFourForSingleLandCellAtBottomRightCorner() {
        int[][] grid = { { 0, 0 }, { 0, 1 } };
        assertEquals(4, s.islandPerimeter(grid));
    }

    @Test
    void returnsTwelveForThreeByThreeSquareIsland() {
        int[][] grid = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        assertEquals(12, s.islandPerimeter(grid));
    }

}
