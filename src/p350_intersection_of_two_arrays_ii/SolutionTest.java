package p350_intersection_of_two_arrays_ii;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
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
                arguments(Named.of("three pointer solver", new SolutionVariants.ThreePointerSolver())),
                arguments(Named.of("hash map frequency solver", new SolutionVariants.HashMapFrequencySolver())));
    }

    // HashSet does not guarantee order.
    // assertArrayEquals may fail even for correct solutions.
    private void assertArrayEqualsIgnoreOrder(int[] expected, int[] actual) {
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @TestEachSolver
    void testIntersectionWithDuplicates_preservesMultiplicity(SolutionVariants.Solver solver) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] expected = { 2, 2 };
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testIntersectionWithMultipleMatchesAcrossArrays(SolutionVariants.Solver solver) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        int[] expected = { 4, 9 };
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testAllElementsIntersect_identicalArrays(SolutionVariants.Solver solver) {
        int[] nums1 = { 3, 1, 2, 2 };
        int[] nums2 = { 3, 1, 2, 2 };
        int[] expected = { 1, 2, 2, 3 };
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testSingleElementIntersection_match(SolutionVariants.Solver solver) {
        int[] nums1 = { 7 };
        int[] nums2 = { 7 };
        int[] expected = { 7 };
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testSingleElementIntersection_noMatch(SolutionVariants.Solver solver) {
        int[] nums1 = { 7 };
        int[] nums2 = { 8 };
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testIntersectionWithNegativesAndZero(SolutionVariants.Solver solver) {
        int[] nums1 = { -1, 0, 0, 2 };
        int[] nums2 = { 0, 0, 0, -1 };
        int[] expected = { -1, 0, 0 };
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testNoIntersection_disjointSets(SolutionVariants.Solver solver) {
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = { 2, 4, 6 };
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testEmptyFirstArray_returnsEmpty(SolutionVariants.Solver solver) {
        int[] nums1 = {};
        int[] nums2 = { 1, 2, 3 };
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }

    @TestEachSolver
    void testEmptySecondArray_returnsEmpty(SolutionVariants.Solver solver) {
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = {};
        int[] expected = {};
        assertArrayEqualsIgnoreOrder(expected, solver.intersect(nums1, nums2));
    }
}
