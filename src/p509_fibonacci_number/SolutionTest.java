package p509_fibonacci_number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest
    @MethodSource("solverAndCases")
    @interface SolverTest {
    }

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.RecursiveSolver(), new SolutionVariants.MemoizedRecursiveSolver(),
                new SolutionVariants.IterativeSolver());
    }

    static Stream<Arguments> solverAndCases() {
        int[][] cases = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {10, 55},
                {15, 610},
                {20, 6765},
                {30, 832040}
        };

        return solvers().flatMap(
                s -> IntStream.range(0, cases.length).mapToObj(i -> Arguments.of(s, cases[i][0], cases[i][1])));
    }

    @ParameterizedTest
    @MethodSource("solverAndCases")
    void returnsCorrectFibonacciNumber(SolutionVariants.Solver s, int n, int expected) {
        assertEquals(expected, s.fib(n));
    }
}
