package p001_two_sum;

class TwoSum {

	int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (var j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}
}
