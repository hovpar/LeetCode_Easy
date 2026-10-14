package p389_find_the_difference;

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
                arguments(Named.of("character sum diff solver", new SolutionVariants.CharacterSumDifferenceSolver())),
                arguments(Named.of("xor cancellation solver", new SolutionVariants.XorCancellationSolver())));
    }

    @TestEachSolver
    void testSIsEmpty(SolutionVariants.Solver solver) {
        assertEquals('y', solver.findTheDifference("", "y"));
    }

    @TestEachSolver
    void testExtraAtBeginning(SolutionVariants.Solver solver) {
        assertEquals('z', solver.findTheDifference("abcd", "zabcd"));
    }

    @TestEachSolver
    void testExtraInMiddle(SolutionVariants.Solver solver) {
        assertEquals('x', solver.findTheDifference("abcd", "abxcd"));
    }

    @TestEachSolver
    void testExtraAtEnd(SolutionVariants.Solver solver) {
        assertEquals('q', solver.findTheDifference("abcd", "abcdq"));
    }

    @TestEachSolver
    void testDuplicateLettersExtraIsDuplicate(SolutionVariants.Solver solver) {
        // s has two 'a' and one 'b'; t has an extra 'a'
        assertEquals('a', solver.findTheDifference("aab", "aaab"));
    }

    @TestEachSolver
    void testManyDuplicatesExtraDifferent(SolutionVariants.Solver solver) {
        assertEquals('c', solver.findTheDifference("aabb", "ababc"));
    }

    @TestEachSolver
    void testSingleCharS(SolutionVariants.Solver solver) {
        assertEquals('b', solver.findTheDifference("a", "ab"));
    }

    @TestEachSolver
    void testAllSameLetters(SolutionVariants.Solver solver) {
        assertEquals('a', solver.findTheDifference("bbbb", "bbbba"));
    }

    @TestEachSolver
    void testLargeInputStillWorks(SolutionVariants.Solver solver) {
        String s1 = "a".repeat(10_000) + "b".repeat(10_000);
        String t1 = s1 + "c";
        assertEquals('c', solver.findTheDifference(s1, t1));
    }

}
