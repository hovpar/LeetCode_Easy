package p409_longest_palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testUsesSingleOddCharacterAsCenter() {
        assertEquals(7, s.longestPalindrome("abccccdd"));
    }

    @Test
    void testSingleLetter() {
        assertEquals(1, s.longestPalindrome("a"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, s.longestPalindrome(""));
    }

    @Test
    void testAllEvenCounts() {
        // All characters can be fully used
        assertEquals(6, s.longestPalindrome("aabbcc"));
    }

    @Test
    void testMultipleOddCounts() {
        // Only one odd-count character can contribute +1 center
        assertEquals(7, s.longestPalindrome("aaabbbb"));
    }

    @Test
    void testAllOddSingleOccurrences() {
        // Only one character can be used
        assertEquals(1, s.longestPalindrome("abc"));
    }

    @Test
    void testCaseSensitivity() {
        // 'A' and 'a' are different characters
        assertEquals(1, s.longestPalindrome("Aa"));
    }

    @Test
    void testLargeRepeatedCharacters() {
        assertEquals(1000, s.longestPalindrome("a".repeat(1000)));
    }

    @Test
    void testPalindromeAlready() {
        assertEquals(7, s.longestPalindrome("racecar"));
    }

}
