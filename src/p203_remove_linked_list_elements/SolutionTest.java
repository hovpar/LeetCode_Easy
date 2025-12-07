package p203_remove_linked_list_elements;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    private boolean equal(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    @Test
    void testDoubleOccurrence() {
        // origin: [1, 2, 6, 3, 4, 5, 6]
        ListNode origin = new ListNode(1,
                new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        // expected: [1, 2, 3, 4, 5]
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = solution.removeElements(origin, 6);

        assertTrue(equal(expected, result));
    }

    @Test
    void testEmptyList() {
        ListNode origin = new ListNode();
        ListNode expected = new ListNode();

        ListNode result = solution.removeElements(origin, 1);
        assertTrue(equal(expected, result));
    }

    @Test
    void testRemoveSameElement() {

        ListNode origin = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));

        ListNode result = solution.removeElements(origin, 7);
        assertTrue(equal(null, result));

    }

    @Test
    void testNullList() {
        ListNode result = solution.removeElements(null, 1);
        assertNull(result);
    }

    @Test
    void testTargetAtHead() {
        // [6,1,2,3] -> [1,2,3]
        ListNode origin = new ListNode(6, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode result = solution.removeElements(origin, 6);
        assertTrue(equal(expected, result));
    }

    @Test
    void testTargetAtTail() {
        // [1,2,3,6] -> [1,2,3]
        ListNode origin = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(6))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode result = solution.removeElements(origin, 6);
        assertTrue(equal(expected, result));
    }

    @Test
    void testNoRemoval() {
        // [1,2,3,4,5], remove 9 -> [1,2,3,4,5]
        ListNode origin = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = solution.removeElements(origin, 9);
        assertTrue(equal(expected, result));
    }

}
