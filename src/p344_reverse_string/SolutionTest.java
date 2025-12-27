package p344_reverse_string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testSingleCharacter() {
        char[] input = { 'a' };
        s.reverseString(input);
        assertArrayEquals(new char[] { 'a' }, input);
    }

    @Test
    void testTwoCharacters() {
        char[] input = { 'a', 'b' };
        s.reverseString(input);
        assertArrayEquals(new char[] { 'b', 'a' }, input);
    }

    @Test
    void testOddLengthString() {
        char[] input = { 'h', 'e', 'l', 'l', 'o' };
        s.reverseString(input);
        assertArrayEquals(new char[] { 'o', 'l', 'l', 'e', 'h' }, input);
    }

    @Test
    void testEvenLengthString() {
        char[] input = { 'a', 'b', 'c', 'd' };
        s.reverseString(input);
        assertArrayEquals(new char[] { 'd', 'c', 'b', 'a' }, input);
    }

    @Test
    void testEmptyArray() {
        char[] input = {};
        s.reverseString(input);
        assertArrayEquals(new char[] {}, input);
    }

    @Test
    void testRepeatedCharacters() {
        char[] input = { 'a', 'a', 'a' };
        s.reverseString(input);
        assertArrayEquals(new char[] { 'a', 'a', 'a' }, input);
    }

    @Test
    void testMixedCharacters() {
        char[] input = { 'A', '1', '!', 'z' };
        s.reverseString(input);
        assertArrayEquals(new char[] { 'z', '!', '1', 'A' }, input);
    }

}
