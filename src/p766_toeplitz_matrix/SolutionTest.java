package p766_toeplitz_matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("toeplitzTestCases")
    void shouldDetermineWhetherMatrixIsToeplitz(String description, int[][] matrix, boolean expected) {
        assertEquals(expected, s.isToeplitzMatrix(matrix));
    }

    static Stream<Arguments> toeplitzTestCases() {
        return Stream.of(
                Arguments.of(
                        "valid rectangular matrix",
                        new int[][] { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } },
                        true),
                Arguments.of("invalid rectangular matrix", new int[][] { { 1, 2 }, { 2, 2 } }, false),
                Arguments.of("valid square matrix", new int[][] { { 1, 2, 3 }, { 4, 1, 2 }, { 5, 4, 1 } }, true),
                Arguments.of("single row", new int[][] { { 1, 2, 3, 4 } }, true),
                Arguments.of("single column", new int[][] { { 1 }, { 2 }, { 3 }, { 4 } }, true),
                Arguments.of("single element", new int[][] { { 42 } }, true),
                Arguments.of("all elements are equal", new int[][] { { 5, 5, 5 }, { 5, 5, 5 }, { 5, 5, 5 } }, true),
                Arguments.of("different diagonal values", new int[][] { { 1, 2, 3 }, { 4, 5, 2 }, { 6, 4, 1 } }, false),
                Arguments.of(
                        "mismatch on the main diagonal",
                        new int[][] { { 1, 2, 3 }, { 4, 9, 2 }, { 5, 4, 1 } },
                        false),
                Arguments.of(
                        "mismatch on an upper diagonal",
                        new int[][] { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 8, 2 } },
                        false),
                Arguments.of("negative values", new int[][] { { -1, -2, -3 }, { -4, -1, -2 }, { -5, -4, -1 } }, true),
                Arguments.of(
                        "maximum and minimum integer values",
                        new int[][] { { Integer.MAX_VALUE, Integer.MIN_VALUE }, { 0, Integer.MAX_VALUE } },
                        true));
    }
}
