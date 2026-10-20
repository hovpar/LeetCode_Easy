package p696_count_binary_substrings;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
                arguments(
                        Named.of(
                                "count consecutive blocks solver",
                                new SolutionVariants.CountConsecutiveBlocksSolver())),
                arguments(Named.of("two pointer solver", new SolutionVariants.TwoPointerSolver())));
    }

    @TestEachSolver
    void shouldReturnZeroForSingleCharacter(SolutionVariants.Solver solver) {
        assertEquals(0, solver.countBinarySubstrings("0"));
        assertEquals(0, solver.countBinarySubstrings("1"));
    }

    @TestEachSolver
    void shouldReturnOneForTwoDifferentBits(SolutionVariants.Solver solver) {
        assertEquals(1, solver.countBinarySubstrings("01"));
        assertEquals(1, solver.countBinarySubstrings("10"));
    }

    @TestEachSolver
    void shouldReturnZeroWhenAllBitsAreEqual(SolutionVariants.Solver solver) {
        assertEquals(0, solver.countBinarySubstrings("00000"));
        assertEquals(0, solver.countBinarySubstrings("11111"));
    }

    @TestEachSolver
    void shouldCountSubstringsWithUnequalBlockLengths(SolutionVariants.Solver solver) {
        assertEquals(2, solver.countBinarySubstrings("00011"));
        assertEquals(2, solver.countBinarySubstrings("00111"));
        assertEquals(3, solver.countBinarySubstrings("000111"));
    }

    @TestEachSolver
    void shouldCountSubstringsAcrossSeveralBlocks(SolutionVariants.Solver solver) {
        assertEquals(6, solver.countBinarySubstrings("001110011"));
        assertEquals(6, solver.countBinarySubstrings("000111000"));
    }

    @TestEachSolver
    void shouldHandleAlternatingBits(SolutionVariants.Solver solver) {
        assertEquals(4, solver.countBinarySubstrings("10101"));
        assertEquals(5, solver.countBinarySubstrings("010101"));
    }

    @TestEachSolver
    void shouldCountSubstringsAtBothEnds(SolutionVariants.Solver solver) {
        assertEquals(6, solver.countBinarySubstrings("00110011"));
        assertEquals(4, solver.countBinarySubstrings("110011"));
    }

    @TestEachSolver
    void shouldHandleLongRunsOfEqualBits(SolutionVariants.Solver solver) {
        assertEquals(1, solver.countBinarySubstrings("0000001"));
        assertEquals(1, solver.countBinarySubstrings("1000000"));
    }
}
