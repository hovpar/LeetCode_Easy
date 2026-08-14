package p559_maximum_depth_of_n_ary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void exampleOne() {
        Node root = deserialize(1, null, 3, 2, 4, null, 5, 6);

        assertEquals(3, new Solution().maxDepth(root));
    }

    @Test
    void consecutiveNulls() {
        /*
         *         1
         *       / | \
         *      2  3  4
         *         |
         *         5
         *
         * The consecutive null means node 2 has no children.
         */
        Node root = deserialize(1, null, 2, 3, 4, null, null, 5);

        assertEquals(3, new Solution().maxDepth(root));
    }

    @Test
    void singleNode() {
        Node root = deserialize(1);

        assertEquals(1, new Solution().maxDepth(root));
    }

    @Test
    void emptyTree() {
        Node root = deserialize();

        assertEquals(0, new Solution().maxDepth(root));
    }

    private Node deserialize(Integer... values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }

        Node root = new Node(values[0], new ArrayList<>());
        Queue<Node> parents = new ArrayDeque<>();
        parents.offer(root);

        // values[1] is the separator after the root.
        int index = 2;

        while (!parents.isEmpty() && index < values.length) {
            Node parent = parents.poll();

            // Read all children belonging to the current parent.
            while (index < values.length && values[index] != null) {
                Node child = new Node(values[index], new ArrayList<>());

                parent.children.add(child);
                parents.offer(child);
                index++;
            }

            // Skip the null ending this parent's child list.
            if (index < values.length) {
                index++;
            }
        }

        return root;
    }

}
