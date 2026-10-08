package p671_second_minimum_node_in_a_bin_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnSecondMinimum() {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));

        assertEquals(5, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldReturnMinusOneWhenAllValuesAreEqual() {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(2));

        assertEquals(-1, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldReturnRightChildWhenItIsSecondMinimum() {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(3));

        assertEquals(3, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldReturnLeftChildWhenItIsSecondMinimum() {
        TreeNode root = new TreeNode(2, new TreeNode(3), new TreeNode(2));

        assertEquals(3, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldFindSecondMinimumInLeftSubtree() {
        TreeNode root = new TreeNode(2, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2));

        assertEquals(3, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldFindSecondMinimumInRightSubtree() {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(2, new TreeNode(4), new TreeNode(5)));

        assertEquals(4, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldFindSmallestValueAmongMultipleCandidates() {
        TreeNode root = new TreeNode(2, new TreeNode(2, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, new TreeNode(4), new TreeNode(6)));

        assertEquals(3, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldHandleSingleNode() {
        TreeNode root = new TreeNode(2);

        assertEquals(-1, s.findSecondMinimumValue(root));
    }

    @Test
    void shouldHandleSecondMinimumAtDeepestLevel() {
        TreeNode root = new TreeNode(2, new TreeNode(2, new TreeNode(2), new TreeNode(2)),
                new TreeNode(2, new TreeNode(2), new TreeNode(5)));

        assertEquals(5, s.findSecondMinimumValue(root));
    }

}
