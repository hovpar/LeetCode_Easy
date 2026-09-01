package p589_n_ary_tree_preorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SolutionVariants {

    interface Solver {
        List<Integer> preorder(Node root);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            } else {

                return preorderRec(root, result);
            }
        }

        private List<Integer> preorderRec(Node node, List<Integer> result) {
            result.add(node.val);
            for (Node child : node.children) {
                preorderRec(child, result);
            }
            return result;
        }
    }

    static class IterativeSolver implements Solver {
        @Override
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<Integer>();

            if (root == null) {
                return result;
            }
            //Java's Stack is an old class. The modern stack abstraction is Deque.
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                // Pop a Node from the stack and add it to the output list.
                Node node = stack.pop();
                result.add(node.val);
                // Push all of the child nodes of the node into the stack from right to left
                // to get the right preorder traversal.
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    stack.push(child);
                }
            }
            return result;
        }
    }
}
