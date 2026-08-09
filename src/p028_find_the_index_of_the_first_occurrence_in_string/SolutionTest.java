package p028_find_the_index_of_the_first_occurrence_in_string;

import static org.junit.Assert.assertEquals;

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
        return Stream.of(new SolutionVariants.BooleanFlagMatcher(), new SolutionVariants.IncrementalMatcher());
    }

    @SolverTest
    void shouldReturnZeroWhenNeedleOccursAtBeginning(SolutionVariants.Solver s) {
        assertEquals(0, s.strStr("sadbutsad", "sad"));
    }

    @SolverTest
    void shouldReturnIndexWhenNeedleOccursInMiddle(SolutionVariants.Solver s) {
        assertEquals(2, s.strStr("hello", "ll"));
    }

    @SolverTest
    void shouldReturnIndexWhenNeedleOccursAtEnd(SolutionVariants.Solver s) {
        assertEquals(3, s.strStr("abcde", "de"));
    }

    @SolverTest
    void shouldReturnMinusOneWhenNeedleDoesNotOccur(SolutionVariants.Solver s) {
        assertEquals(-1, s.strStr("leetcode", "leeto"));
    }

    @SolverTest
    void shouldHandleSingleCharacterMatch(SolutionVariants.Solver s) {
        assertEquals(0, s.strStr("a", "a"));
    }

    @SolverTest
    void shouldHandleSingleCharacterWithoutMatch(SolutionVariants.Solver s) {
        assertEquals(-1, s.strStr("a", "b"));
    }

    @SolverTest
    void shouldReturnMinusOneWhenNeedleIsLongerThanHaystack(SolutionVariants.Solver s) {
        assertEquals(-1, s.strStr("abc", "abcd"));
    }

    @SolverTest
    void shouldContinueSearchingAfterPartialMismatch(SolutionVariants.Solver s) {
        assertEquals(1, s.strStr("aaba", "aba"));
    }

    @SolverTest
    void shouldReturnFirstIndexWhenNeedleOccursMultipleTimes(SolutionVariants.Solver s) {
        assertEquals(0, s.strStr("aaaaa", "aa"));
    }

    @SolverTest
    void shouldHandleOverlappingCandidates(SolutionVariants.Solver s) {
        assertEquals(2, s.strStr("aaab", "ab"));
    }
}
