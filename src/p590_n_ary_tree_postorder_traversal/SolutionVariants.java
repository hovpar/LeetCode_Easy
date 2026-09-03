package p590_n_ary_tree_postorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class SolutionVariants {
    interface Solver {
        List<Integer> postorder(Node root);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public List<Integer> postorder(Node root) {

            List<Integer> result = new ArrayList<>();

            if (root == null) {
                return result;
            }
            return postorderRec(root, result);

        }

        private List<Integer> postorderRec(Node root, List<Integer> result) {

            for (Node node : root.children) {
                postorderRec(node, result);

            }
            result.add(root.val);
            return result;

        }
    }

    static class IterativeSolver implements Solver {
        @Override
        public List<Integer> postorder(Node root) {
            List<Integer> result = new LinkedList<Integer>();

            if (root == null) {
                return result;
            }
            //Java's Stack is an old class. The modern stack abstraction is Deque.
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                // Pop a Node from the stack and add it to the output list.
                Node node = stack.pop();
                result.addFirst(node.val);
                // Push all the children of the current node to the stack
                if (node.children != null) {
                    for (Node child : node.children) {
                        stack.push(child);

                    }
                }

            }
            return result;
        }
    }
}
