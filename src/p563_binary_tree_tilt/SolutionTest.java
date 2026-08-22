package p563_binary_tree_tilt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void basicTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        assertEquals(1, s.findTilt(root));
    }

    @Test
    void largerTree() {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(3)),
                new TreeNode(9, null, new TreeNode(7)));

        assertEquals(15, s.findTilt(root));
    }

    @Test
    void deeperTree() {
        TreeNode root = new TreeNode(21,
                new TreeNode(7, new TreeNode(1, new TreeNode(3), new TreeNode(3)), new TreeNode(1)),
                new TreeNode(14, new TreeNode(2), new TreeNode(2)));

        assertEquals(9, s.findTilt(root));
    }

    @Test
    void emptyTree() {
        assertEquals(0, s.findTilt(null));
    }

    @Test
    void singleNode() {
        TreeNode root = new TreeNode(10);

        assertEquals(0, s.findTilt(root));
    }

    @Test
    void allNegativeValues() {
        /*
                 -1
                /  \
              -2   -3
        
           root tilt = |-2 - (-3)| = 1
        */

        TreeNode root = new TreeNode(-1, new TreeNode(-2), new TreeNode(-3));

        assertEquals(1, s.findTilt(root));
    }

    @Test
    void positiveAndNegativeValues() {
        /*
                  5
                 / \
               -3   2
               / \
             -4   1
        
           node -3:
             |-4 - 1| = 5
        
           left subtree sum:
             -3 + -4 + 1 = -6
        
           root:
             |-6 - 2| = 8
        
           total = 5 + 8 = 13
        */

        TreeNode root = new TreeNode(5, new TreeNode(-3, new TreeNode(-4), new TreeNode(1)), new TreeNode(2));

        assertEquals(13, s.findTilt(root));
    }

    @Test
    void subtreeSumsCancelOut() {
        /*
                   10
                  /  \
                 5    0
                / \
              -5   0
        
           node 5:
             |-5 - 0| = 5
        
           left subtree sum:
             5 + (-5) = 0
        
           root:
             |0 - 0| = 0
        
           total = 5
        */

        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(-5), new TreeNode(0)), new TreeNode(0));

        assertEquals(5, s.findTilt(root));
    }

    @Test
    void leftSkewedTree() {
        /*
                1
               /
              2
             /
            3
           /
          4
        
          node 3: |4 - 0| = 4
          node 2: |7 - 0| = 7
          node 1: |9 - 0| = 9
        
          total = 20
        */

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);

        assertEquals(20, s.findTilt(root));
    }

    @Test
    void rightSkewedTree() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        assertEquals(20, s.findTilt(root));
    }

    @Test
    void symmetricTreeWithZeroTilt() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(3)),
                new TreeNode(2, new TreeNode(3), new TreeNode(3)));

        assertEquals(0, s.findTilt(root));
    }

    @Test
    void equalSubtreeSumsWithDifferentValues() {
        /*
                   0
                  / \
                 5   3
                /   / \
              -2   1   1
        
           left sum  = 5 + (-2) = 3
           right sum = 3 + 1 + 1 = 5
        
           node 5 tilt = 2
           node 3 tilt = 0
           root tilt   = 2
        
           total = 4
        */

        TreeNode root = new TreeNode(0, new TreeNode(5, new TreeNode(-2), null),
                new TreeNode(3, new TreeNode(1), new TreeNode(1)));

        assertEquals(4, s.findTilt(root));
    }
}
