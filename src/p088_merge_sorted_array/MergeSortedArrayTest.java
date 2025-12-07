package p088_merge_sorted_array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeSortedArrayTest {

	@Test
    void testTypicalCase() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeSortedArray.merge(nums1, 3, nums2, 3);
        int[] expected = {1, 2, 2, 3, 5, 6};

        assertArrayEquals(expected, nums1);
    }

    @Test
    void testNums2Empty() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        MergeSortedArray.merge(nums1, 3, nums2, 0);
        int[] expected = {1, 2, 3};

        assertArrayEquals(expected, nums1);
    }

    @Test
    void testNums1Empty() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        MergeSortedArray.merge(nums1, 0, nums2, 1);
        int[] expected = {1};

        assertArrayEquals(expected, nums1);
    }

    @Test
    void testSingleElementEach() {
        int[] nums1 = {1, 0};
        int[] nums2 = {2};
        MergeSortedArray.merge(nums1, 1, nums2, 1);
        int[] expected = {1, 2};

        assertArrayEquals(expected, nums1);
    }

    @Test
    void testAllElementsFromNums2Bigger() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        MergeSortedArray.merge(nums1, 3, nums2, 3);
        int[] expected = {1, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, nums1);
    }

    @Test
    void testAllElementsFromNums2Smaller() {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        MergeSortedArray.merge(nums1, 3, nums2, 3);
        int[] expected = {1, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, nums1);
    }

    @Test
    void testDuplicateElements() {
        int[] nums1 = {1, 2, 2, 0, 0, 0};
        int[] nums2 = {2, 3, 3};
        MergeSortedArray.merge(nums1, 3, nums2, 3);
        int[] expected = {1, 2, 2, 2, 3, 3};

        assertArrayEquals(expected, nums1);
    }

}
