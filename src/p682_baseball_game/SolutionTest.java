package p682_baseball_game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution s = new Solution();

    @MethodSource("testCases")
    @ParameterizedTest
    void shouldCalculateCorrectScore(String[] operations, int expected) {
        assertEquals(expected, s.calPoints(operations));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                // Official examples
                arguments(new String[] { "5", "2", "C", "D", "+" }, 30),
                arguments(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }, 27),
                arguments(new String[] { "1", "C" }, 0),

                // Individual operations
                arguments(new String[] { "7" }, 7),
                arguments(new String[] { "3", "D" }, 9),
                arguments(new String[] { "3", "4", "+" }, 14),
                arguments(new String[] { "3", "4", "C" }, 3),

                // Negative scores
                arguments(new String[] { "-5" }, -5),
                arguments(new String[] { "-5", "D" }, -15),
                arguments(new String[] { "-5", "2", "+" }, -6),

                // Repeated operations
                arguments(new String[] { "1", "2", "D", "D" }, 15),
                arguments(new String[] { "1", "2", "C", "C" }, 0),
                arguments(new String[] { "1", "2", "+", "+" }, 11),

                // Zero scores
                arguments(new String[] { "0" }, 0),
                arguments(new String[] { "0", "D" }, 0),
                arguments(new String[] { "5", "5", "C", "C" }, 0),

                // Cancellation and mixed operations
                arguments(new String[] { "5", "-5", "+" }, 0),
                arguments(new String[] { "10", "-2", "D", "+", "C" }, 4));
    }
}
