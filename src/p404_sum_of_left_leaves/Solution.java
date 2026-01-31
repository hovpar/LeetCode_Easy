package p404_sum_of_left_leaves;

class Solution {
//    int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            var sum = 0;
//            if (root.left != null && root.left.left == null && root.left.right == null) {
//                sum += root.left.val;
//            }
//            sum += sumOfLeftLeaves(root.left);
//            sum += sumOfLeftLeaves(root.right);
//            return sum;
//        }
//    }
    // avoid redundant traversal into a left leaf
    int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null) {
            boolean isLeaf = (root.left.left == null && root.left.right == null);
            if (isLeaf) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

}
