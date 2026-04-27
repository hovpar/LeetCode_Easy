package p520_detect_capital;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsTrue_whenAllLettersAreUppercase() {
        assertTrue(s.detectCapitalUse("USA"));
        assertTrue(s.detectCapitalUse("A"));
        assertTrue(s.detectCapitalUse("LEETCODE"));
    }

    @Test
    void returnsTrue_whenAllLettersAreLowercase() {
        assertTrue(s.detectCapitalUse("leetcode"));
        assertTrue(s.detectCapitalUse("a"));
        assertTrue(s.detectCapitalUse("google"));
    }

    @Test
    void returnsTrue_whenOnlyFirstLetterIsUppercase() {
        assertTrue(s.detectCapitalUse("Google"));
        assertTrue(s.detectCapitalUse("Leetcode"));
        assertTrue(s.detectCapitalUse("F"));
    }

    @Test
    void returnsFalse_whenMultipleUppercaseButNotAll() {
        assertFalse(s.detectCapitalUse("FlaG"));
        assertFalse(s.detectCapitalUse("LeetCode"));
        assertFalse(s.detectCapitalUse("JavaScript"));
    }

    @Test
    void returnsFalse_whenFirstLetterLowercaseButLaterUppercase() {
        assertFalse(s.detectCapitalUse("uSA"));
        assertFalse(s.detectCapitalUse("leetcodeA"));
        assertFalse(s.detectCapitalUse("gOogle"));
    }

    @Test
    void returnsFalse_whenOnlyLastLetterIsUppercase() {
        assertFalse(s.detectCapitalUse("hellO"));
        assertFalse(s.detectCapitalUse("worD"));
    }

    @Test
    void handlesTwoCharacterWords() {
        assertTrue(s.detectCapitalUse("US"));
        assertTrue(s.detectCapitalUse("Us"));
        assertTrue(s.detectCapitalUse("us"));

        assertFalse(s.detectCapitalUse("uS"));
    }
}