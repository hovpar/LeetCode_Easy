package _206ReverseLinkedList;

class Solution {
//    public ListNode reverseList(ListNode head) {
//        var current = head;
//        ListNode prev = null;
//
//        while (current != null) {
//            var temp = current.next;
//            current.next = prev;
//            prev = current;
//            current = temp;
//
//        }
//        return prev;
//
//    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head; // attach head after the reversed sublist
        head.next = null; // make head the tail
        return newHead;
    }
}
