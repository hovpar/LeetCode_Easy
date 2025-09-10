package SameTree_100;

class SameTree {

//	static boolean isSameTree(TreeNode p, TreeNode q) {
//		
//		if(p == null && q==null) {
//			return true;
//		}
//
//		if (p == null && q != null || p != null && q == null || p.val != q.val) {
//			return false;
//		} else {
//			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//
//		}
//	}
	
	// improved!!!!
	static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q; // If both are null -> true, otherwise false
		}
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
