package p283_move_zeroes;

import static org.junit.Assert.assertArrayEquals;
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
                arguments(Named.of("two pointer swaps solver", new SolutionVariants.TwoPointerSwapSolver())),
                arguments(Named.of("two pass overwrite solver", new SolutionVariants.TwoPassOverwriteSolver())));
    }

    @TestEachSolver
    void testSingleElement(SolutionVariants.Solver solver) {
        int[] nums = { 0 };
        solver.moveZeroes(nums);
        int[] expected = { 0 };
        assertArrayEquals(expected, nums);
    }

    @TestEachSolver
    void testNoNeedToMove(SolutionVariants.Solver solver) {
        int[] nums = { 1, 0 };
        solver.moveZeroes(nums);
        int[] expected = { 1, 0 };
        assertArrayEquals(expected, nums);
    }

    @TestEachSolver
    void testOnlyTwoElements(SolutionVariants.Solver solver) {
        int[] nums = { 0, 1 };
        solver.moveZeroes(nums);
        int[] expected = { 1, 0 };
        assertArrayEquals(expected, nums);
    }

    @TestEachSolver
    void testZeroesAtEnd(SolutionVariants.Solver solver) {
        int[] nums = { 0, 1, 0, 0, 0 };
        solver.moveZeroes(nums);
        int[] expected = { 1, 0, 0, 0, 0 };
        assertArrayEquals(expected, nums);
    }

    @TestEachSolver
    void testMultipleMoves(SolutionVariants.Solver solver) {
        int[] nums = { 0, 1, 0, 3, 12 };
        solver.moveZeroes(nums);
        int[] expected = { 1, 3, 12, 0, 0 };
        assertArrayEquals(expected, nums);
    }

    @TestEachSolver
    void testNoZeros(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 4 };
        solver.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, nums);
    }

    @TestEachSolver
    void testAllZeros(SolutionVariants.Solver solver) {
        int[] nums = { 0, 0, 0 };
        solver.moveZeroes(nums);
        assertArrayEquals(new int[] { 0, 0, 0 }, nums);
    }

    @TestEachSolver
    void testZerosAlreadyAtEnd(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 0, 0 };
        solver.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 2, 3, 0, 0 }, nums);
    }

    @TestEachSolver
    void testWithNegativeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { 0, -1, 0, -3, 2 };
        solver.moveZeroes(nums);
        assertArrayEquals(new int[] { -1, -3, 2, 0, 0 }, nums);
    }

    @TestEachSolver
    void testEmptyArray(SolutionVariants.Solver solver) {
        int[] nums = {};
        solver.moveZeroes(nums);
        assertArrayEquals(new int[] {}, nums);
    }

}
