package _35SearchInsertPosition;

class SearchInsertPosition {
	static int searchInsert(int[] nums, int target) {

		var start = 0;
		var end = nums.length - 1;

		while (start <= end) {
			var mid = (start + end) / 2;
			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}

		}
		return start;
	}
}
