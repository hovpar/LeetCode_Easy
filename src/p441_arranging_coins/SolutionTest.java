package p441_arranging_coins;

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
        return Stream.of(new SolutionVariants.IterativeSolver(), new SolutionVariants.BinarySearchSolver(),
                new SolutionVariants.QuadraticFormulaSolver());
    }

    @SolverTest
    void returns60070ForLargeInputFromLeetCode(SolutionVariants.Solver s) {
        assertEquals(60070, s.arrangeCoins(1_804_289_383));
    }

    @SolverTest
    void returns2WhenNIs5(SolutionVariants.Solver s) {
        assertEquals(2, s.arrangeCoins(5));
    }

    @SolverTest
    void returns3WhenNIs8(SolutionVariants.Solver s) {
        assertEquals(3, s.arrangeCoins(8));
    }

    // --- Edge cases & boundaries ---

    @SolverTest
    void returns0WhenNIs0(SolutionVariants.Solver s) {
        assertEquals(0, s.arrangeCoins(0));
    }

    @SolverTest
    void returns1WhenNIs1(SolutionVariants.Solver s) {
        assertEquals(1, s.arrangeCoins(1));
    }

    @SolverTest
    void returns1WhenNIs2(SolutionVariants.Solver s) {
        assertEquals(1, s.arrangeCoins(2));
    }

    @SolverTest
    void returns2WhenNIs3ExactlyTwoFullRows(SolutionVariants.Solver s) {
        assertEquals(2, s.arrangeCoins(3)); // 1 + 2
    }

    @SolverTest
    void returns3WhenNIs6ExactlyThreeFullRows(SolutionVariants.Solver s) {
        assertEquals(3, s.arrangeCoins(6)); // 1 + 2 + 3
    }

    // --- Off-by-one around triangular numbers T(k)=k(k+1)/2 ---

    @SolverTest
    void returns3WhenNIs5JustBeforeT3(SolutionVariants.Solver s) {
        assertEquals(2, s.arrangeCoins(5)); // T2=3, T3=6 -> still 2 rows
    }

    @SolverTest
    void returns3WhenNIs7JustAfterT3(SolutionVariants.Solver s) {
        assertEquals(3, s.arrangeCoins(7)); // T3=6, T4=10 -> 3 rows
    }

    @SolverTest
    void returns4WhenNIs10ExactlyT4(SolutionVariants.Solver s) {
        assertEquals(4, s.arrangeCoins(10));
    }

    @SolverTest
    void returns4WhenNIs11JustAfterT4(SolutionVariants.Solver s) {
        assertEquals(4, s.arrangeCoins(11));
    }

    // --- Large boundary / overflow-sensitive cases ---

    @SolverTest
    void returns65535ForMaxInt(SolutionVariants.Solver s) {
        // k=65535 -> T(k)=2,147,450,880
        // k=65536 -> T(k)=2,147,516,416 (exceeds Integer.MAX_VALUE)
        assertEquals(65535, s.arrangeCoins(Integer.MAX_VALUE));
    }

    @SolverTest
    void returns65535ForLargestTriangularWithinIntRange(SolutionVariants.Solver s) {
        assertEquals(65535, s.arrangeCoins(2_147_450_880));
    }

    @SolverTest
    void returns65534ForOneLessThanLargestTriangularWithinIntRange(SolutionVariants.Solver s) {
        assertEquals(65534, s.arrangeCoins(2_147_450_879));
    }

    // --- Additional representative cases ---
    @SolverTest
    void returns4WhenNIs9(SolutionVariants.Solver s) {
        assertEquals(3, s.arrangeCoins(9)); // T3=6, T4=10 -> 3 rows
    }

    @SolverTest
    void returns5WhenNIs15ExactlyT5(SolutionVariants.Solver s) {
        assertEquals(5, s.arrangeCoins(15));
    }
}
