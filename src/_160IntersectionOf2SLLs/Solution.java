package _160IntersectionOf2SLLs;

class Solution {
//    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lenA = 0, lenB = 0;
//
//        var tempA = headA;
//        while (tempA != null) {
//            lenA++;
//            tempA = tempA.next;
//        }
//
//        var tempB = headB;
//        while (tempB != null) {
//            lenB++;
//            tempB = tempB.next;
//        }
//        tempA = headA;
//        tempB = headB;
//        if (lenA > lenB) {
//            for (int i = 0; i < lenA - lenB; i++) {
//                tempA = tempA.next;
//            }
//        } else if (lenB > lenA) {
//            for (int i = 0; i < lenB - lenA; i++) {
//                tempB = tempB.next;
//            }
//        }
//
//        while (tempA != tempB) {
//            tempA = tempA.next;
//            tempB = tempB.next;
//        }
//
//        return tempA;
//    }
    // two-pointer trick
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            // Move forward, or switch to the other list when reaching the end
//            if (tempA == null) {
//                tempA = headB;
//            } else {
//                tempA = tempA.next;
//            }
//            if (tempB == null) {
//                tempB = headA;
//            } else {
//                tempB = tempB.next;
//            }
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }

        // Either intersection node or null
        return tempA;
    }

}
