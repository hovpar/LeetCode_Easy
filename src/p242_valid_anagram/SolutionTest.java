package p242_valid_anagram;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    void testValidAnagram() {
        assertTrue(sol.isAnagram("anagram", "nagaram"));
    }

    @Test
    void testNotAnagramDifferentLetters() {
        assertFalse(sol.isAnagram("rat", "car"));
    }

    @Test
    void testEmptyStringsAreAnagrams() {
        assertTrue(sol.isAnagram("", ""));
    }

    @Test
    void testDifferentLengthStrings() {
        assertFalse(sol.isAnagram("a", "aa"));
    }

    @Test
    void testSameCharactersDifferentFrequencies() {
        assertFalse(sol.isAnagram("aabb", "ab"));
    }

//    @Test
//    void testStringsWithUpperAndLowerCase() {
//        // Depending on your implementation: this will fail unless normalized
//        assertFalse(sol.isAnagram("Listen", "Silent"));
//    }

//    @Test
//    void testUnicodeCharacters() {
//        assertTrue(sol.isAnagram("еяз", "язе"));
//    }

//    @Test
//    void testWhitespaceIsSignificant() {
//        assertTrue(sol.isAnagram("a b", "ab "));
//    }

    @Test
    void testLongStrings() {
        String s = "aaaaabbbbbcccccdddde";
        String t = "eaaaaabbbbbcccccdddd";
        assertTrue(sol.isAnagram(s, t));
    }

}
