package p228_summary_ranges;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void mergesContinuousValuesIntoSingleRanges() {
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        var expected = List.of("0->2", "4->5", "7");
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

    @Test
    void handlesMixedSingleValuesAndRanges() {
        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
        var expected = List.of("0", "2->4", "6", "8->9");
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

    @Test
    void testEmpty() {
        int[] nums = {};
        var expected = List.of();
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

    @Test
    void testSingleElement() {
        int[] nums = { 5 };
        var expected = List.of("5");
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

    @Test
    void testNoRanges() {
        int[] nums = { 1, 3, 5, 7 };
        var expected = List.of("1", "3", "5", "7");
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

    @Test
    void testOneBigRange() {
        int[] nums = { 1, 2, 3, 4, 5 };
        var expected = List.of("1->5");
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = { -3, -2, -1, 1, 2, 3 };
        var expected = List.of("-3->-1", "1->3");
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

    @Test
    void testLargeGaps() {
        int[] nums = { 0, 100, 200 };
        var expected = List.of("0", "100", "200");
        assertIterableEquals(expected, s.summaryRanges(nums));
    }

}
