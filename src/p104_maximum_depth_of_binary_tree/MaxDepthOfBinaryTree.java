package p104_maximum_depth_of_binary_tree;

class MaxDepthOfBinaryTree {

	int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		} else {

			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
			
			//or
//		    int leftDepth = maxDepth(root.left);
//		    int rightDepth = maxDepth(root.right);
//
//		    if (leftDepth > rightDepth) {
//		        return 1 + leftDepth;
//		    } else {
//		        return 1 + rightDepth;
//		    }

		}

	}
}
