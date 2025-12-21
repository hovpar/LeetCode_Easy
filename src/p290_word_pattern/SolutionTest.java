package p290_word_pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testValidPattern() {
        assertTrue(s.wordPattern("abba", "dog cat cat dog"));
    }

    @Test
    void testInvalidPatternMapping() {
        assertFalse(s.wordPattern("abba", "dog cat cat fish"));
    }

    @Test
    void testInvalidWordReuse() {
        assertFalse(s.wordPattern("aaaa", "dog cat cat dog"));
    }

    @Test
    void testSingleCharacter() {
        assertTrue(s.wordPattern("a", "dog"));
    }

    @Test
    void testLengthMismatch() {
        assertFalse(s.wordPattern("ab", "dog"));
    }

    @Test
    void testSameWordsDifferentPattern() {
        assertFalse(s.wordPattern("ab", "dog dog"));
    }

    @Test
    void testDifferentWordsSamePattern() {
        assertTrue(s.wordPattern("ab", "dog cat"));
    }

    @Test
    void testEmptyStrings() {
        assertTrue(s.wordPattern("", ""));
    }

}
