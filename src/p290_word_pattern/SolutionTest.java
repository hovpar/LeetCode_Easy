package p290_word_pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("solvers")
    @interface TestEachSolver {
    }

    static Stream<Arguments> solvers() {
        return Stream.of(
                arguments(Named.of("single map solver", new SolutionVariants.SingleMapSolver())),
                arguments(Named.of("bidirectional map solver", new SolutionVariants.BidirectionalMapSolver())));
    }

    @TestEachSolver
    void testValidPattern(SolutionVariants.Solver solver) {
        assertTrue(solver.wordPattern("abba", "dog cat cat dog"));
    }

    @TestEachSolver
    void testInvalidPatternMapping(SolutionVariants.Solver solver) {
        assertFalse(solver.wordPattern("abba", "dog cat cat fish"));
    }

    @TestEachSolver
    void testInvalidWordReuse(SolutionVariants.Solver solver) {
        assertFalse(solver.wordPattern("aaaa", "dog cat cat dog"));
    }

    @TestEachSolver
    void testSingleCharacter(SolutionVariants.Solver solver) {
        assertTrue(solver.wordPattern("a", "dog"));
    }

    @TestEachSolver
    void testLengthMismatch(SolutionVariants.Solver solver) {
        assertFalse(solver.wordPattern("ab", "dog"));
    }

    @TestEachSolver
    void testSameWordsDifferentPattern(SolutionVariants.Solver solver) {
        assertFalse(solver.wordPattern("ab", "dog dog"));
    }

    @TestEachSolver
    void testDifferentWordsSamePattern(SolutionVariants.Solver solver) {
        assertTrue(solver.wordPattern("ab", "dog cat"));
    }

    @TestEachSolver
    void testEmptyStrings(SolutionVariants.Solver solver) {
        assertTrue(solver.wordPattern("", ""));
    }

}
