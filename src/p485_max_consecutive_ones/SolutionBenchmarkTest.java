package p485_max_consecutive_ones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionBenchmarkTest {

    @Test
    void compareSolvers() {
        int[] input = new int[100_000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (i % 3 == 0) ? 0 : 1;
        }

        List<SolutionVariants.Solver> solvers = List.of(new SolutionVariants.RunningCountSolver(),
                new SolutionVariants.EndOfStreakSolver(), new SolutionVariants.TwoPointerSolver());

        for (SolutionVariants.Solver solver : solvers) {
            for (int i = 0; i < 5_000; i++) {
                solver.findMaxConsecutiveOnes(input);
            }

            long start = System.nanoTime();

            int result = 0;
            for (int i = 0; i < 20_000; i++) {
                result = solver.findMaxConsecutiveOnes(input);
            }

            long end = System.nanoTime();

            assertEquals(2, result);

            System.out.printf("%s: %.3f ms%n", solver.getClass().getSimpleName(), (end - start) / 1_000_000.0);
        }
    }

}
