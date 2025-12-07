package p125_valid_palindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        String s = "A man, a plan, a canal: Panama";

        assertTrue(solution.isPalindrome(s));
    }

    @Test
    void test2() {
        String s = "race a car";

        assertFalse(solution.isPalindrome(s));
    }

    @Test
    void test3() {
        String s = "";

        assertTrue(solution.isPalindrome(s));
    }
}
