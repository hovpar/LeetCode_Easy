package p459_repeated_substring_pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest
    @MethodSource("solvers")
    @interface SolverTest {
    }

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.DivisorRepeatSolver(), new SolutionVariants.ConcatenationTrickSolver());
    }

    @Nested
    class TrueCases {

        static Stream<Arguments> trueCases() {
            return SolutionTest.solvers()
                    .flatMap(solver -> Stream
                            .of("abab", "ababab", "abcabcabcabc", "aaaa", "zzzzzz", "xyzxyz", "abaaba", "abcaabca")
                            .map(input -> Arguments.of(solver, input)));
        }

        @ParameterizedTest(name = "{0} -> \"{1}\"")
        @MethodSource("trueCases")
        void shouldReturnTrue(SolutionVariants.Solver solver, String input) {
            assertTrue(solver.repeatedSubstringPattern(input));
        }
    }

    @Nested
    class FalseCases {

        static Stream<Arguments> falseCases() {
            return SolutionTest.solvers()
                    .flatMap(solver -> Stream
                            .of("aba", "a", "ab", "abcd", "ababa", "abaabb", "abcab", "aaaaab", "abababa")
                            .map(input -> Arguments.of(solver, input)));
        }

        @ParameterizedTest(name = "{0} -> \"{1}\"")
        @MethodSource("falseCases")
        void shouldReturnFalse(SolutionVariants.Solver solver, String input) {
            assertFalse(solver.repeatedSubstringPattern(input));
        }
    }

    @SolverTest
    void shouldReturnFalse_forSingleCharacter(SolutionVariants.Solver solver) {
        assertFalse(solver.repeatedSubstringPattern("x"));
    }

    @SolverTest
    void shouldReturnTrue_forAllSameCharacter(SolutionVariants.Solver solver) {
        assertTrue(solver.repeatedSubstringPattern("bbbbbbbb"));
    }

    @SolverTest
    void shouldReturnFalse_forPrimeLengthNonUniformString(SolutionVariants.Solver solver) {
        assertFalse(solver.repeatedSubstringPattern("abcdefg"));
    }

    @SolverTest
    void shouldReturnTrue_whenPatternLengthIsMoreThanOne(SolutionVariants.Solver solver) {
        assertTrue(solver.repeatedSubstringPattern("abcdabcdabcd"));
    }
}