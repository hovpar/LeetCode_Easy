package ConvertSortArrToBTree_108;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

class SolutionTest {
	
	private final Solution solution = new Solution();

    @Test
    public void testExample1() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertTrue(isBalanced(root));
        assertTrue(isBST(root));
    }

    @Test
    public void testExample2() {
        int[] nums = {1, 3};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertTrue(isBalanced(root));
        assertTrue(isBST(root));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertNull(root);
    }

    @Test
    public void testSingleElement() {
        int[] nums = {7};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertNotNull(root);
        assertEquals(7, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    // Helper method to verify BST property
    private boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isBSTHelper(node.left, min, node.val) && isBSTHelper(node.right, node.val, max);
    }

    // Helper method to verify height-balance
    private boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        int right = checkHeight(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
