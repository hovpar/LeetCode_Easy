package p744_find_smallest_letter_greater_than_target;

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
                arguments(Named.of("linear solver", new SolutionVariants.LinearSolver())),
                arguments(Named.of("binary search solver", new SolutionVariants.BinarySearchSolver())));
    }

    @TestEachSolver
    void shouldReturnFirstLetterWhenTargetIsSmallerThanAllLetters(SolutionVariants.Solver solver) {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('c', solver.nextGreatestLetter(letters, 'a'));
    }

    @TestEachSolver
    void shouldReturnNextLetterWhenTargetExists(SolutionVariants.Solver solver) {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('f', solver.nextGreatestLetter(letters, 'c'));
    }

    @TestEachSolver
    void shouldWrapAroundWhenTargetIsGreaterThanAllLetters(SolutionVariants.Solver solver) {
        char[] letters = { 'x', 'x', 'y', 'y' };

        assertEquals('x', solver.nextGreatestLetter(letters, 'z'));
    }

    @TestEachSolver
    void shouldReturnNextLetterWhenTargetIsBetweenLetters(SolutionVariants.Solver solver) {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('j', solver.nextGreatestLetter(letters, 'g'));
    }

    @TestEachSolver
    void shouldWrapAroundWhenTargetEqualsLastLetter(SolutionVariants.Solver solver) {
        char[] letters = { 'c', 'f', 'j' };

        assertEquals('c', solver.nextGreatestLetter(letters, 'j'));
    }

    @TestEachSolver
    void shouldHandleDuplicateLetters(SolutionVariants.Solver solver) {
        char[] letters = { 'c', 'f', 'f', 'f', 'j' };

        assertEquals('j', solver.nextGreatestLetter(letters, 'f'));
    }

    @TestEachSolver
    void shouldReturnFirstGreaterLetterAmongDuplicates(SolutionVariants.Solver solver) {
        char[] letters = { 'c', 'c', 'f', 'f', 'j' };

        assertEquals('f', solver.nextGreatestLetter(letters, 'c'));
    }

    @TestEachSolver
    void shouldHandleSingleElementArray(SolutionVariants.Solver solver) {
        char[] letters = { 'a' };

        assertEquals('a', solver.nextGreatestLetter(letters, 'a'));
    }

    @TestEachSolver
    void shouldHandleSingleElementArrayWithSmallerTarget(SolutionVariants.Solver solver) {
        char[] letters = { 'a' };

        assertEquals('a', solver.nextGreatestLetter(letters, '`'));
    }

    @TestEachSolver
    void shouldHandleBoundaryCharacters(SolutionVariants.Solver solver) {
        char[] letters = { 'a', 'z' };

        assertEquals('z', solver.nextGreatestLetter(letters, 'a'));
        assertEquals('a', solver.nextGreatestLetter(letters, 'z'));
    }

}
