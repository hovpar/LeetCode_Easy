package _111MinDepthOfBinTree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			int depth = 1;

			while (!queue.isEmpty()) {
				int levelSize = queue.size();

				for (int i = 0; i < levelSize; i++) {
					TreeNode node = queue.poll();

					if (node.left == null && node.right == null) {
						return depth;
					}

					if (node.left != null) {
						queue.offer(node.left);
					}

					if (node.right != null) {
						queue.offer(node.right);
					}

				}

				depth++;
			}
			return depth;
		}

	}
}
