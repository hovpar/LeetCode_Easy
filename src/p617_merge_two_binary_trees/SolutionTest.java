package p617_merge_two_binary_trees;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldMergeTrees() {

        TreeNode root1 = arrayToBinTree(new Integer[] { 1, 3, 2, 5 });
        TreeNode root2 = arrayToBinTree(new Integer[] { 2, 1, 3, null, 4, null, 7 });

        TreeNode actual = s.mergeTrees(root1, root2);
        TreeNode expected = arrayToBinTree(new Integer[] { 3, 4, 5, 5, 4, null, 7 });

        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldReturnSecondTreeWhenFirstTreeIsNull() {
        TreeNode root1 = null;
        TreeNode root2 = arrayToBinTree(new Integer[] { 1, 2, 3 });
        TreeNode expected = arrayToBinTree(new Integer[] { 1, 2, 3 });
        TreeNode actual = s.mergeTrees(root1, root2);
        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldReturnFirstTreeWhenSecondTreeIsNull() {
        TreeNode root1 = arrayToBinTree(new Integer[] { 1, 2, 3 });
        TreeNode root2 = null;
        TreeNode expected = arrayToBinTree(new Integer[] { 1, 2, 3 });
        TreeNode actual = s.mergeTrees(root1, root2);
        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldReturnNullWhenBothTreesAreNull() {
        TreeNode root1 = null;
        TreeNode root2 = null;
        TreeNode actual = s.mergeTrees(root1, root2);
        assertNull(actual);
    }

    @Test
    void shouldMergeTreesWithOnlyRootNodes() {
        TreeNode root1 = arrayToBinTree(new Integer[] { 1 });
        TreeNode root2 = arrayToBinTree(new Integer[] { 2 });
        TreeNode expected = arrayToBinTree(new Integer[] { 3 });
        TreeNode actual = s.mergeTrees(root1, root2);
        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldAddValuesOfMatchingNodes() {
        TreeNode root1 = arrayToBinTree(new Integer[] { 5, 3, 7 });
        TreeNode root2 = arrayToBinTree(new Integer[] { 2, 4, 1 });
        TreeNode expected = arrayToBinTree(new Integer[] { 7, 7, 8 });
        TreeNode actual = s.mergeTrees(root1, root2);
        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldPreserveSubtreeWhenOnlyFirstTreeHasIt() {
        TreeNode root1 = arrayToBinTree(new Integer[] { 1, 2, 3, 4 });
        TreeNode root2 = arrayToBinTree(new Integer[] { 1 });
        TreeNode expected = arrayToBinTree(new Integer[] { 2, 2, 3, 4 });
        TreeNode actual = s.mergeTrees(root1, root2);
        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldPreserveSubtreeWhenOnlySecondTreeHasIt() {
        TreeNode root1 = arrayToBinTree(new Integer[] { 1 });
        TreeNode root2 = arrayToBinTree(new Integer[] { 1, 2, 3, 4 });
        TreeNode expected = arrayToBinTree(new Integer[] { 2, 2, 3, 4 });
        TreeNode actual = s.mergeTrees(root1, root2);
        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldMergeTreesWithMissingChildrenAtDifferentPositions() {

        TreeNode root1 = arrayToBinTree(new Integer[] { 1, 2, null, 4 });

        TreeNode root2 = arrayToBinTree(new Integer[] { 1, null, 3, 5, null });

        TreeNode expected = arrayToBinTree(new Integer[] { 2, 2, 3, 4, null, 5 });

        TreeNode actual = s.mergeTrees(root1, root2);

        assertTreeEquals(expected, actual);
    }

    @Test
    void shouldMergeIdenticalTrees() {
        TreeNode root1 = arrayToBinTree(new Integer[] { 1, 2, 3, 4, 5 });
        TreeNode root2 = arrayToBinTree(new Integer[] { 1, 2, 3, 4, 5 });
        TreeNode expected = arrayToBinTree(new Integer[] { 2, 4, 6, 8, 10 });
        TreeNode actual = s.mergeTrees(root1, root2);
        assertTreeEquals(expected, actual);
    }

    private void assertTreeEquals(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) {
            return;
        }

        assertNotNull(expected);
        assertNotNull(actual);

        assertEquals(expected.val, actual.val);

        assertTreeEquals(expected.left, actual.left);
        assertTreeEquals(expected.right, actual.right);
    }

    private TreeNode arrayToBinTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < array.length && array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
