package RemoveDuplicatesFromSortedList_83;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {

	RemoveDuplicates removeDuplicates = new RemoveDuplicates();

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
			assertNull(removeDuplicates.deleteDuplicates(null));
		}

		@Test
		void testOneElement() {
			ListNode head = new ListNode(1, null);
			ListNode result = removeDuplicates.deleteDuplicates(head);
			assertTrue(areListsEqual(head, result));
		}

		@Test
		void testConsecutiveDuplicates() {
			ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
			ListNode expected = new ListNode(1, new ListNode(2));
			ListNode result = removeDuplicates.deleteDuplicates(head);
			assertTrue(areListsEqual(expected, result));
		}

		@Test
		void testMultipleConsecutiveDuplicates() {
			ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
			ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));
			ListNode result = removeDuplicates.deleteDuplicates(head);
			assertTrue(areListsEqual(expected, result));
		}

		@Test
		void testAllDuplicates() {
			ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
			ListNode expected = new ListNode(1); // Only one element should remain
			ListNode result = removeDuplicates.deleteDuplicates(head);
			assertTrue(areListsEqual(expected, result));
		}

		@Test
		void testNoDuplicates() {
			ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
			ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));
			ListNode result = removeDuplicates.deleteDuplicates(head);
			assertTrue(areListsEqual(expected, result));
		}
}
