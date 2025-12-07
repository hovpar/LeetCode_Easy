package p101_symmetric_tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SymmetricTreeTest {

	@Test
    void testSymmetricTree() {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);

        assertTrue(new SymmetricTree().isSymmetric(root));
    }

    @Test
    void testAsymmetricTree() {
        TreeNode left = new TreeNode(2, new TreeNode(3), null);
        TreeNode right = new TreeNode(2, null, new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);

        assertTrue(new SymmetricTree().isSymmetric(root));
    }

    @Test
    void testSingleRootNode() {
        TreeNode root = new TreeNode(1);
        assertTrue(new SymmetricTree().isSymmetric(root));
    }

    @Test
    void testNullTree() {
        assertTrue(new SymmetricTree().isSymmetric(null));
    }

    @Test
    void testOnlyLeftSubtree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(new SymmetricTree().isSymmetric(root));
    }

    @Test
    void testOnlyRightSubtree() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        assertFalse(new SymmetricTree().isSymmetric(root));
    }

    @Test
    void testMirrorWithNullNodes() {
        TreeNode left = new TreeNode(2, null, new TreeNode(3));
        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, left, right);

        assertTrue(new SymmetricTree().isSymmetric(root));
    }

}
