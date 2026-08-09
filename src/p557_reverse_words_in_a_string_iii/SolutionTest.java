package p557_reverse_words_in_a_string_iii;

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
        return Stream.of(new SolutionVariants.SplitAndRebuildSolver(), new SolutionVariants.InPlaceCharArraySolver());
    }

    @SolverTest
    void shouldReverseMultipleWords(SolutionVariants.Solver s) {
        assertEquals("s'teL ekat edoCteeL tsetnoc", s.reverseWords("Let's take LeetCode contest"));
    }

    @SolverTest
    void shouldReverseTwoWords(SolutionVariants.Solver s) {
        assertEquals("rM gniD", s.reverseWords("Mr Ding"));
    }

    @SolverTest
    void shouldHandleSingleCharacter(SolutionVariants.Solver s) {
        assertEquals("a", s.reverseWords("a"));
    }

    @SolverTest
    void shouldHandleSingleWord(SolutionVariants.Solver s) {
        assertEquals("olleh", s.reverseWords("hello"));
    }

    @SolverTest
    void shouldHandleTwoSingleCharacterWords(SolutionVariants.Solver s) {
        assertEquals("a b", s.reverseWords("a b"));
    }

    @SolverTest
    void shouldHandleEvenLengthWord(SolutionVariants.Solver s) {
        assertEquals("dcba", s.reverseWords("abcd"));
    }

    @SolverTest
    void shouldHandleOddLengthWord(SolutionVariants.Solver s) {
        assertEquals("edcba", s.reverseWords("abcde"));
    }

    @SolverTest
    void shouldPreserveWordOrder(SolutionVariants.Solver s) {
        assertEquals("eno owt eerht ruof", s.reverseWords("one two three four"));
    }

    @SolverTest
    void shouldHandleDigitsAndLetters(SolutionVariants.Solver s) {
        assertEquals("1a 32b 654c", s.reverseWords("a1 b23 c456"));
    }

    @SolverTest
    void shouldHandlePunctuationAsPartOfWord(SolutionVariants.Solver s) {
        assertEquals("!olleH ,dlrow", s.reverseWords("Hello! world,"));
    }

    @SolverTest
    void shouldHandlePalindrome(SolutionVariants.Solver s) {
        assertEquals("level radar", s.reverseWords("level radar"));
    }

    @SolverTest
    void shouldHandleRepeatedWords(SolutionVariants.Solver s) {
        assertEquals("avaj avaj avaj", s.reverseWords("java java java"));
    }
}
