package p383_ransome_note;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testCannotConstruct_basicMismatch() {
        assertFalse(s.canConstruct("a", "b"));
        assertFalse(s.canConstruct("aa", "ab"));   // needs two 'a', only one available
    }

    @Test
    void testCannotConstruct_lengthGuard() {
        assertFalse(s.canConstruct("abc", "ab"));  // ransom longer than magazine
    }

    @Test
    void testCannotConstruct_insufficientCounts() {
        assertFalse(s.canConstruct("aab", "abb")); // only one 'a'
        assertFalse(s.canConstruct("zzz", "zz"));  // missing one 'z'
    }

    @Test
    void testCanConstruct_basic() {
        assertTrue(s.canConstruct("aa", "aab"));
        assertTrue(s.canConstruct("abc", "cba"));  // exact counts, different order
        assertTrue(s.canConstruct("aab", "aba")); // still only 2 a's? (clarity: use direct)
    }

    @Test
    void testCanConstruct_withExtraCharactersInMagazine() {
        assertTrue(s.canConstruct("a", "aaaaa"));
        assertTrue(s.canConstruct("abc", "abcccccdddd"));
    }

    @Test
    void testEmptyRansomNote_alwaysTrue() {
        assertTrue(s.canConstruct("", ""));
        assertTrue(s.canConstruct("", "anything"));
    }

    @Test
    void testEmptyMagazine_nonEmptyRansomFalse() {
        assertFalse(s.canConstruct("a", ""));
        assertFalse(s.canConstruct("xyz", ""));
    }

    @Test
    void testUsesCharactersCorrectly_noReuseBeyondCounts() {
        // magazine has only one 'a' and one 'b'
        assertTrue(s.canConstruct("ab", "ab"));
        assertFalse(s.canConstruct("aba", "ab")); // would require reusing 'a'
    }

}