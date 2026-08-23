package p141_linked_list_cycle;

import java.util.HashSet;

class SolutionVariants {

    interface Solver {
        boolean hasCycle(ListNode head);
    }

    static class TwoPointerSolver implements Solver {
        @Override
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }

            }
            return false;
        }
    }

    // Store visited nodes in a Set. If you ever see a node twice, there’s a cycle.
    // Uses O(n) extra space
    static class HashSetSolver implements Solver {
        @Override
        public boolean hasCycle(ListNode head) {
            var current = head;
            var visited = new HashSet<ListNode>(); // Set<ListNode> visited = new HashSet<>();
            while (current != null) {
                if (visited.contains(current)) {
                    return true;
                }
                visited.add(current);
                current = current.next;
            }
            return false;
        }
    }
}
