package p530_minimum_absolute_difference_in_bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void leetcodeExample1() {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));

        assertEquals(1, s.getMinimumDifference(root));
    }

    @Test
    void leetcodeExample2() {
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));

        assertEquals(1, s.getMinimumDifference(root));
    }

    @Test
    void twoNodes() {
        TreeNode root = new TreeNode(1, null, new TreeNode(5));

        assertEquals(4, s.getMinimumDifference(root));
    }

    @Test
    void minimumDifferenceNotNearRoot() {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(7)),
                new TreeNode(20, new TreeNode(15), new TreeNode(21)));

        assertEquals(1, s.getMinimumDifference(root));
    }

    @Test
    void skewedRightTree() {
        TreeNode root = new TreeNode(1, null, new TreeNode(3, null, new TreeNode(6, null, new TreeNode(10))));

        assertEquals(2, s.getMinimumDifference(root));
    }

    @Test
    void skewedLeftTree() {
        TreeNode root = new TreeNode(10, new TreeNode(6, new TreeNode(3, new TreeNode(1), null), null), null);

        assertEquals(2, s.getMinimumDifference(root));
    }

    @Test
    void largerValues() {
        TreeNode root = new TreeNode(100000, new TreeNode(50000), new TreeNode(150000));

        assertEquals(50000, s.getMinimumDifference(root));
    }
}
