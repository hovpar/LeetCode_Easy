package p762_prime_number_of_set_bits_in_binary_representation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("primeSetBitsTestCases")
    void shouldCountNumbersWithPrimeSetBits(String description, int left, int right, int expected) {
        assertEquals(expected, s.countPrimeSetBits(left, right));
    }

    static Stream<Arguments> primeSetBitsTestCases() {
        return Stream.of(
                Arguments.of("first example", 6, 10, 4),
                Arguments.of("second example", 10, 15, 5),
                Arguments.of("single number with prime set bits", 3, 3, 1),
                Arguments.of("single number with non-prime set bits", 15, 15, 0),
                Arguments.of("range containing no prime set bit counts", 1, 2, 0),
                Arguments.of("range containing one qualifying number", 1, 4, 1),
                Arguments.of("range containing multiple qualifying numbers", 8, 15, 6),
                Arguments.of("number with five set bits", 31, 31, 1),
                Arguments.of("number with seven set bits", 127, 127, 1),
                Arguments.of("number with four set bits", 15, 15, 0));
    }

}
