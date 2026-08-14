package p559_maximum_depth_of_n_ary_tree;

class Solution {
    //recursive solution
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        var max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return 1 + max;

    }
}
