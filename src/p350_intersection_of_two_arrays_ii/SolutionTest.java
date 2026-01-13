package p350_intersection_of_two_arrays_ii;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    // HashSet does not guarantee order.
    // assertArrayEquals may fail even for correct solutions.
    private void assertArrayEqualsIgnoreOrder(int[] expected, int[] actual) {
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testIntersectionWithDuplicates_preservesMultiplicity() {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] expected = { 2, 2 };
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testIntersectionWithMultipleMatchesAcrossArrays() {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        int[] expected = { 4, 9 };
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testAllElementsIntersect_identicalArrays() {
        int[] nums1 = { 3, 1, 2, 2 };
        int[] nums2 = { 3, 1, 2, 2 };
        int[] expected = { 1, 2, 2, 3 };
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testSingleElementIntersection_match() {
        int[] nums1 = { 7 };
        int[] nums2 = { 7 };
        int[] expected = { 7 };
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testSingleElementIntersection_noMatch() {
        int[] nums1 = { 7 };
        int[] nums2 = { 8 };
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testIntersectionWithNegativesAndZero() {
        int[] nums1 = { -1, 0, 0, 2 };
        int[] nums2 = { 0, 0, 0, -1 };
        int[] expected = { -1, 0, 0 };
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testNoIntersection_disjointSets() {
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = { 2, 4, 6 };
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testEmptyFirstArray_returnsEmpty() {
        int[] nums1 = {};
        int[] nums2 = { 1, 2, 3 };
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }

    @Test
    void testEmptySecondArray_returnsEmpty() {
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = {};
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, s.intersect(nums1, nums2));
    }
}
