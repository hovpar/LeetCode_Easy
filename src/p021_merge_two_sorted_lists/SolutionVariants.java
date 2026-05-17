package p021_merge_two_sorted_lists;

class SolutionVariants {

    interface Solver {
        ListNode mergeTwoLists(ListNode list1, ListNode list2);
    }

    static class IterativeMergeSolver implements Solver {
        @Override
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            //Create a dummy node to simplify merging
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            // Traverse both lists simultaneously
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
                current = current.next;
            }

            // Attach remaining nodes from either list
            if (list1 != null) {
                current.next = list1;
            } else {
                current.next = list2;
            }

            return dummy.next;

        }
    }

    static class RecursiveMergeSolver implements Solver {
        @Override
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }

            if (list2 == null) {
                return list1;
            }

            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }
}
