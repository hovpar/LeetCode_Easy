package _144BinTreePreOrderTraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        var three = new TreeNode(3);
        var two = new TreeNode(2, three, null);
        var root = new TreeNode(1, null, two);

        List<Integer> expected = List.of(1, 2, 3);
        assertEquals(expected, solution.preorderTraversal(root));
    }

    @Test
    void test2() {
        var four = new TreeNode(4);
        var six = new TreeNode(6);
        var seven = new TreeNode(7);
        var nine = new TreeNode(9);
        var five = new TreeNode(5, six, seven);
        var two = new TreeNode(2, four, five);
        var eight = new TreeNode(8, nine, null);
        var three = new TreeNode(3, null, eight);
        var root = new TreeNode(1, two, three);

        List<Integer> expected = List.of(1, 2, 4, 5, 6, 7, 3, 8, 9);
        assertEquals(expected, solution.preorderTraversal(root));
    }

    @Test
    void test3() {
        TreeNode root = null;

        List<Integer> expected = List.of();
        assertEquals(expected, solution.preorderTraversal(root));
    }

    @Test
    void test4() {
        var root = new TreeNode(1);

        List<Integer> expected = List.of(1);
        assertEquals(expected, solution.preorderTraversal(root));
    }

}
