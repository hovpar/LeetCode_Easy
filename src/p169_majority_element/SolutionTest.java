package p169_majority_element;

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
                arguments(Named.of("moore voting solver", new SolutionVariants.MooreVotingSolver())),
                arguments(Named.of("sorting solver", new SolutionVariants.SortingSolver())));
    }

    @TestEachSolver
    void testWhenArrayHasTwoMajorityCandidates(SolutionVariants.Solver solver) {
        int[] nums = { 3, 2, 3 };
        assertEquals(3, solver.majorityElement(nums));
    }

    @TestEachSolver
    void testWhenMajorityIsAtEnd(SolutionVariants.Solver solver) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        assertEquals(2, solver.majorityElement(nums));
    }

    @TestEachSolver
    void testWithSingleElementArray(SolutionVariants.Solver solver) {
        int[] nums = { 1 };
        assertEquals(1, solver.majorityElement(nums));
    }

    @TestEachSolver
    void testWithAllElementsSame(SolutionVariants.Solver solver) {
        int[] nums = { 7, 7, 7, 7, 7 };
        assertEquals(7, solver.majorityElement(nums));
    }

    @TestEachSolver
    void testWhenMajorityAppearsJustOverHalf(SolutionVariants.Solver solver) {
        int[] nums = { 5, 5, 5, 2, 2 };
        assertEquals(5, solver.majorityElement(nums));
    }

    @TestEachSolver
    void testWhenArrayIsLargeAndMajorityInMiddle(SolutionVariants.Solver solver) {
        int[] nums = { 4, 1, 4, 2, 4, 3, 4, 4, 4 };
        assertEquals(4, solver.majorityElement(nums));
    }

}