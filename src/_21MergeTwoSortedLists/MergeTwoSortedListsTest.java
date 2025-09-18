package _21MergeTwoSortedLists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeTwoSortedListsTest {
    
    @Test
    void testMergeTwoLists() {

        
        // Test case where both lists are null
        assertNull(MergeTwoSortedLists.mergeTwoLists(null, null));

        // Test case where one list is null
        ListNode list1 = new ListNode(1);
        ListNode merged1 = MergeTwoSortedLists.mergeTwoLists(list1, null);
        assertEquals(1, merged1.val);
        assertNull(merged1.next);

        // Test case where both lists are non-empty
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list4.next = list5;

        ListNode merged2 = MergeTwoSortedLists.mergeTwoLists(list1, list4);
        assertEquals(1, merged2.val);
        assertEquals(2, merged2.next.val);
        assertEquals(3, merged2.next.next.val);
        assertEquals(4, merged2.next.next.next.val);
        assertEquals(5, merged2.next.next.next.next.val);
        assertNull(merged2.next.next.next.next.next);
    }
    
    @Test
    public void testMergeTwoLists1() {
        // Test case where both lists are non-empty with elements in sorted order
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode merged = MergeTwoSortedLists.mergeTwoLists(list1, list2);

        // Expected merged list: [1, 1, 2, 3, 4, 4]
        assertEquals(1, merged.val);
        assertEquals(1, merged.next.val);
        assertEquals(2, merged.next.next.val);
        assertEquals(3, merged.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.next.val);
        assertNull(merged.next.next.next.next.next.next);
    }
}
