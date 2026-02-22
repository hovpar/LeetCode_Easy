package p448_find_all_numbers_disappeared_in_an_array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsMissingNumbersForTypicalCase() {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> expected = List.of(5, 6);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @Test
    void returnsSingleMissingNumber() {
        int[] nums = { 1, 1 };
        List<Integer> expected = List.of(2);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @Test
    void returnsEmptyListWhenNoNumbersMissing() {
        int[] nums = { 1, 2, 3, 4, 5 };
        List<Integer> expected = List.of();

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @Test
    void returnsAllExceptOneWhenAllElementsSame() {
        int[] nums = { 2, 2, 2, 2 };
        List<Integer> expected = List.of(1, 3, 4);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @Test
    void handlesSingleElementArrayPresent() {
        int[] nums = { 1 };
        List<Integer> expected = List.of();

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @Test
    void handlesAllNumbersMissingExceptOne() {
        int[] nums = { 1, 1, 1, 1, 1 };
        List<Integer> expected = List.of(2, 3, 4, 5);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @Test
    void worksWithLargeSequentialInput() {
        int n = 1000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        assertEquals(List.of(), s.findDisappearedNumbers(nums));
    }

}
