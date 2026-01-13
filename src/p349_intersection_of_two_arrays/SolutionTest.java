package p349_intersection_of_two_arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
    void testSingleIntersection() {
        int[] expected = { 2 };
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

    @Test
    void testMultipleIntersection() {
        int[] expected = { 4, 9 };
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

    @Test
    void testNoIntersection() {
        int[] expected = {};
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = { 2, 4, 6 };
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

    @Test
    void testAllElementsSame() {
        int[] expected = { 1 };
        int[] nums1 = { 1, 1, 1 };
        int[] nums2 = { 1, 1 };
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

    @Test
    void testEmptyFirstArray() {
        int[] expected = {};
        int[] nums1 = {};
        int[] nums2 = { 1, 2, 3 };
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

    @Test
    void testEmptySecondArray() {
        int[] expected = {};
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = {};
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

    @Test
    void testBothEmpty() {
        int[] expected = {};
        int[] nums1 = {};
        int[] nums2 = {};
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

    @Test
    void testNegativeNumbers() {
        int[] expected = { -2, -1 };
        int[] nums1 = { -1, -2, -3 };
        int[] nums2 = { -2, -1, 0 };
        assertArrayEqualsIgnoreOrder(expected, s.intersection(nums1, nums2));
    }

}
