package p021_merge_two_sorted_lists;

class MergeTwoSortedLists {
	static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//        if (list1 == null && list2 == null) {
//            return null;
//        } else if (list1 != null && list2 == null) {
//            return list1;
//        } else if (list1 == null && list2 != null) {
//            return list2;
//        } else {
//            var current1 = list1;
//            var current2 = list2;
//
//            while (current1 != null) {
//                var newNode = new ListNode(current1.val, null);
//
//                if (current1.val <= current2.val) {
//                    newNode.next = current2;
//                    current2 = newNode.next;
//                } else {
//                    newNode.next = current2.next;
//                    current2.next = newNode;
//                    current2 = newNode.next;
//                }
//                current1 = current1.next;
//            }
//
//            return list2;
		// Create a dummy node to simplify merging
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;

		// Traverse both lists simultaneously
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				current.next = list1;
				list1 = list1.next;
			} else {
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;
		}

		// Attach remaining nodes from either list
		if (list1 != null) {
			current.next = list1;
		} else {
			current.next = list2;
		}

		return dummy.next;

	}
}
