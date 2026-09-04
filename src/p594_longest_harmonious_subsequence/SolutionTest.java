package p594_longest_harmonious_subsequence;

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
                arguments(Named.of("counting solver", new SolutionVariants.CountingSolver())),
                arguments(Named.of("sort solver", new SolutionVariants.ArraySortSolver())),
                arguments(Named.of("hashmap solver", new SolutionVariants.HashMapSolver())));
    }

    @TestEachSolver
    void shouldReturnZeroWhenAllValuesAreEqual(SolutionVariants.Solver s) {
        int[] nums = { 1, 1, 1, 1 };
        assertEquals(0, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldReturnZeroWhenNoTwoValuesDifferByOne(SolutionVariants.Solver s) {
        int[] nums = { 1, 3, 5, 7 };
        assertEquals(0, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleSmallestPossibleLHS(SolutionVariants.Solver s) {
        int[] nums = { 1, 2 };
        assertEquals(2, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleOneLHS(SolutionVariants.Solver s) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        assertEquals(5, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleMultipleLHSs(SolutionVariants.Solver s) {
        int[] nums = { 1, 2, 3, 4 };
        assertEquals(2, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldChooseLargestLHSAmongMultipleCandidates(SolutionVariants.Solver s) {
        int[] nums = { 1, 2, 1, 3, 0, 0, 2, 2, 1, 3, 3 };
        assertEquals(6, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleDuplicates(SolutionVariants.Solver s) {
        int[] nums = { 1, 1, 1, 2, 2 };
        assertEquals(5, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldIgnoreValuesThatAreNotPartOfTheLHS(SolutionVariants.Solver s) {
        int[] nums = { 1, 1, 1, 2, 2, 4, 4, 4, 4 };
        assertEquals(5, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleNegativeValues(SolutionVariants.Solver s) {
        int[] nums = { -3, -3, -2, -2, -2, 5 };
        assertEquals(5, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleNegativeAndPositiveValues(SolutionVariants.Solver s) {
        int[] nums = { -1, 0, 0, 1, 1, 1 };
        assertEquals(5, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleUnorderedInput(SolutionVariants.Solver s) {
        int[] nums = { 3, 1, 2, 2, 1, 3, 2 };
        assertEquals(5, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleSingleElement(SolutionVariants.Solver s) {
        int[] nums = { 1 };
        assertEquals(0, s.findLHS(nums));
    }

    @TestEachSolver
    void shouldHandleEmptyArray(SolutionVariants.Solver s) {
        int[] nums = {};
        assertEquals(0, s.findLHS(nums));
    }

}
