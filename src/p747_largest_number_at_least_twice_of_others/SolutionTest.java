package p747_largest_number_at_least_twice_of_others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("dominantIndexTestCases")
    void shouldReturnDominantIndex(String description, int[] nums, int expected) {
        assertEquals(expected, s.dominantIndex(nums));
    }

    static Stream<Arguments> dominantIndexTestCases() {
        return Stream.of(
                Arguments.of("maximum is at the beginning", new int[] { 12, 3, 1 }, 0),
                Arguments.of("maximum is in the middle", new int[] { 3, 6, 1, 0 }, 1),
                Arguments.of("maximum is at the end", new int[] { 1, 2, 4 }, 2),
                Arguments.of("maximum is exactly twice the second maximum", new int[] { 3, 6 }, 1),
                Arguments.of("maximum is greater than twice the second maximum", new int[] { 1, 10, 2 }, 1),
                Arguments.of("no dominant element", new int[] { 1, 2, 3, 4 }, -1),
                Arguments.of("single element", new int[] { 1 }, 0),
                Arguments.of("single zero", new int[] { 0 }, 0),
                Arguments.of("all zeros", new int[] { 0, 0, 0 }, 0),
                Arguments.of("maximum is zero", new int[] { 0, 0 }, 0),
                Arguments.of("large integer values", new int[] { 1, 1, Integer.MAX_VALUE }, 2));
    }

}
