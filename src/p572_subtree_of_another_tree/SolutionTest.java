package p572_subtree_of_another_tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnTrueWhenSubtreeIsDirectChild() {
        Integer[] root = { 3, 4, 5, 1, 2 };
        Integer[] subRoot = { 4, 1, 2 };

        assertTrue(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnFalseWhenTreeLooksSimilarButIsNotIdentical() {
        Integer[] root = { 3, 4, 5, 1, 2, null, null, null, null, 0 };
        Integer[] subRoot = { 4, 1, 2 };

        assertFalse(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldFindSubtreeDeepInsideTree() {
        Integer[] root = { 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                2 };

        Integer[] subRoot = { 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2 };

        assertTrue(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnTrueWhenSubtreeIsTheRoot() {
        Integer[] root = { 1, 2, 3 };
        Integer[] subRoot = { 1, 2, 3 };

        assertTrue(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnTrueWhenSubtreeIsLeaf() {
        Integer[] root = { 3, 4, 5, 1, 2 };
        Integer[] subRoot = { 2 };

        assertTrue(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnFalseWhenSubtreeDoesNotExist() {
        Integer[] root = { 3, 4, 5, 1, 2 };
        Integer[] subRoot = { 6 };

        assertFalse(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnFalseWhenValuesMatchButStructureDoesNot() {
        Integer[] root = { 1, 2, 3 };
        Integer[] subRoot = { 1, 2 };

        assertFalse(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnTrueForSingleNodeTree() {
        Integer[] root = { 1 };
        Integer[] subRoot = { 1 };

        assertTrue(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnFalseForDifferentSingleNode() {
        Integer[] root = { 1 };
        Integer[] subRoot = { 2 };

        assertFalse(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnFalseWhenRootIsNull() {
        Integer[] root = {};
        Integer[] subRoot = { 1 };

        assertFalse(s.isSubtree(arrayToBinTree(root), arrayToBinTree(subRoot)));
    }

    @Test
    void shouldReturnTrueWhenSubRootIsNull() {
        Integer[] root = { 1, 2, 3 };

        assertTrue(s.isSubtree(arrayToBinTree(root), null));
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
