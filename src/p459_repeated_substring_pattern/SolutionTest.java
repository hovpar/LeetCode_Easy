package p459_repeated_substring_pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionTest {

    private final Solution s = new Solution();

    // -------- TRUE cases --------

    @ParameterizedTest(name = "shouldReturnTrue for \"{0}\"")
    @ValueSource(strings = { "abab",              // "ab" * 2
            "ababab",            // "ab" * 3
            "abcabcabcabc",      // "abc" * 4
            "aaaa",              // "a" * 4
            "zzzzzz",            // "z" * 6
            "xyzxyz",            // "xyz" * 2
            "abaaba",            // "aba" * 2 (pattern length 3)
            "abcaabca"           // "abca" * 2 (pattern length 4)
    })
    void shouldReturnTrue_whenStringIsMadeOfRepeatedSubstring(String input) {
        assertTrue(s.repeatedSubstringPattern(input));
    }

    // -------- FALSE cases --------

    @ParameterizedTest(name = "shouldReturnFalse for \"{0}\"")
    @ValueSource(strings = { "aba",       // not a full repetition
            "a",         // length 1 cannot repeat
            "ab",        // cannot repeat a shorter substring to get "ab"
            "abcd",      // no repetition
            "ababa",     // looks repetitive but is not exact repetition
            "abaabb",    // partial overlaps do not count
            "abcab",     // prefix repeats but not whole string
            "aaaaab",    // almost all same, last char breaks it
            "abababa"    // odd-length breaks "ab" repetition
    })
    void shouldReturnFalse_whenStringIsNotMadeOfRepeatedSubstring(String input) {
        assertFalse(s.repeatedSubstringPattern(input));
    }

    // -------- Focused edge tests (nice to keep explicit) --------

    @Test
    void shouldReturnFalse_forSingleCharacter() {
        assertFalse(s.repeatedSubstringPattern("x"));
    }

    @Test
    void shouldReturnTrue_forAllSameCharacter() {
        assertTrue(s.repeatedSubstringPattern("bbbbbbbb")); // "b" * 8
    }

    @Test
    void shouldReturnFalse_forPrimeLengthNonUniformString() {
        // prime length (7) makes repetition harder; still possible only if all chars
        // same, which it's not
        assertFalse(s.repeatedSubstringPattern("abcdefg"));
    }

    @Test
    void shouldReturnTrue_whenPatternLengthIsMoreThanOne() {
        assertTrue(s.repeatedSubstringPattern("abcdabcdabcd")); // "abcd" * 3
    }
}