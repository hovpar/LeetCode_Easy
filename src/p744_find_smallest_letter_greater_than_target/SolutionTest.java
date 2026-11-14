package p744_find_smallest_letter_greater_than_target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnFirstLetterWhenTargetIsSmallerThanAllLetters() {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('c', s.nextGreatestLetter(letters, 'a'));
    }

    @Test
    void shouldReturnNextLetterWhenTargetExists() {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('f', s.nextGreatestLetter(letters, 'c'));
    }

    @Test
    void shouldWrapAroundWhenTargetIsGreaterThanAllLetters() {
        char[] letters = { 'x', 'x', 'y', 'y' };

        assertEquals('x', s.nextGreatestLetter(letters, 'z'));
    }

    @Test
    void shouldReturnNextLetterWhenTargetIsBetweenLetters() {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('j', s.nextGreatestLetter(letters, 'g'));
    }

    @Test
    void shouldWrapAroundWhenTargetEqualsLastLetter() {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('c', s.nextGreatestLetter(letters, 'j'));
    }

    @Test
    void shouldHandleDuplicateLetters() {
        char[] letters = { 'c', 'f', 'f', 'f', 'j' };

        assertEquals('j', s.nextGreatestLetter(letters, 'f'));
    }

    @Test
    void shouldReturnFirstGreaterLetterAmongDuplicates() {
        char[] letters = { 'c', 'c', 'f', 'f', 'j' };

        assertEquals('f', s.nextGreatestLetter(letters, 'c'));
    }

    @Test
    void shouldHandleSingleElementArray() {
        char[] letters = { 'a' };

        assertEquals('a', s.nextGreatestLetter(letters, 'a'));
    }

    @Test
    void shouldHandleSingleElementArrayWithSmallerTarget() {
        char[] letters = { 'a' };

        assertEquals('a', s.nextGreatestLetter(letters, '`'));
    }

    @Test
    void shouldHandleBoundaryCharacters() {
        char[] letters = { 'a', 'z' };

        assertEquals('z', s.nextGreatestLetter(letters, 'a'));
        assertEquals('a', s.nextGreatestLetter(letters, 'z'));
    }

}
