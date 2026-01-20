package p387_first_unique_character_in_a_string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testExampleLeetcode() {
	assertEquals(0, s.firstUniqChar("leetcode")); // 'l'
    }

    @Test
    void testExampleLoveleetcode() {
	assertEquals(2, s.firstUniqChar("loveleetcode")); // 'v'
    }

    @Test
    void testNoUniqueCharacters() {
	assertEquals(-1, s.firstUniqChar("aabb"));
    }

    @Test
    void testEmptyString() {
	assertEquals(-1, s.firstUniqChar(""));
    }

    @Test
    void testSingleCharacter() {
	assertEquals(0, s.firstUniqChar("z"));
    }

    @Test
    void testAllSameCharacter() {
	assertEquals(-1, s.firstUniqChar("aaaaaa"));
    }

    @Test
    void testUniqueAtEnd() {
	assertEquals(4, s.firstUniqChar("aabbc")); // 'c'
    }

    @Test
    void testFirstUniqueIsEarliestByIndex() {
	assertEquals(1, s.firstUniqChar("abac")); // 'b' at index 1
    }

    @Test
    void testMultipleUniquesPickFirstByIndex() {
	assertEquals(2, s.firstUniqChar("ccad"));
    }

    @Test
    void testUniqueInMiddle() {
	assertEquals(4, s.firstUniqChar("aabbcdd"));
    }

}
