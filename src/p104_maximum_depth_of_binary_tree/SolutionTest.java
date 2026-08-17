package p104_maximum_depth_of_binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testEmpty() {

        assertEquals(0, solution.maxDepth(null));
    }

    @Test
    void testSingleDepth() {
        var tree = new TreeNode(1);

        assertEquals(1, solution.maxDepth(tree));
    }

    @Test
    void testTwoDepth() {
        var tree = new TreeNode(1, null, new TreeNode(2));

        assertEquals(2, solution.maxDepth(tree));
    }

    @Test
    void testSeveralDepth() {
        var tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertEquals(3, solution.maxDepth(tree));
    }

    @Test
    void testLeftSkewedTree() {
        var tree = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);

        assertEquals(4, solution.maxDepth(tree));
    }

    @Test
    void testRightSkewedTree() {
        var tree = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        assertEquals(4, solution.maxDepth(tree));
    }

    @Test
    void testBalancedTree() {
        var tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        assertEquals(3, solution.maxDepth(tree));
    }

    @Test
    void testUnbalancedTree() {
        var tree = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(5));

        assertEquals(4, solution.maxDepth(tree));
    }

}
