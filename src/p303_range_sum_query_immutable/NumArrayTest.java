package p303_range_sum_query_immutable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import p303_range_sum_query_immutable.NumArray.NaiveSolver;
import p303_range_sum_query_immutable.NumArray.NumArraySolver;
import p303_range_sum_query_immutable.NumArray.PrefixSumSolver;
import p303_range_sum_query_immutable.NumArray.PrefixSumSolverBasic;

class NumArrayTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("solvers")
    @interface TestEachSolver {
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> solvers() {
        return Stream.of(
                arguments(Named.of("naive solver", (Function<int[], NumArraySolver>) NaiveSolver::new)),
                arguments(
                        Named.of(
                                "prefix sum basic solver",
                                (Function<int[], NumArraySolver>) PrefixSumSolverBasic::new)),
                arguments(Named.of("prefix sum solver", (Function<int[], NumArraySolver>) PrefixSumSolver::new)));
    }

    @TestEachSolver
    void testCorrectRangeSums(Function<int[], NumArraySolver> solverFactory) {
        NumArraySolver numArray = solverFactory.apply(new int[] { -2, 0, 3, -5, 2, -1 });

        assertEquals(1, numArray.sumRange(0, 2)); // -2 + 0 + 3
        assertEquals(-1, numArray.sumRange(2, 5)); // 3 - 5 + 2 - 1
        assertEquals(-3, numArray.sumRange(0, 5)); // full range
    }

    @TestEachSolver
    void testSingleElementArray(Function<int[], NumArraySolver> solverFactory) {
        NumArraySolver numArray = solverFactory.apply(new int[] { 5 });

        assertEquals(5, numArray.sumRange(0, 0));
    }

    @TestEachSolver
    void testAllPositiveNumbers(Function<int[], NumArraySolver> solverFactory) {
        NumArraySolver numArray = solverFactory.apply(new int[] { 1, 2, 3, 4, 5 });

        assertEquals(6, numArray.sumRange(0, 2)); // 1 + 2 + 3
        assertEquals(9, numArray.sumRange(1, 3)); // 2 + 3 + 4
        assertEquals(15, numArray.sumRange(0, 4)); // full range
    }

    @TestEachSolver
    void testAllNegativeNumbers(Function<int[], NumArraySolver> solverFactory) {
        NumArraySolver numArray = solverFactory.apply(new int[] { -1, -2, -3, -4 });

        assertEquals(-6, numArray.sumRange(0, 2));
        assertEquals(-9, numArray.sumRange(1, 3));
    }

    @TestEachSolver
    void testZerosOnly(Function<int[], NumArraySolver> solverFactory) {
        NumArraySolver numArray = solverFactory.apply(new int[] { 0, 0, 0, 0 });

        assertEquals(0, numArray.sumRange(0, 3));
        assertEquals(0, numArray.sumRange(1, 2));
    }

    @TestEachSolver
    void testLeftEqualsRight(Function<int[], NumArraySolver> solverFactory) {
        NumArraySolver numArray = solverFactory.apply(new int[] { 4, -1, 7 });

        assertEquals(4, numArray.sumRange(0, 0));
        assertEquals(-1, numArray.sumRange(1, 1));
        assertEquals(7, numArray.sumRange(2, 2));
    }
}
