package p389_find_the_difference;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testSIsEmpty() {
	assertEquals('y', s.findTheDifference("", "y"));
    }

    @Test
    void testExtraAtBeginning() {
	assertEquals('z', s.findTheDifference("abcd", "zabcd"));
    }

    @Test
    void testExtraInMiddle() {
	assertEquals('x', s.findTheDifference("abcd", "abxcd"));
    }

    @Test
    void testExtraAtEnd() {
	assertEquals('q', s.findTheDifference("abcd", "abcdq"));
    }

    @Test
    void testDuplicateLettersExtraIsDuplicate() {
	// s has two 'a' and one 'b'; t has an extra 'a'
	assertEquals('a', s.findTheDifference("aab", "aaab"));
    }

    @Test
    void testManyDuplicatesExtraDifferent() {
	assertEquals('c', s.findTheDifference("aabb", "ababc"));
    }

    @Test
    void testSingleCharS() {
	assertEquals('b', s.findTheDifference("a", "ab"));
    }

    @Test
    void testAllSameLetters() {
	assertEquals('a', s.findTheDifference("bbbb", "bbbba"));
    }

    @Test
    void testLargeInputStillWorks() {
	String s1 = "a".repeat(10_000) + "b".repeat(10_000);
	String t1 = s1 + "c";
	assertEquals('c', s.findTheDifference(s1, t1));
    }

}
