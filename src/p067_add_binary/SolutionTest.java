package p067_add_binary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @MethodSource("binaryAdditionCases")
    @DisplayName("Adds two binary numbers")
    void shouldAddBinaryNumbers(String a, String b, String expected) {
        assertEquals(expected, Solution.addBinary(a, b));
    }

    private static Stream<Arguments> binaryAdditionCases() {
        return Stream.of(
                // Zero
                Arguments.of("0", "0", "0"),
                Arguments.of("11", "0", "11"),
                Arguments.of("0", "11", "11"),

                // No final carry
                Arguments.of("10", "1", "11"),
                Arguments.of("101", "10", "111"),
                Arguments.of("1010", "1011", "10101"),

                // Final carry
                Arguments.of("1", "1", "10"),
                Arguments.of("11", "1", "100"),
                Arguments.of("111", "1", "1000"),
                Arguments.of("1111", "1", "10000"),

                // Carry across several positions
                Arguments.of("111", "111", "1110"),
                Arguments.of("1111", "1111", "11110"),

                // Inputs of different lengths
                Arguments.of("1", "101010", "101011"),
                Arguments.of("101010", "1", "101011"));
    }
}
