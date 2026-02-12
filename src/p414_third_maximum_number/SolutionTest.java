package p414_third_maximum_number;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsThirdMaximum_whenArrayIsStrictlyDecreasing() {
        int[] nums = { 3, 2, 1 };
        assertEquals(1, s.thirdMax(nums));
    }

    @Test
    void returnsMaximum_whenArrayHasLessThanThreeDistinctValues() {
        int[] nums = { 1, 2 };
        assertEquals(2, s.thirdMax(nums));
    }

    @Test
    void ignoresDuplicates_whenFindingThirdMaximum() {
        int[] nums = { 2, 2, 3, 1 };
        assertEquals(1, s.thirdMax(nums));
    }

    @Test
    void handlesAllNegativeNumbersCorrectly() {
        int[] nums = { -1, -2, -3 };
        assertEquals(-3, s.thirdMax(nums));
    }

    @Test
    void returnsMaximum_whenAllValuesAreEqual() {
        int[] nums = { 5, 5, 5 };
        assertEquals(5, s.thirdMax(nums));
    }

    @Test
    void returnsThirdMaximum_withMixedPositiveAndNegativeValues() {
        int[] nums = { -10, 7, 3, 7, -10, 5 };
        assertEquals(3, s.thirdMax(nums));
    }

    @Test
    void returnsThirdMaximum_whenZeroIsPresent() {
        int[] nums = { 0, 1, 2 };
        assertEquals(0, s.thirdMax(nums));
    }

    @Test
    void returnsMaximum_whenExactlyTwoDistinctValuesExist() {
        int[] nums = { 2, 2, 1, 1 };
        assertEquals(2, s.thirdMax(nums));
    }

    @Test
    void handlesIntegerMinValueCorrectly() {
        int[] nums = { Integer.MIN_VALUE, 1, 2 };
        assertEquals(Integer.MIN_VALUE, s.thirdMax(nums));
    }

}
