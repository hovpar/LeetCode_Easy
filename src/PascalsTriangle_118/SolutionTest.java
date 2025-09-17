package PascalsTriangle_118;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void testSingleRow() {
        List<List<Integer>> result = List.of(List.of(1));
        assertEquals(result, solution.generate(1));
    }

    @Test
    void testFirstTwoRows() {
        List<List<Integer>> result = List.of(List.of(1), List.of(1, 1));
        assertEquals(result, solution.generate(2));
    }

    @Test
    void testMultipleRows() {
        List<List<Integer>> result = List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1));

        assertEquals(result, solution.generate(5));
    }

    @Test
    void shouldHaveCorrectNumberOfRows() {
        int numRows = 7;
        List<List<Integer>> result = solution.generate(numRows);

        assertEquals(numRows, result.size());
    }

}
