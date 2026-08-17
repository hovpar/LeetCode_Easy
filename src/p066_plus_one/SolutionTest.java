package p066_plus_one;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest(name = "case {index}: {0}")
    @MethodSource("plusOneCases")
    @DisplayName("Adds one to the represented number")
    void shouldAddOne(int[] digits, int[] expected) {
        assertArrayEquals(expected, s.plusOne(digits));
    }

    private static Stream<Arguments> plusOneCases() {
        return Stream.of(
                // No carry
                Arguments.of(new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 }),
                Arguments.of(new int[] { 4, 3, 2, 1 }, new int[] { 4, 3, 2, 2 }),

                // Carry through trailing nines
                Arguments.of(new int[] { 1, 2, 9 }, new int[] { 1, 3, 0 }),
                Arguments.of(new int[] { 8, 9, 9, 9 }, new int[] { 9, 0, 0, 0 }),

                // Result requires an additional digit
                Arguments.of(new int[] { 9 }, new int[] { 1, 0 }),
                Arguments.of(new int[] { 9, 9 }, new int[] { 1, 0, 0 }),

                // Boundary cases
                Arguments.of(new int[] { 0 }, new int[] { 1 }),
                Arguments.of(new int[] { 1 }, new int[] { 2 }));
    }
}
