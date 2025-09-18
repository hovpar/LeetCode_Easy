package _83RemoveDuplicatesFromSortedList;


class RemoveDuplicates {

	ListNode deleteDuplicates(ListNode head) {

	    if (head == null) {
	        return null;
	    }

	    var current = head;

	    while (current.next != null) {
	        if (current.val == current.next.val) {
	            current.next = current.next.next; // Skip duplicate node
	        } else {
	            current = current.next; // Only move forward if no duplicate
	        }
	    }

	    return head;
	}

}
