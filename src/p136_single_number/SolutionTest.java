package p136_single_number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(
                new SolutionVariants.BruteForceSolver(),
                new SolutionVariants.SetToggleSolver(),
                new SolutionVariants.XorSolver());
    }

    static Stream<Arguments> singleNumberCases() {
        return solvers().flatMap(
                solver -> Stream.of(
                        Arguments.of(solver, new int[] { 2, 2, 1 }, 1),
                        Arguments.of(solver, new int[] { 4, 1, 2, 1, 2 }, 4),
                        Arguments.of(solver, new int[] { 1 }, 1),
                        Arguments.of(solver, new int[] { 1, 0, 1 }, 0),
                        Arguments.of(solver, new int[] { -1, -1, -7 }, -7),
                        Arguments.of(solver, new int[] { -4, 2, 2 }, -4),
                        Arguments.of(solver, new int[] { -3, 5, -3, 8, 8 }, 5),
                        Arguments.of(
                                solver,
                                new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE },
                                Integer.MAX_VALUE)));
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("singleNumberCases")
    void shouldFindSingleNumber(SolutionVariants.Solver solver, int[] nums, int expected) {
        assertEquals(expected, solver.singleNumber(nums));
    }
}
