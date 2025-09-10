package SameTree_100;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SameTreeTest {

	@Test
    void testBasic() {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        
        var p = new TreeNode(1, two, three);
        var q = new TreeNode(1, two, three);
        
        assertTrue(SameTree.isSameTree(p, q));
    }

    @Test
    void testDifferentNodes() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        
        assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    void testDifferentValues() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(4));

        assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    void testOneTreeNull() {
        TreeNode p = new TreeNode(1);
        TreeNode q = null;

        assertFalse(SameTree.isSameTree(p, q));
    }

    @Test
    void testBothTreesNull() {
        TreeNode p = null;
        TreeNode q = null;

        assertTrue(SameTree.isSameTree(p, q));
    }

    @Test
    void testComplexStructure() {
        TreeNode p = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));

        assertTrue(SameTree.isSameTree(p, q));
    }

}
