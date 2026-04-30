package p521_longest_uncommon_subsequence_i;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsMinusOne_whenStringsAreEqual() {
        assertEquals(-1, s.findLUSlength("aaa", "aaa"));
        assertEquals(-1, s.findLUSlength("abc", "abc"));
        assertEquals(-1, s.findLUSlength("", ""));
    }

    @Test
    void returnsLength_whenSameLengthButDifferentStrings() {
        assertEquals(3, s.findLUSlength("aba", "cdc"));
        assertEquals(3, s.findLUSlength("aaa", "bbb"));
        assertEquals(1, s.findLUSlength("a", "b"));
    }

    @Test
    void returnsLongerLength_whenFirstStringIsLonger() {
        assertEquals(4, s.findLUSlength("abcd", "abc"));
        assertEquals(5, s.findLUSlength("hello", "hell"));
    }

    @Test
    void returnsLongerLength_whenSecondStringIsLonger() {
        assertEquals(4, s.findLUSlength("abc", "abcd"));
        assertEquals(5, s.findLUSlength("hell", "hello"));
    }

    @Test
    void handlesEmptyStringCases() {
        assertEquals(1, s.findLUSlength("", "a"));
        assertEquals(1, s.findLUSlength("a", ""));
        assertEquals(3, s.findLUSlength("", "abc"));
        assertEquals(3, s.findLUSlength("abc", ""));
    }

    @Test
    void handlesSimilarButNotEqualStrings() {
        assertEquals(3, s.findLUSlength("abc", "abd"));
        assertEquals(4, s.findLUSlength("aaaa", "aaa"));
        assertEquals(4, s.findLUSlength("aaa", "aaaa"));
    }
}
