package p496_next_greater_element;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
        return Stream.of(new SolutionVariants.BruteForcesolver(), new SolutionVariants.RightToLeftStackSolver());
    }

    @SolverTest
    void shouldReturnExpectedValuesForExample1(SolutionVariants.Solver s) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] expected = { -1, 3, -1 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldReturnExpectedValuesForExample2(SolutionVariants.Solver s) {
        int[] nums1 = { 2, 4 };
        int[] nums2 = { 1, 2, 3, 4 };
        int[] expected = { 3, -1 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldHandleSingleElementPresentInBothArrays(SolutionVariants.Solver s) {
        int[] nums1 = { 1 };
        int[] nums2 = { 1 };
        int[] expected = { -1 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldReturnMinusOneWhenElementIsGreatestInNums2(SolutionVariants.Solver s) {
        int[] nums1 = { 5 };
        int[] nums2 = { 1, 2, 3, 4, 5 };
        int[] expected = { -1 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldFindNextGreaterWhenItIsImmediatelyToTheRight(SolutionVariants.Solver s) {
        int[] nums1 = { 2, 3 };
        int[] nums2 = { 1, 2, 3, 4 };
        int[] expected = { 3, 4 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldFindNextGreaterWhenItAppearsLaterNotImmediately(SolutionVariants.Solver s) {
        int[] nums1 = { 2, 1 };
        int[] nums2 = { 2, 1, 4, 3 };
        int[] expected = { 4, 4 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldReturnMinusOneForStrictlyDecreasingNums2(SolutionVariants.Solver s) {
        int[] nums1 = { 5, 3, 1 };
        int[] nums2 = { 5, 4, 3, 2, 1 };
        int[] expected = { -1, -1, -1 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldHandleNums1EqualToNums2(SolutionVariants.Solver s) {
        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { 1, 2, 3, 4 };
        int[] expected = { 2, 3, 4, -1 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldHandleNums1WithElementsInDifferentOrderThanNums2(SolutionVariants.Solver s) {
        int[] nums1 = { 4, 1, 3 };
        int[] nums2 = { 1, 2, 3, 4 };
        int[] expected = { -1, 2, 4 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldHandleNegativeNumbers(SolutionVariants.Solver s) {
        int[] nums1 = { -3, -1 };
        int[] nums2 = { -3, -2, -1, 0 };
        int[] expected = { -2, 0 };

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }

    @SolverTest
    void shouldHandleEmptyNums1(SolutionVariants.Solver s) {
        int[] nums1 = {};
        int[] nums2 = { 1, 2, 3 };
        int[] expected = {};

        assertArrayEquals(expected, s.nextGreaterElement(nums1, nums2));
    }
}
