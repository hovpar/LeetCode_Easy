package _144BinTreePreOrderTraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> preorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;

    }

    private void preorderTraversal(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        } else {
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);

        }

    }

}
