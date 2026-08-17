package p100_same_tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testBasic() {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        var p = new TreeNode(1, two, three);
        var q = new TreeNode(1, two, three);

        assertTrue(s.isSameTree(p, q));
    }

    @Test
    void testDifferentNodes() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));

        assertFalse(s.isSameTree(p, q));
    }

    @Test
    void testDifferentValues() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(4));

        assertFalse(s.isSameTree(p, q));
    }

    @Test
    void testOneTreeNull() {
        TreeNode p = new TreeNode(1);
        TreeNode q = null;

        assertFalse(s.isSameTree(p, q));
    }

    @Test
    void testBothTreesNull() {
        TreeNode p = null;
        TreeNode q = null;

        assertTrue(s.isSameTree(p, q));
    }

    @Test
    void testComplexStructure() {
        TreeNode p = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));

        assertTrue(s.isSameTree(p, q));
    }

}
