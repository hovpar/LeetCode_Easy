package p448_find_all_numbers_disappeared_in_an_array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
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
        return Stream.of(new SolutionVariants.HashSetSolver(), new SolutionVariants.InPlaceSolver());
    }

    @SolverTest
    void returnsMissingNumbersForTypicalCase(SolutionVariants.Solver s) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> expected = List.of(5, 6);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @SolverTest
    void returnsSingleMissingNumber(SolutionVariants.Solver s) {
        int[] nums = { 1, 1 };
        List<Integer> expected = List.of(2);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @SolverTest
    void returnsEmptyListWhenNoNumbersMissing(SolutionVariants.Solver s) {
        int[] nums = { 1, 2, 3, 4, 5 };
        List<Integer> expected = List.of();

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @SolverTest
    void returnsAllExceptOneWhenAllElementsSame(SolutionVariants.Solver s) {
        int[] nums = { 2, 2, 2, 2 };
        List<Integer> expected = List.of(1, 3, 4);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @SolverTest
    void handlesSingleElementArrayPresent(SolutionVariants.Solver s) {
        int[] nums = { 1 };
        List<Integer> expected = List.of();

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @SolverTest
    void handlesAllNumbersMissingExceptOne(SolutionVariants.Solver s) {
        int[] nums = { 1, 1, 1, 1, 1 };
        List<Integer> expected = List.of(2, 3, 4, 5);

        assertEquals(expected, s.findDisappearedNumbers(nums));
    }

    @SolverTest
    void worksWithLargeSequentialInput(SolutionVariants.Solver s) {
        int n = 1000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        assertEquals(List.of(), s.findDisappearedNumbers(nums));
    }

}
