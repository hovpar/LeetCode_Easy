package p203_remove_linked_list_elements;

class SolutionVariants {

    interface Solver {
        ListNode removeElements(ListNode head, int val);
    }

    static class CopyAndFilterSolver implements Solver {
        // Creates a new list containing only the desired nodes
        @Override
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0); // dummy node
            ListNode tail = dummy; // points to the end of the new list
            ListNode current = head;

            while (current != null) {
                if (current.val != val) {
                    tail.next = new ListNode(current.val); // append
                    tail = tail.next;
                }
                current = current.next;
            }

            return dummy.next;
        }
    }

    static class InPlaceRemovalSolver implements Solver {
        // Removes nodes by modifying the existing links
        // a bit efficient, without extra space
        @Override
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            var prev = dummy;

            while (prev.next != null) {
                if (prev.next.val == val) {
                    prev.next = prev.next.next; // skip node
                } else {
                    prev = prev.next;
                }
            }

            return dummy.next;

        }
    }
}
