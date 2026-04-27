package p001_two_sum;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        return Stream.of(new SolutionVariants.BruteForceSolver(), new SolutionVariants.HashMapSolver());
    }

    @SolverTest
    void testSimpleCase(SolutionVariants.Solver s) {
        int[] array = { 2, 7, 11, 15 };
        int[] expected = { 0, 1 };
        assertArrayEquals(expected, s.twoSum(array, 9));
    }

    @SolverTest
    void testMultipleSolutions(SolutionVariants.Solver s) {
        int[] array = { 3, 2, 4 };
        int[] expected = { 1, 2 };
        assertArrayEquals(expected, s.twoSum(array, 6));
    }

    @SolverTest
    void testSameElementTwice(SolutionVariants.Solver s) {
        int[] array = { 3, 3 };
        int[] expected = { 0, 1 };
        assertArrayEquals(expected, s.twoSum(array, 6));
    }

    @SolverTest
    void testFirstAndLastElement(SolutionVariants.Solver s) {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] result = s.twoSum(array, 5);
        // Accept any valid solution (1+4 or 2+3)
        int sum = array[result[0]] + array[result[1]];
        assertEquals(5, sum);
    }

    @SolverTest
    void testWithNegativeNumbers(SolutionVariants.Solver s) {
        int[] array = { -3, 4, 3, 90 };
        int[] expected = { 0, 2 };
        assertArrayEquals(expected, s.twoSum(array, 0));
    }

    @SolverTest
    void testMixedPositiveAndNegative(SolutionVariants.Solver s) {
        int[] array = { 1, -1, 2, -2, 3, -3 };
        int[] expected = { 1, 2 };
        assertArrayEquals(expected, s.twoSum(array, 1));
    }

    @SolverTest
    void testDuplicateElements(SolutionVariants.Solver s) {
        int[] array = { 5, 5, 10 };
        int[] expected = { 0, 1 };
        assertArrayEquals(expected, s.twoSum(array, 10));
    }

    @SolverTest
    void testNoSolution(SolutionVariants.Solver s) {
        int[] array = { 1, 2, 3 };
        int[] expected = {};
        assertArrayEquals(expected, s.twoSum(array, 10));
    }

}
