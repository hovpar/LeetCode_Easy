package p070_climbing_stairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @ParameterizedTest(name = "{0}: {1} steps -> {2} ways")
    @MethodSource("solverTestCases")
    void shouldReturnNumberOfWays(String solverName, SolutionVariants.Solver solver, int steps, int expectedWays) {
        assertEquals(expectedWays, solver.climbStairs(steps));
    }

    static Stream<Arguments> solverTestCases() {

        var solvers = Stream.of(
                Arguments.of("naive recursion solver", new SolutionVariants.NaiveRecursionSolver()),
                Arguments.of("dp array solver", new SolutionVariants.DPArraySolver()),
                Arguments.of("two variables solver", new SolutionVariants.TwoVariablesSolver()));

        var testCases = List.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8),
                Arguments.of(6, 13),
                Arguments.of(10, 89),
                Arguments.of(20, 10946),
                Arguments.of(30, 1346269),
                Arguments.of(45, 1836311903));

        return solvers.flatMap(solver -> testCases.stream().map(testCase -> {
            var solverArgs = solver.get();
            var testArgs = testCase.get();

            return Arguments.of(solverArgs[0], solverArgs[1], testArgs[0], testArgs[1]);
        }));
    }
}
