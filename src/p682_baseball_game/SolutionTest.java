package p682_baseball_game;

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
                arguments(Named.of("array list solver", new SolutionVariants.ArrayListSolver())),
                arguments(Named.of("stack solver", new SolutionVariants.StackSolver())));
    }

    @TestEachSolver
    void shouldCalculateOfficialExamples(SolutionVariants.Solver solver) {
        assertEquals(30, solver.calPoints(new String[] { "5", "2", "C", "D", "+" }));

        assertEquals(27, solver.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));

        assertEquals(0, solver.calPoints(new String[] { "1", "C" }));
    }

    @TestEachSolver
    void shouldHandleNegativeScores(SolutionVariants.Solver solver) {
        assertEquals(-5, solver.calPoints(new String[] { "-5" }));
        assertEquals(-15, solver.calPoints(new String[] { "-5", "D" }));
        assertEquals(-6, solver.calPoints(new String[] { "-5", "2", "+" }));
    }

    @TestEachSolver
    void shouldHandleIndividualOperations(SolutionVariants.Solver solver) {
        assertEquals(7, solver.calPoints(new String[] { "7" }));
        assertEquals(9, solver.calPoints(new String[] { "3", "D" }));
        assertEquals(14, solver.calPoints(new String[] { "3", "4", "+" }));
        assertEquals(3, solver.calPoints(new String[] { "3", "4", "C" }));
    }

    @TestEachSolver
    void shouldHandleRepeatedOperations(SolutionVariants.Solver solver) {
        assertEquals(15, solver.calPoints(new String[] { "1", "2", "D", "D" }));
        assertEquals(0, solver.calPoints(new String[] { "1", "2", "C", "C" }));
        assertEquals(11, solver.calPoints(new String[] { "1", "2", "+", "+" }));
    }

    @TestEachSolver
    void shouldHandleZeroScores(SolutionVariants.Solver solver) {
        assertEquals(0, solver.calPoints(new String[] { "0" }));
        assertEquals(0, solver.calPoints(new String[] { "0", "D" }));
        assertEquals(0, solver.calPoints(new String[] { "5", "5", "C", "C" }));
    }

    @TestEachSolver
    void shouldHandleMixedOperations(SolutionVariants.Solver solver) {
        assertEquals(0, solver.calPoints(new String[] { "5", "-5", "+" }));
        assertEquals(4, solver.calPoints(new String[] { "10", "-2", "D", "+", "C" }));
    }

}
