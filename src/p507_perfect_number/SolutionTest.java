package p507_perfect_number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        return Stream.of(new SolutionVariants.SqrtDivisorSumSolver(),
                new SolutionVariants.PrecomputedPerfectNumberSolver());
    }

    @SolverTest
    void edgeCases(SolutionVariants.Solver s) {
        assertFalse(s.checkPerfectNumber(0));   // not valid
        assertFalse(s.checkPerfectNumber(1));   // smallest non-perfect
        assertFalse(s.checkPerfectNumber(2));
    }

    @SolverTest
    void smallNonPerfectNumbers(SolutionVariants.Solver s) {
        assertFalse(s.checkPerfectNumber(3));
        assertFalse(s.checkPerfectNumber(4));
        assertFalse(s.checkPerfectNumber(5));
        assertFalse(s.checkPerfectNumber(7));
        assertFalse(s.checkPerfectNumber(10));
    }

    @SolverTest
    void knownPerfectNumbers(SolutionVariants.Solver s) {
        assertTrue(s.checkPerfectNumber(6));
        assertTrue(s.checkPerfectNumber(28));
        assertTrue(s.checkPerfectNumber(496));
        assertTrue(s.checkPerfectNumber(8128));
    }

    @SolverTest
    void neighborsOfPerfectNumbers(SolutionVariants.Solver s) {
        assertFalse(s.checkPerfectNumber(5));
        assertFalse(s.checkPerfectNumber(7));

        assertFalse(s.checkPerfectNumber(27));
        assertFalse(s.checkPerfectNumber(29));

        assertFalse(s.checkPerfectNumber(495));
        assertFalse(s.checkPerfectNumber(497));
    }

    @SolverTest
    void largerNonPerfectNumbers(SolutionVariants.Solver s) {
        assertFalse(s.checkPerfectNumber(100));
        assertFalse(s.checkPerfectNumber(9999));
        assertFalse(s.checkPerfectNumber(33550335)); // just below known large perfect
    }

}
