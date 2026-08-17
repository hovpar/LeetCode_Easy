package p058_length_of_last_word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest(name = "[{index}] \"{0}\" -> {1}")
    @MethodSource("lastWordCases")
    @DisplayName("Returns the length of the last word")
    void shouldReturnLengthOfLastWord(String input, int expectedLength) {
        assertEquals(expectedLength, s.lengthOfLastWord(input));
    }

    private static Stream<Arguments> lastWordCases() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6),
                Arguments.of("a", 1),
                Arguments.of("a  ", 1),
                Arguments.of("one two", 3),
                Arguments.of("one two   ", 3),
                Arguments.of("   single   ", 6));
    }
}
