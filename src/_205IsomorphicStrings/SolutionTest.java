package _205IsomorphicStrings;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void simpleIsomorphicPair() {
        assertTrue(solution.isIsomorphic("egg", "add")); // e->a, g->d
    }

    @Test
    void differentCharactersMapToSame() {
        assertFalse(solution.isIsomorphic("foo", "bar")); // o->a vs o->r conflict
    }

    @Test
    void complexIsomorphicPair() {
        assertTrue(solution.isIsomorphic("paper", "title")); // consistent pattern
    }

    @Test
    void repeatedPatternBreaksMapping() {
        assertFalse(solution.isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    @Test
    void mappingInconsistentAcrossPairs() {
        assertFalse(solution.isIsomorphic("badc", "kikp")); // a->i, d->k then c->p fails consistency
    }

    @Test
    void singleCharacterStrings() {
        assertTrue(solution.isIsomorphic("a", "a")); // trivial 1-char
    }

    @Test
    void samePatternDifferentCharacters() {
        assertTrue(solution.isIsomorphic("ab", "cd")); // distinct consistent mapping
    }

    @Test
    void twoCharsMapToSameChar() {
        assertFalse(solution.isIsomorphic("ab", "cc")); // a->c, b->c not allowed
    }

    @Test
    void repeatedPatternConsistent() {
        assertTrue(solution.isIsomorphic("aa", "bb")); // same char maps consistently
    }

    @Test
    void conflictAppearsLaterInString() {
        assertFalse(solution.isIsomorphic("abca", "zbxx")); // a->z first, a->x later conflict
    }

    @Test
    void largeConsistentPattern() {
        String s = "abcdabcdabcd";
        String t = "wxyzwxyzwxyz";
        assertTrue(solution.isIsomorphic(s, t));
    }
}
