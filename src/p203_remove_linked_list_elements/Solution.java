package p203_remove_linked_list_elements;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
//        ListNode dummy = new ListNode(0); // dummy node
//        ListNode tail = dummy; // points to the end of the new list
//        ListNode current = head;
//
//        while (current != null) {
//            if (current.val != val) {
//                tail.next = new ListNode(current.val); // append
//                tail = tail.next;
//            }
//            current = current.next;
//        }
//
//        return dummy.next;
        // a bit efficient, without extra space
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
