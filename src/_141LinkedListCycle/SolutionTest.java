package _141LinkedListCycle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void singleNode_noCycle() {
        ListNode head = new ListNode(1);
        assertFalse(solution.hasCycle(head));
    }

    @Test
    void singleNode_withCycle() {
        ListNode head = new ListNode(1);
        head.next = head; // cycle to itself
        assertTrue(solution.hasCycle(head));
    }

    @Test
    void multipleNodes_noCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        assertFalse(solution.hasCycle(head));
    }

    @Test
    void multipleNodes_withCycleAtEnd() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node2; // cycle back to node2
        assertTrue(solution.hasCycle(head));
    }

    @Test
    void multipleNodes_cycleToHead() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = head; // cycle back to head
        assertTrue(solution.hasCycle(head));
    }

    @Test
    void multipleNodes_withCycle() {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node3;
        node3.next = node2;
        node4.next = node2; // cycle back to node2
        assertTrue(solution.hasCycle(head));
    }

    @Test
    void emptyList() {
        assertFalse(solution.hasCycle(null));
    }

}
