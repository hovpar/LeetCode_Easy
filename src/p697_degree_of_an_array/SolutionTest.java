package p697_degree_of_an_array;

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
                arguments(Named.of("three hashmap solver", new SolutionVariants.ThreeHashMapSolver())),
                arguments(Named.of("single hashmap solver", new SolutionVariants.SingleHashMapSolver())));
    }

    @TestEachSolver
    void shouldHandleSingleElement(SolutionVariants.Solver solver) {
        int[] nums = { 0 };
        assertEquals(1, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldHandleEmptyArrayIfSupported(SolutionVariants.Solver solver) {
        int[] nums = {};
        assertEquals(0, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldHandleAllElementsEqual(SolutionVariants.Solver solver) {
        int[] nums = { 5, 5, 5, 5, 5 };
        assertEquals(5, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldHandleAllDistinctElements(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 4, 5 };
        assertEquals(1, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldHandleRepeatedElementsAtBothEnds(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 1 };
        assertEquals(4, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldChooseShortestRangeWhenDegreesTie(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 2, 3, 4, 4 };
        assertEquals(2, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldHandleSeveralNumbersWithTheSameDegree(SolutionVariants.Solver solver) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4 };
        assertEquals(2, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldHandleDegreeOneAlongsideRepeatedNumbers(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 3, 4, 5 };
        assertEquals(2, solver.findShortestSubArray(nums));
    }

    @TestEachSolver
    void shouldHandleTheSameNumberInSeparatedGroups(SolutionVariants.Solver solver) {
        int[] nums = { 2, 1, 2, 3, 1, 2 };
        assertEquals(6, solver.findShortestSubArray(nums));
    }
}
