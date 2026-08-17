package p035_search_insert_position;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{index}: target {1} should return index {2}")
    @MethodSource("searchInsertCases")
    @DisplayName("Returns the existing index or correct insertion position")
    void shouldReturnCorrectInsertPosition(int[] nums, int target, int expectedIndex) {
        assertEquals(expectedIndex, solution.searchInsert(nums, target));
    }

    private static Stream<Arguments> searchInsertCases() {
        return Stream.of(
                // Target already exists
                Arguments.of(new int[] { 1, 3, 5, 6 }, 1, 0),
                Arguments.of(new int[] { 1, 3, 5, 6 }, 5, 2),
                Arguments.of(new int[] { 1, 3, 5, 6 }, 6, 3),

                // Target should be inserted
                Arguments.of(new int[] { 1, 3, 5, 6 }, 0, 0),
                Arguments.of(new int[] { 1, 3, 5, 6 }, 2, 1),
                Arguments.of(new int[] { 1, 3, 5, 6 }, 4, 2),
                Arguments.of(new int[] { 1, 3, 5, 6 }, 7, 4),

                // Single-element arrays
                Arguments.of(new int[] { 5 }, 3, 0),
                Arguments.of(new int[] { 5 }, 5, 0),
                Arguments.of(new int[] { 5 }, 7, 1),

                // Negative values
                Arguments.of(new int[] { -10, -3, 0, 8 }, -5, 1),
                Arguments.of(new int[] { -10, -3, 0, 8 }, -3, 1),
                Arguments.of(new int[] { -10, -3, 0, 8 }, 10, 4));
    }
}
