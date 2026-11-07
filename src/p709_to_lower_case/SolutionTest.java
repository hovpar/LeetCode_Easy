package p709_to_lower_case;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldHandleUppercaseAtStart() {
        assertEquals("hello", s.toLowerCase("Hello"));
    }

    @Test
    void shouldHandleNoUppercase() {
        assertEquals("hello", s.toLowerCase("hello"));
    }

    @Test
    void shouldHandleAllUppercase() {
        assertEquals("lovely", s.toLowerCase("LOVELY"));
    }

    @Test
    void shouldHandleSpecialCharacters() {
        assertEquals("al&phabet", s.toLowerCase("al&phaBET"));
    }

    @Test
    void shouldHandleMixedCase() {
        assertEquals("hello world", s.toLowerCase("hElLo WoRlD"));
    }

    @Test
    void shouldHandleDigitsAndSymbols() {
        assertEquals("123!@#abc", s.toLowerCase("123!@#ABC"));
    }

    @Test
    void shouldHandleSingleUppercaseCharacter() {
        assertEquals("a", s.toLowerCase("A"));
    }

    @Test
    void shouldHandleSingleLowercaseCharacter() {
        assertEquals("z", s.toLowerCase("z"));
    }

    @Test
    void shouldHandleEmptyString() {
        assertEquals("", s.toLowerCase(""));
    }
}
