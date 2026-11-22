package p748_shortest_completing_word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    private final Solution s = new Solution();

    @ParameterizedTest(name = "{0}")
    @MethodSource("shortestCompletingWordTestCases")
    void shouldReturnShortestCompletingWord(String description, String licensePlate, String[] words, String expected) {
        assertEquals(expected, s.shortestCompletingWord(licensePlate, words));
    }

    static Stream<Arguments> shortestCompletingWordTestCases() {
        return Stream.of(
                Arguments
                        .of("basic example", "1s3 PSt", new String[] { "step", "steps", "stripe", "stepple" }, "steps"),
                Arguments.of(
                        "license plate containing only one letter",
                        "1s3 456",
                        new String[] { "looks", "pest", "stew", "show" },
                        "pest"),
                Arguments.of(
                        "multiple required characters",
                        "Ah71752",
                        new String[] { "suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent",
                                "writer", "old" },
                        "husband"),
                Arguments.of("repeated characters are required", "A1a", new String[] { "a", "aaa", "baa", "aa" }, "aa"),
                Arguments.of("case-insensitive matching", "aB1", new String[] { "apple", "banana", "AB", "cab" }, "AB"),
                Arguments.of(
                        "first word wins when lengths are equal",
                        "a1",
                        new String[] { "bat", "cat", "rat" },
                        "bat"),
                Arguments.of(
                        "shortest word is not the first completing word",
                        "a1",
                        new String[] { "alphabet", "apple", "a" },
                        "a"),
                Arguments.of("license plate contains only digits", "123-456", new String[] { "long", "abc", "a" }, "a"),
                Arguments.of(
                        "word contains more characters than required",
                        "abc",
                        new String[] { "abcd", "abcde", "abcdef" },
                        "abcd"),
                Arguments.of("empty license plate", "", new String[] { "long", "a", "abc" }, "a"));
    }

}
