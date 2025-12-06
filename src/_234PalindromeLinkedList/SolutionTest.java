package _234PalindromeLinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution s = new Solution();

    @Test
    void returnsTrueForEvenLengthPalindrome() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        assertTrue(s.isPalindrome(head));
    }

    @Test
    void returnsFalseForNonPalindrome() {
        ListNode head = new ListNode(1, new ListNode(2));
        assertFalse(s.isPalindrome(head));
    }

    @Test
    void returnsFalseForNearPalindrome() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        assertFalse(s.isPalindrome(head));
    }

    @Test
    void returnsTrueForSingleNode() {
        ListNode head = new ListNode(5);
        assertTrue(s.isPalindrome(head));
    }

    @Test
    void returnsTrueForOddLengthPalindrome() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        assertTrue(s.isPalindrome(head));
    }

    @Test
    void returnsTrueForEmptyList() {
        assertTrue(s.isPalindrome(null));
    }

    @Test
    void returnsTrueForLongPalindrome() {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(3, new ListNode(1)))));
        assertTrue(s.isPalindrome(head));
    }

}
