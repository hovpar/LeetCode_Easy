package _226InvertBinTree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void testNullTree() {
        Solution s = new Solution();
        assertNull(s.invertTree(null));
    }

    @Test
    void testSingleNode() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);

        TreeNode result = s.invertTree(root);

        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void testTwoNodesLeft() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        TreeNode result = s.invertTree(root);

        assertNull(result.left);
        assertNotNull(result.right);
        assertEquals(2, result.right.val);
    }

    @Test
    void testTwoNodesRight() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(3));

        TreeNode result = s.invertTree(root);

        assertNull(result.right);
        assertNotNull(result.left);
        assertEquals(3, result.left.val);
    }

    @Test
    void testFullTree() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        TreeNode result = s.invertTree(root);

        // After invert:
        // 4
        // 7 2
        // 9 6 3 1

        assertEquals(7, result.left.val);
        assertEquals(9, result.left.left.val);
        assertEquals(6, result.left.right.val);

        assertEquals(2, result.right.val);
        assertEquals(3, result.right.left.val);
        assertEquals(1, result.right.right.val);
    }

}
