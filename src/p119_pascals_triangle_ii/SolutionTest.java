package p119_pascals_triangle_ii;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void testFirstRow() {
        List<Integer> expected = List.of(1);
        assertEquals(expected, solution.getRow(0));

    }

    @Test
    void testFirstTwoRow() {
        List<Integer> expected = List.of(1, 1);
        assertEquals(expected, solution.getRow(1));

    }

    @Test
    void testThirdRow() {
        List<Integer> expected = List.of(1, 2, 1);
        assertEquals(expected, solution.getRow(2));

    }

    @Test
    void testFourthRow() {
        List<Integer> expected = List.of(1, 4, 6, 4, 1);
        assertEquals(expected, solution.getRow(4));

    }
}
