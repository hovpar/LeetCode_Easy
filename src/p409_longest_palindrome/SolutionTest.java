package p409_longest_palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest
    @MethodSource("solvers")
    @interface SolverTest {
    }

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.FrequencyMapSolver(), new SolutionVariants.ParitySetSolver(),
                new SolutionVariants.FixedSizeFrequencyArraySolver());
    }

    @SolverTest
    void testUsesSingleOddCharacterAsCenter(SolutionVariants.Solver s) {
        assertEquals(7, s.longestPalindrome("abccccdd"));
    }

    @SolverTest
    void testSingleLetter(SolutionVariants.Solver s) {
        assertEquals(1, s.longestPalindrome("a"));
    }

    @SolverTest
    void testEmptyString(SolutionVariants.Solver s) {
        assertEquals(0, s.longestPalindrome(""));
    }

    @SolverTest
    void testAllEvenCounts(SolutionVariants.Solver s) {
        // All characters can be fully used
        assertEquals(6, s.longestPalindrome("aabbcc"));
    }

    @SolverTest
    void testMultipleOddCounts(SolutionVariants.Solver s) {
        // Only one odd-count character can contribute +1 center
        assertEquals(7, s.longestPalindrome("aaabbbb"));
    }

    @SolverTest
    void testAllOddSingleOccurrences(SolutionVariants.Solver s) {
        // Only one character can be used
        assertEquals(1, s.longestPalindrome("abc"));
    }

    @SolverTest
    void testCaseSensitivity(SolutionVariants.Solver s) {
        // 'A' and 'a' are different characters
        assertEquals(1, s.longestPalindrome("Aa"));
    }

    @SolverTest
    void testLargeRepeatedCharacters(SolutionVariants.Solver s) {
        assertEquals(1000, s.longestPalindrome("a".repeat(1000)));
    }

    @SolverTest
    void testPalindromeAlready(SolutionVariants.Solver s) {
        assertEquals(7, s.longestPalindrome("racecar"));
    }

}
