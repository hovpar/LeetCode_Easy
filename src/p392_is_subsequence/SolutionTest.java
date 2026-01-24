package p392_is_subsequence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution s = new Solution();

    @Test
    void testGivenExampleTrue() {
        assertTrue(s.isSubsequence("abc", "ahbgdc"));
    }

    @Test
    void testGivenExampleFalse() {
        assertFalse(s.isSubsequence("axc", "ahbgdc"));
    }

    @Test
    void testEmptySAlwaysTrue() {
        assertTrue(s.isSubsequence("", "ahbgdc"));
        assertTrue(s.isSubsequence("", ""));
    }

    @Test
    void testNonEmptySWithEmptyTFalse() {
        assertFalse(s.isSubsequence("a", ""));
    }

    @Test
    void testExactMatchTrue() {
        assertTrue(s.isSubsequence("abc", "abc"));
    }

    @Test
    void testSLongerThanTFalse() {
        assertFalse(s.isSubsequence("abcd", "abc"));
    }

    @Test
    void testSingleCharacter() {
        assertTrue(s.isSubsequence("a", "a"));
        assertTrue(s.isSubsequence("a", "ba"));
        assertFalse(s.isSubsequence("a", "bbb"));
    }

    @Test
    void testOrderMatters() {
        assertTrue(s.isSubsequence("ace", "abcde"));
        assertFalse(s.isSubsequence("aec", "abcde"));
    }

    @Test
    void testRepeatedCharactersEnoughCounts() {
        assertTrue(s.isSubsequence("aa", "aaaa"));
        assertFalse(s.isSubsequence("aaaaa", "aaaa"));
    }

    @Test
    void testRepeatedCharactersOrdering() {
        assertFalse(s.isSubsequence("abba", "ab")); // too short
        assertTrue(s.isSubsequence("abba", "a_b_b_a".replace("_", ""))); // "abba"
        assertFalse(s.isSubsequence("abba", "abab")); // can't match last 'a' after final 'b'
    }

    @Test
    void testCaseSensitivity() {
        assertTrue(s.isSubsequence("Ab", "Axxb"));
        assertFalse(s.isSubsequence("ab", "Axxb")); // 'a' != 'A'
    }

    @Test
    void testWithSymbolsAndSpaces() {
        assertTrue(s.isSubsequence("a-c", "a--b--c"));
        assertTrue(s.isSubsequence("a c", "a  b  c"));
        assertFalse(s.isSubsequence("a-c", "abc"));
    }
}
