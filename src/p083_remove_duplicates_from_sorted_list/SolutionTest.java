package p083_remove_duplicates_from_sorted_list;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    // Helper method to compare two linked lists
    private boolean areListsEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    @Test
    void testNull() {
        assertNull(s.deleteDuplicates(null));
    }

    @Test
    void testOneElement() {
        ListNode head = new ListNode(1, null);
        ListNode result = s.deleteDuplicates(head);
        assertTrue(areListsEqual(head, result));
    }

    @Test
    void testConsecutiveDuplicates() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode expected = new ListNode(1, new ListNode(2));
        ListNode result = s.deleteDuplicates(head);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    void testMultipleConsecutiveDuplicates() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = s.deleteDuplicates(head);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    void testAllDuplicates() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode expected = new ListNode(1); // Only one element should remain
        ListNode result = s.deleteDuplicates(head);
        assertTrue(areListsEqual(expected, result));
    }

    @Test
    void testNoDuplicates() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = s.deleteDuplicates(head);
        assertTrue(areListsEqual(expected, result));
    }
}
