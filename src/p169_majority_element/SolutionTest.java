package p169_majority_element;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testWhenArrayHasTwoMajorityCandidates() {
        int[] nums = { 3, 2, 3 };
        assertEquals(3, solution.majorityElement(nums));
    }

    @Test
    void testWhenMajorityIsAtEnd() {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        assertEquals(2, solution.majorityElement(nums));
    }

    @Test
    void testWithSingleElementArray() {
        int[] nums = { 1 };
        assertEquals(1, solution.majorityElement(nums));
    }

    @Test
    void testWithAllElementsSame() {
        int[] nums = { 7, 7, 7, 7, 7 };
        assertEquals(7, solution.majorityElement(nums));
    }

    @Test
    void testWhenMajorityAppearsJustOverHalf() {
        int[] nums = { 5, 5, 5, 2, 2 };
        assertEquals(5, solution.majorityElement(nums));
    }

    @Test
    void testWhenArrayIsLargeAndMajorityInMiddle() {
        int[] nums = { 4, 1, 4, 2, 4, 3, 4, 4, 4 };
        assertEquals(4, solution.majorityElement(nums));
    }

}