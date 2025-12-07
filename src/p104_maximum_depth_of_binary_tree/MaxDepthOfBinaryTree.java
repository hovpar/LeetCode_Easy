package p104_maximum_depth_of_binary_tree;

class MaxDepthOfBinaryTree {

	int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		} else {
			//false
//			if (root.right == null) {
//				return 1 + maxDepth(root.left);
//			} else {
//				return 1 + maxDepth(root.right);
//			}
			//return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
			
			//or
		    int leftDepth = maxDepth(root.left);
		    int rightDepth = maxDepth(root.right);

		    if (leftDepth > rightDepth) {
		        return 1 + leftDepth;
		    } else {
		        return 1 + rightDepth;
		    }

		}

	}
}
