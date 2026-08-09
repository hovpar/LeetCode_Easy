package p027_remove_element;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
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
        return Stream.of(new SolutionVariants.StableCompactionSolution(), new SolutionVariants.SwapWithEndSolution());
    }

    @SolverTest
    void handlesEmptyArray(SolutionVariants.Solver s) {
        int[] nums = {};

        int k = s.removeElement(nums, 1);

        assertEquals(0, k);
    }

    @SolverTest
    void removesMatchingElements(SolutionVariants.Solver s) {
        int[] nums = { 3, 2, 2, 3 };

        int k = s.removeElement(nums, 3);

        assertEquals(2, k);
        assertArrayEquals(new int[] { 2, 2 }, Arrays.copyOf(nums, k));
    }

    //    @SolverTest
    //    void removesMatchingElementsAndPreservesOrder(SolutionVariants.Solver s) {
    //        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
    //
    //        int k = s.removeElement(nums, 2);
    //
    //        assertEquals(5, k);
    //        assertArrayEquals(new int[] { 0, 1, 3, 0, 4 }, Arrays.copyOf(nums, k));
    //    }

    @SolverTest
    void removesElementsWithoutRequiringOrder(SolutionVariants.Solver s) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };

        int k = s.removeElement(nums, 2);

        assertEquals(5, k);

        int[] actual = Arrays.copyOf(nums, k);
        Arrays.sort(actual);

        int[] expected = { 0, 0, 1, 3, 4 };
        assertArrayEquals(expected, actual);
    }

    @SolverTest
    void handlesArrayContainingOnlyTarget(SolutionVariants.Solver s) {
        int[] nums = { 2, 2, 2 };

        int k = s.removeElement(nums, 2);

        assertEquals(0, k);
    }

    @SolverTest
    void handlesArrayWithoutTarget(SolutionVariants.Solver s) {
        int[] nums = { 1, 2, 3 };

        int k = s.removeElement(nums, 4);

        assertEquals(3, k);
        assertArrayEquals(new int[] { 1, 2, 3 }, Arrays.copyOf(nums, k));
    }
}
