package p495_teemo_attacking;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        return Stream.of(new SolutionVariants.IntervalEndSolver(), new SolutionVariants.GapSolver());
    }

    // Not required in LeetCode
    @SolverTest
    void shouldReturnZeroWhenThereAreNoAttacks(SolutionVariants.Solver s) {
        assertEquals(0, s.findPoisonedDuration(new int[] {}, 2));
    }

    @SolverTest
    void shouldReturnDurationForSingleAttack(SolutionVariants.Solver s) {
        assertEquals(5, s.findPoisonedDuration(new int[] { 10 }, 5));
    }

    @SolverTest
    void shouldReturnZeroWhenDurationIsZero(SolutionVariants.Solver s) {
        assertEquals(0, s.findPoisonedDuration(new int[] { 1, 2, 3, 4, 5 }, 0));
    }

    @SolverTest
    void shouldSumDurationsWhenAttacksDoNotOverlap(SolutionVariants.Solver s) {
        assertEquals(4, s.findPoisonedDuration(new int[] { 1, 4 }, 2));
    }

    @SolverTest
    void shouldMergePoisonTimeWhenTwoAttacksOverlap(SolutionVariants.Solver s) {
        assertEquals(3, s.findPoisonedDuration(new int[] { 1, 2 }, 2));
    }

    @SolverTest
    void shouldHandleContinuousOverlappingAttacks(SolutionVariants.Solver s) {
        assertEquals(5, s.findPoisonedDuration(new int[] { 1, 2, 3, 4 }, 2));
    }

    @SolverTest
    void shouldHandleMixedOverlappingAndNonOverlappingAttacks(SolutionVariants.Solver s) {
        assertEquals(8, s.findPoisonedDuration(new int[] { 1, 4, 5 }, 4));
    }

    @SolverTest
    void shouldHandleLargeGapBetweenAttacks(SolutionVariants.Solver s) {
        assertEquals(6, s.findPoisonedDuration(new int[] { 1, 10 }, 3));
    }

    @SolverTest
    void shouldHandleExactBoundaryTouchingAsNonOverlapping(SolutionVariants.Solver s) {
        assertEquals(4, s.findPoisonedDuration(new int[] { 1, 3 }, 2));
    }

    @SolverTest
    void shouldHandleLongChainOfOverlaps(SolutionVariants.Solver s) {
        assertEquals(10, s.findPoisonedDuration(new int[] { 1, 2, 3, 4, 5, 6 }, 5));
    }

    @SolverTest
    void shouldHandleRepeatedAttackTimes(SolutionVariants.Solver s) {
        assertEquals(2, s.findPoisonedDuration(new int[] { 1, 1 }, 2));
    }
}
