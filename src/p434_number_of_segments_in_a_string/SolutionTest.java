package p434_number_of_segments_in_a_string;

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
        return Stream.of(new SolutionVariants.SegmentStartScanSolver(), new SolutionVariants.RegexSplitSolver());
    }

    @SolverTest
    void returnsZero_whenEmptyString(SolutionVariants.Solver s) {
        assertEquals(0, s.countSegments(""));
    }

    @SolverTest
    void returnsOne_whenSingleWordNoSpaces(SolutionVariants.Solver s) {
        assertEquals(1, s.countSegments("Hello"));
    }

    @SolverTest
    void returnsFive_whenTypicalSentenceWithSpaces(SolutionVariants.Solver s) {
        assertEquals(5, s.countSegments("Hello, my name is John"));
    }

    @SolverTest
    void returnsZero_whenOnlySpaces(SolutionVariants.Solver s) {
        assertEquals(0, s.countSegments("                "));
    }

    @SolverTest
    void returnsOne_whenLeadingAndTrailingSpacesAroundWord(SolutionVariants.Solver s) {
        assertEquals(1, s.countSegments("   Hello   "));
    }

    @SolverTest
    void returnsTwo_whenMultipleSpacesBetweenWords(SolutionVariants.Solver s) {
        assertEquals(2, s.countSegments("Hello     world"));
    }

    @SolverTest
    void countsPunctuationAsPartOfSegments_whenSeparatedByWhitespace(SolutionVariants.Solver s) {
        assertEquals(3, s.countSegments("hi, there! :)"));
    }

    @SolverTest
    void returnsOne_whenOnlyPunctuationNoWhitespace(SolutionVariants.Solver s) {
        assertEquals(1, s.countSegments("..."));
    }

    @SolverTest
    void returnsOne_whenSingleCharacterWord(SolutionVariants.Solver s) {
        assertEquals(1, s.countSegments("a"));
    }

}
