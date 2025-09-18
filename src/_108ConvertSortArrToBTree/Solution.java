package _108ConvertSortArrToBTree;

class Solution {
	TreeNode sortedArrayToBST(int[] nums) {

		return createBST(nums, 0, nums.length - 1);

	}

	TreeNode createBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		} else {
			var mid = left + (right - left) / 2;
			var root = new TreeNode(nums[mid]);
			root.left = createBST(nums, left, mid - 1);
			root.right = createBST(nums, mid + 1, right);
			return root;
		}
	}

}
