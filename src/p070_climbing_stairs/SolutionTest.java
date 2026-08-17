package p070_climbing_stairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0} steps -> {1} ways")
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
            "4, 5",
            "5, 8",
            "6, 13",
            "10, 89",
            "20, 10946",
            "30, 1346269",
            "45, 1836311903" })
    @DisplayName("Returns the number of distinct ways to climb the stairs")
    void shouldReturnNumberOfWays(int steps, int expectedWays) {
        assertEquals(expectedWays, solution.climbStairs(steps));
    }
}
