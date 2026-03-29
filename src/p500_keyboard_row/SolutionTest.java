package p500_keyboard_row;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnOnlyWordsTypedFromSingleKeyboardRow() {
        String[] words = { "Hello", "Alaska", "Dad", "Peace" };
        String[] expected = { "Alaska", "Dad" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldReturnEmptyArrayWhenNoWordFits() {
        String[] words = { "omk" };
        String[] expected = {};

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldReturnAllWordsWhenAllFitSingleRow() {
        String[] words = { "adsdf", "sfd" };
        String[] expected = { "adsdf", "sfd" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldHandleSingleWordFromTopRow() {
        String[] words = { "typewriter" };
        String[] expected = { "typewriter" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldHandleSingleWordFromMiddleRow() {
        String[] words = { "Alaska" };
        String[] expected = { "Alaska" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldHandleSingleWordFromBottomRow() {
        String[] words = { "zxcvb" };
        String[] expected = { "zxcvb" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldPreserveOriginalOrderOfMatchingWords() {
        String[] words = { "Dad", "Peace", "Alaska", "Hello", "qwerty" };
        String[] expected = { "Dad", "Alaska", "qwerty" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldAcceptUppercaseWords() {
        String[] words = { "DAD", "ALASKA", "QWERTY", "PEACE" };
        String[] expected = { "DAD", "ALASKA", "QWERTY" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldAcceptMixedCaseWords() {
        String[] words = { "DaD", "aLaSkA", "QwErTy", "PeAcE" };
        String[] expected = { "DaD", "aLaSkA", "QwErTy" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldReturnEmptyArrayForEmptyInputArray() {
        String[] words = {};
        String[] expected = {};

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldHandleOneLetterWordsAsValid() {
        String[] words = { "a", "Z", "m" };
        String[] expected = { "a", "Z", "m" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldRejectWordsUsingMultipleRows() {
        String[] words = { "tree", "milk", "sad", "row" };
        String[] expected = { "tree", "sad", "row" };

        assertArrayEquals(expected, s.findWords(words));
    }

    @Test
    void shouldHandleDuplicateMatchingWords() {
        String[] words = { "Dad", "Dad", "Peace", "Alaska", "Alaska" };
        String[] expected = { "Dad", "Dad", "Alaska", "Alaska" };

        assertArrayEquals(expected, s.findWords(words));
    }
}