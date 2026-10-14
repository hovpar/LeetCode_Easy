package p383_ransome_note;

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
                arguments(Named.of("hashmap solver", new SolutionVariants.HashMapSolver())),
                arguments(Named.of("array solver", new SolutionVariants.ArrayBasedSolver())));
    }

    @TestEachSolver
    void testCannotConstruct_basicMismatch(SolutionVariants.Solver solver) {
        assertFalse(solver.canConstruct("a", "b"));
        assertFalse(solver.canConstruct("aa", "ab")); // needs two 'a', only one available
    }

    @TestEachSolver
    void testCannotConstruct_lengthGuard(SolutionVariants.Solver solver) {
        assertFalse(solver.canConstruct("abc", "ab")); // ransom longer than magazine
    }

    @TestEachSolver
    void testCannotConstruct_insufficientCounts(SolutionVariants.Solver solver) {
        assertFalse(solver.canConstruct("aab", "abb")); // only one 'a'
        assertFalse(solver.canConstruct("zzz", "zz")); // missing one 'z'
    }

    @TestEachSolver
    void testCanConstruct_basic(SolutionVariants.Solver solver) {
        assertTrue(solver.canConstruct("aa", "aab"));
        assertTrue(solver.canConstruct("abc", "cba")); // exact counts, different order
        assertTrue(solver.canConstruct("aab", "aba")); // still only 2 a's? (clarity: use direct)
    }

    @TestEachSolver
    void testCanConstruct_withExtraCharactersInMagazine(SolutionVariants.Solver solver) {
        assertTrue(solver.canConstruct("a", "aaaaa"));
        assertTrue(solver.canConstruct("abc", "abcccccdddd"));
    }

    @TestEachSolver
    void testEmptyRansomNote_alwaysTrue(SolutionVariants.Solver solver) {
        assertTrue(solver.canConstruct("", ""));
        assertTrue(solver.canConstruct("", "anything"));
    }

    @TestEachSolver
    void testEmptyMagazine_nonEmptyRansomFalse(SolutionVariants.Solver solver) {
        assertFalse(solver.canConstruct("a", ""));
        assertFalse(solver.canConstruct("xyz", ""));
    }

    @TestEachSolver
    void testUsesCharactersCorrectly_noReuseBeyondCounts(SolutionVariants.Solver solver) {
        // magazine has only one 'a' and one 'b'
        assertTrue(solver.canConstruct("ab", "ab"));
        assertFalse(solver.canConstruct("aba", "ab")); // would require reusing 'a'
    }

}