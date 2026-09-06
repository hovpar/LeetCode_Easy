package p598_range_addition_ii;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void returnsOriginalAreaWhenThereAreNoOperations() {
        int[][] operations = {};

        assertEquals(9, solution.maxCount(3, 3, operations));
    }

    @Test
    void returnsAreaOfSmallestOperation() {
        int[][] operations = { { 2, 2 }, { 3, 3 } };

        assertEquals(4, solution.maxCount(3, 3, operations));
    }

    @Test
    void handlesDifferentRowAndColumnValues() {
        int[][] operations = { { 2, 3 }, { 1, 2 } };

        assertEquals(2, solution.maxCount(5, 5, operations));
    }

    @Test
    void handlesSingleOperation() {
        int[][] operations = { { 2, 3 } };

        assertEquals(6, solution.maxCount(5, 5, operations));
    }

    @Test
    void handlesOperationThatDoesNotReduceArea() {
        int[][] operations = { { 3, 3 }, { 3, 3 } };

        assertEquals(9, solution.maxCount(3, 3, operations));
    }

    @Test
    void handlesOperationsThatReduceOnlyOneDimension() {
        int[][] operations = { { 2, 5 }, { 2, 4 } };

        assertEquals(8, solution.maxCount(5, 5, operations));
    }

}
