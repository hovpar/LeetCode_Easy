package p206_reverse_linked_list;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    // Helper: create a linked list from an array
    // int... varargs, example: buildList() | buildList(1) | builsList (1,2,3) etc.
    // the compiler creates int [] from int... internally
    private ListNode buildList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int v : values) {
            current.next = new ListNode(v);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: convert list to array for easier comparison
    private int[] toArray(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int[] arr = new int[length];
        temp = head;
        for (int i = 0; i < length; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }

        return arr;
    }

    @Test
    void testMultipleElements() {
        ListNode input = buildList(1, 2, 3, 4, 5);
        ListNode result = solution.reverseList(input);
        assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, toArray(result));
    }

    @Test
    void testSingleElement() {
        ListNode input = buildList(7);
        ListNode result = solution.reverseList(input);
        assertArrayEquals(new int[] { 7 }, toArray(result));
    }

    @Test
    void testEmptyList() {
        ListNode input = null;
        ListNode result = solution.reverseList(input);
        assertNull(result);
    }

    @Test
    void testTwoElements() {
        ListNode input = buildList(10, 20);
        ListNode result = solution.reverseList(input);
        assertArrayEquals(new int[] { 20, 10 }, toArray(result));
    }

}
