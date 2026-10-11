package p680_valid_palindrome_ii;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("solvers")
    @interface TestEachSolver {
    }

    static Stream<Arguments> solvers() {
        return Stream.of(
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())),
                arguments(Named.of("recursive solver", new SolutionVariants.RecursiveSolver())));
    }

    @TestEachSolver
    void shouldReturnTrueForAlreadyValidPalindromes(SolutionVariants.Solver s) {
        assertTrue(s.validPalindrome(""));
        assertTrue(s.validPalindrome("a"));
        assertTrue(s.validPalindrome("aa"));
        assertTrue(s.validPalindrome("aba"));
        assertTrue(s.validPalindrome("abba"));
        assertTrue(s.validPalindrome("racecar"));
    }

    @TestEachSolver
    void shouldReturnTrueWhenOneCharacterCanBeDeleted(SolutionVariants.Solver s) {
        assertTrue(s.validPalindrome("ab"));
        assertTrue(s.validPalindrome("abca"));
        assertTrue(s.validPalindrome("deeee"));
        assertTrue(s.validPalindrome("eeeed"));
        assertTrue(s.validPalindrome("raceacar"));
    }

    @TestEachSolver
    void shouldReturnFalseWhenMoreThanOneDeletionIsRequired(SolutionVariants.Solver s) {
        assertFalse(s.validPalindrome("abc"));
        assertFalse(s.validPalindrome("abcdef"));
        assertFalse(s.validPalindrome("abecbea"));
    }

    @TestEachSolver
    void shouldHandleMismatchesNearTheEnds(SolutionVariants.Solver s) {
        assertTrue(s.validPalindrome("baa"));
        assertTrue(s.validPalindrome("aab"));
        assertTrue(s.validPalindrome("abca"));
    }

    @TestEachSolver
    void shouldHandleRepeatedCharacters(SolutionVariants.Solver s) {
        assertTrue(s.validPalindrome("aaaa"));
        assertTrue(s.validPalindrome("aabaa"));
        assertTrue(s.validPalindrome("abbab"));
    }

    @TestEachSolver
    void shouldHandleLongStrings(SolutionVariants.Solver s) {
        assertTrue(s.validPalindrome("abcdeffedcba"));
        assertFalse(s.validPalindrome("abcdefghijk"));
    }

}
