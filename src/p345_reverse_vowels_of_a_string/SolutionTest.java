package p345_reverse_vowels_of_a_string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    final private Solution s = new Solution();

    @Test
    void testMixedCase() {
        assertEquals("AceCreIm", s.reverseVowels("IceCreAm"));
    }

    @Test
    void testLeetcode() {
        assertEquals("leotcede", s.reverseVowels("leetcode"));
    }

    @Test
    void testNoVowels() {
        assertEquals("bcdfg", s.reverseVowels("bcdfg"));
    }

    @Test
    void testOnlyVowels() {
        assertEquals("uoiea", s.reverseVowels("aeiou"));
    }

    @Test
    void testSingleCharacter() {
        assertEquals("a", s.reverseVowels("a"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", s.reverseVowels(""));
    }

    @Test
    void testSimpleSwap() {
        assertEquals("holle", s.reverseVowels("hello"));
    }

    @Test
    void testUppercase() {
        assertEquals("UOIEA", s.reverseVowels("AEIOU"));
    }

}
