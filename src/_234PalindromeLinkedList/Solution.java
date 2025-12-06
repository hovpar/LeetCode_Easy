package _234PalindromeLinkedList;

class Solution {
    // Stack approach O(n/2) space
//    public boolean isPalindrome(ListNode head) {
//        if (head == null) {
//            return true;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        ListNode slow = head;
//        ListNode fast = head;
//
//        // Push first half values
//        while (fast != null && fast.next != null) {
//            stack.push(slow.val);
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        // If odd length, skip the middle node
//        if (fast != null) {
//            slow = slow.next;
//        }
//
//        // Now compare stack with second half
//        while (slow != null) {
//            if (stack.pop() != slow.val) {
//                return false;
//            }
//            slow = slow.next;
//        }
//
//        return true;
//    }

    // Two pointer approach O(1) space
    public boolean isPalindrome(ListNode head) {
        var isPalindrome = true;
        if (head == null || head.next == null) {
            return isPalindrome;
        }

        // 1. Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // You can but don't need to skip the middle node if the length is odd.
        // It compares only one extra node in that case, for example 1->2->3->2->1
        // compares 1->2->3 vs 1->2->3

        // 2. Reverse second half
        slow = reverse(slow);

        // 3. Compare halves
        fast = head;
        while (slow != null && isPalindrome) { // only check second half
            if (fast.val != slow.val) {
                isPalindrome = false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return isPalindrome;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        var current = head;

        while (current != null) {
            var temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

}
