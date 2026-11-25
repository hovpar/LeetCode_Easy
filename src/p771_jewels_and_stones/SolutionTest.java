package p771_jewels_and_stones;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
                arguments(Named.of("hashset solver", new SolutionVariants.HashSetSolver())),
                arguments(Named.of("boolean array solver", new SolutionVariants.BooleanArraySolver())));
    }

    @TestEachSolver
    void shouldHandleCaseSensitivity(SolutionVariants.Solver solver) {
        assertEquals(3, solver.numJewelsInStones("aA", "aAAbbbb"));
    }

    @TestEachSolver
    void shouldReturnZeroWhenNoStonesAreJewels(SolutionVariants.Solver solver) {
        assertEquals(0, solver.numJewelsInStones("z", "ZZ"));
    }

    @TestEachSolver
    void shouldReturnZeroWhenStonesAreEmpty(SolutionVariants.Solver solver) {
        assertEquals(0, solver.numJewelsInStones("aA", ""));
    }

    @TestEachSolver
    void shouldReturnZeroWhenJewelsAreEmpty(SolutionVariants.Solver solver) {
        assertEquals(0, solver.numJewelsInStones("", "aAAbbbb"));
    }

    @TestEachSolver
    void shouldCountAllStonesWhenAllAreJewels(SolutionVariants.Solver solver) {
        assertEquals(5, solver.numJewelsInStones("abc", "abcab"));
    }

    @TestEachSolver
    void shouldCountOnlyMatchingStones(SolutionVariants.Solver solver) {
        assertEquals(4, solver.numJewelsInStones("ab", "aabbcc"));
    }

    @TestEachSolver
    void shouldHandleSingleMatchingStone(SolutionVariants.Solver solver) {
        assertEquals(1, solver.numJewelsInStones("a", "a"));
    }

    @TestEachSolver
    void shouldReturnZeroWhenSingleStoneDoesNotMatch(SolutionVariants.Solver solver) {
        assertEquals(0, solver.numJewelsInStones("a", "b"));
    }

    @TestEachSolver
    void shouldNotCountDuplicateJewelsMoreThanOnce(SolutionVariants.Solver solver) {
        assertEquals(5, solver.numJewelsInStones("aab", "aaabb"));
    }

    @TestEachSolver
    void shouldDistinguishUppercaseAndLowercaseLetters(SolutionVariants.Solver solver) {
        assertEquals(2, solver.numJewelsInStones("aA", "AaBb"));
    }

    @TestEachSolver
    void shouldHandleOnlyUppercaseJewels(SolutionVariants.Solver solver) {
        assertEquals(3, solver.numJewelsInStones("ABC", "AaBbCc"));
    }

    @TestEachSolver
    void shouldHandleOnlyLowercaseJewels(SolutionVariants.Solver solver) {
        assertEquals(3, solver.numJewelsInStones("abc", "aAbBcC"));
    }

    @TestEachSolver
    void shouldHandleRepeatedStones(SolutionVariants.Solver solver) {
        assertEquals(4, solver.numJewelsInStones("a", "aaaabbbb"));
    }

    @TestEachSolver
    void shouldHandleMultipleJewelsAndNonJewels(SolutionVariants.Solver solver) {
        assertEquals(5, solver.numJewelsInStones("aBc", "aabbccABC"));
    }
}
