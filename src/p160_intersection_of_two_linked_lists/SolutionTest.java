package p160_intersection_of_two_linked_lists;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void intersectionWhenBLongerThanA() {

        ListNode commonList = new ListNode(8, (new ListNode(4, (new ListNode(5)))));

        ListNode listA = new ListNode(1, new ListNode(1, commonList));
        ListNode listB = new ListNode(5, new ListNode(6, new ListNode(1, commonList)));
        assertSame(commonList, solution.getIntersectionNode(listA, listB));

    }

    @Test
    void intersectionWhenALongerThanB() {

        ListNode commonList = new ListNode(2, (new ListNode(4)));

        ListNode listA = new ListNode(1, new ListNode(1, new ListNode(1, commonList)));
        ListNode listB = new ListNode(3, commonList);
        assertSame(commonList, solution.getIntersectionNode(listA, listB));

    }

    @Test
    void testNoIntersection() {
        ListNode listA = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listB = new ListNode(4, new ListNode(5));
        assertNull(solution.getIntersectionNode(listA, listB));
    }

    @Test
    void testIntersectionAtHead() {
        ListNode commonList = new ListNode(7, new ListNode(8, new ListNode(9)));
        // Both lists start at the same node
        ListNode listA = commonList;
        ListNode listB = commonList;
        assertSame(commonList, solution.getIntersectionNode(listA, listB));
    }

    @Test
    void testOneListEmpty() {
        ListNode listA = null;
        ListNode listB = new ListNode(1, new ListNode(2));
        assertNull(solution.getIntersectionNode(listA, listB));
    }

    @Test
    void testBothEmpty() {
        ListNode listA = null;
        ListNode listB = null;
        assertNull(solution.getIntersectionNode(listA, listB));
    }

    @Test
    void testIntersectionSingleNode() {
        ListNode commonList = new ListNode(10);
        ListNode listA = new ListNode(1, commonList);
        ListNode listB = new ListNode(2, commonList);
        assertSame(commonList, solution.getIntersectionNode(listA, listB));
    }

}
