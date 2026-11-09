package p717_1_bit_and_2_bit_characters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnTrueWhenLastCharacterIsOneBit() {
        assertTrue(s.isOneBitCharacter(new int[] { 1, 0, 0 }));
    }

    @Test
    void shouldReturnFalseWhenLastCharacterIsPartOfTwoBitCharacter() {
        assertFalse(s.isOneBitCharacter(new int[] { 1, 1, 1, 0 }));
    }

    @Test
    void shouldHandleSingleZero() {
        assertTrue(s.isOneBitCharacter(new int[] { 0 }));
    }

    @Test
    void shouldHandleMultipleOneBitCharacters() {
        assertTrue(s.isOneBitCharacter(new int[] { 0, 0, 0 }));
    }

    @Test
    void shouldHandleTwoBitCharacterFollowedByOneBitCharacter() {
        assertTrue(s.isOneBitCharacter(new int[] { 1, 0, 0 }));
    }

    @Test
    void shouldHandleTwoBitCharacterAtTheEnd() {
        assertFalse(s.isOneBitCharacter(new int[] { 0, 1, 1 }));
    }

    @Test
    void shouldHandleConsecutiveTwoBitCharacters() {
        assertTrue(s.isOneBitCharacter(new int[] { 1, 1, 0 }));
    }

    @Test
    void shouldHandleLongSequenceOfTwoBitCharacters() {
        assertTrue(s.isOneBitCharacter(new int[] { 1, 1, 1, 0, 0 }));
    }

}
