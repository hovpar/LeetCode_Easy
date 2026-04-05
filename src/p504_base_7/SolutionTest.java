package p504_base_7;

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
        return Stream.of(new SolutionVariants.ReverseStringBuilderSolver(),
                new SolutionVariants.PrependStringBuilderSolver(), new SolutionVariants.CharArraySolver(),
                new SolutionVariants.RecursiveSolver(), new SolutionVariants.UsingBuiltInFunctionSolver());
    }

    @SolverTest
    void shouldConvertPositiveNumber(SolutionVariants.Solver s) {
        assertEquals("202", s.convertToBase7(100));
    }

    @SolverTest
    void shouldConvertNegativeNumber(SolutionVariants.Solver s) {
        assertEquals("-10", s.convertToBase7(-7));
    }

    @SolverTest
    void shouldConvertZero(SolutionVariants.Solver s) {
        assertEquals("0", s.convertToBase7(0));
    }

    @SolverTest
    void shouldConvertPositiveSingleDigitNumber(SolutionVariants.Solver s) {
        assertEquals("6", s.convertToBase7(6));
    }

    @SolverTest
    void shouldConvertNegativeSingleDigitNumber(SolutionVariants.Solver s) {
        assertEquals("-6", s.convertToBase7(-6));
    }

    @SolverTest
    void shouldConvertExactPowerOfSeven(SolutionVariants.Solver s) {
        assertEquals("100", s.convertToBase7(49));
    }

    @SolverTest
    void shouldConvertNegativeExactPowerOfSeven(SolutionVariants.Solver s) {
        assertEquals("-100", s.convertToBase7(-49));
    }

    @SolverTest
    void shouldConvertNumberWithTrailingZeroInBase7(SolutionVariants.Solver s) {
        assertEquals("20", s.convertToBase7(14));
    }

    @SolverTest
    void shouldConvertLargerPositiveNumber(SolutionVariants.Solver s) {
        assertEquals("666", s.convertToBase7(342));
    }

    @SolverTest
    void shouldConvertLargerNegativeNumber(SolutionVariants.Solver s) {
        assertEquals("-666", s.convertToBase7(-342));
    }

    @SolverTest
    void shouldConvertNumberJustAbovePowerOfSeven(SolutionVariants.Solver s) {
        assertEquals("101", s.convertToBase7(50));
    }

    @SolverTest
    void shouldConvertNumberJustBelowPowerOfSeven(SolutionVariants.Solver s) {
        assertEquals("66", s.convertToBase7(48));
    }
}
