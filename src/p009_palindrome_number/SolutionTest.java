package p009_palindrome_number;

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
        return Stream.of(new SolutionVariants.TwoPointerDigitComparisonSolver(),
                new SolutionVariants.ReverseIntegerSolver(), new SolutionVariants.HalfReverseSolver());
    }

    @SolverTest
    void testPositivePalindrome(SolutionVariants.Solver s) {
        assertTrue(s.isPalindrome(1221));
    }

    @SolverTest
    void testSingleDigit(SolutionVariants.Solver s) {
        assertTrue(s.isPalindrome(7));
    }

    @SolverTest
    void testNonPalindrome(SolutionVariants.Solver s) {
        assertFalse(s.isPalindrome(123));
    }

    @SolverTest
    void testZero(SolutionVariants.Solver s) {
        assertTrue(s.isPalindrome(0));
    }

    @SolverTest
    void testLargePalindrome(SolutionVariants.Solver s) {
        assertTrue(s.isPalindrome(123454321));
    }

    @SolverTest
    void testNumberEndingWithZero(SolutionVariants.Solver s) {
        assertFalse(s.isPalindrome(120));
    }

}
