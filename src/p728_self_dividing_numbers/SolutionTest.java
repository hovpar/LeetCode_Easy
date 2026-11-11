package p728_self_dividing_numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldFindSelfDividingNumbersFromOneToTwentyTwo() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);

        assertEquals(expected, s.selfDividingNumbers(1, 22));
    }

    @Test
    void shouldFindSelfDividingNumbersInRange() {
        List<Integer> expected = List.of(48, 55, 66, 77);

        assertEquals(expected, s.selfDividingNumbers(47, 85));
    }

    @Test
    void shouldHandleSingleSelfDividingNumber() {
        assertEquals(List.of(1), s.selfDividingNumbers(1, 1));
    }

    @Test
    void shouldReturnEmptyListWhenNoSelfDividingNumbersExist() {
        assertEquals(List.of(), s.selfDividingNumbers(20, 21));
    }

    @Test
    void shouldExcludeNumbersContainingZero() {
        assertEquals(List.of(11, 12, 15), s.selfDividingNumbers(10, 19));
    }

    @Test
    void shouldHandleSingleDigitNumbers() {
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), s.selfDividingNumbers(1, 9));
    }

    @Test
    void shouldHandleThreeDigitNumbers() {
        assertEquals(List.of(111, 112, 115, 122, 124, 126, 128), s.selfDividingNumbers(111, 130));
    }

    @Test
    void shouldHandleNumbersWithRepeatedDigits() {
        assertEquals(List.of(22, 24, 33, 36, 44, 48, 55, 66, 77, 88, 99), s.selfDividingNumbers(22, 99));
    }

}
