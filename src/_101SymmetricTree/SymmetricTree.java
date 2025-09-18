package _101SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

class SymmetricTree {
	
	//recursive approach

//	boolean isSymmetric(TreeNode root) {	
//		return root == null || isMirrorTree(root.left, root.right);
//	}
//	private boolean isMirrorTree(TreeNode p, TreeNode q) {
//		if (p == null || q == null) {
//			return p == q;
//		}
//		return p.val == q.val && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
//	}
	
	
	//iterative approach
    boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            var p = queue.poll();
            var q = queue.poll();

            if (p == null && q == null) continue;
            if (p == null || q == null || p.val != q.val) return false;

            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }

        return true;
    }
}
