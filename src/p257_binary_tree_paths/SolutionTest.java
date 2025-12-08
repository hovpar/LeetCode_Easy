package p257_binary_tree_paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testEmptyTree() {
        TreeNode root = null;

        List<String> result = s.binaryTreePaths(root);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);

        List<String> result = s.binaryTreePaths(root);

        assertEquals(List.of("1"), result);
    }

    @Test
    void testTwoLevelTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        List<String> result = s.binaryTreePaths(root);

        // order may vary
        assertTrue(result.contains("1->2"));
        assertTrue(result.contains("1->3"));
        assertEquals(2, result.size());
    }

    @Test
    void testLeftLeaningTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), null);

        List<String> result = s.binaryTreePaths(root);

        assertEquals(List.of("1->2->5"), result);
    }

    @Test
    void testRightLeaningTree() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));

        List<String> result = s.binaryTreePaths(root);

        assertEquals(List.of("1->2->3"), result);
    }

    @Test
    void testGeneralTree() {
        //      1
        //     / \
        //    2   3
        //     \
        //      5
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));

        List<String> result = s.binaryTreePaths(root);

        assertTrue(result.contains("1->2->5"));
        assertTrue(result.contains("1->3"));
        assertEquals(2, result.size());
    }

    @Test
    void testLargeTree() {
        //      1
        //     / \
        //    2   3
        //   /   / \
        //  4   5   6
        //     /
        //    7
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));

        List<String> result = s.binaryTreePaths(root);

        List<String> expected = List.of("1->2->4", "1->3->5->7", "1->3->6");

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

}
