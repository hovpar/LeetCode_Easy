package MergeSortedArray_88;

class MergeSortedArray {

	static void merge(int[] nums1, int m, int[] nums2, int n) {
	    var i = m - 1;         
        var j = n - 1;         
        var k = m + n - 1; //or
        //var k=nums1.length-1;

        while (j >= 0) {
            if (i < 0 || nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
	}
}
