package p561_array_partition;

import java.util.Arrays;

class Solution {
	
	int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		var result = 0;
		
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}
}
