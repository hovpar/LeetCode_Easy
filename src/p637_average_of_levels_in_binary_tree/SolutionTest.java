package p637_average_of_levels_in_binary_tree;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
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
                arguments(Named.of("recursive solver", new SolutionVariants.RecursiveSolver())),
                arguments(Named.of("queue solver", new SolutionVariants.QueueSolver())));
    }

    @TestEachSolver
    void shouldCalculateAverageForBalancedTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        var expected = List.of(3.0, 14.5, 11.0);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldCalculateAverageForUnbalancedTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(3, new TreeNode(9, new TreeNode(15), new TreeNode(7)), new TreeNode(20));

        var expected = List.of(3.0, 14.5, 11.0);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldHandleSingleNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(42);

        var expected = List.of(42.0);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldHandleNegativeValues(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(-10, new TreeNode(-20), new TreeNode(-30));

        var expected = List.of(-10.0, -25.0);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldHandleZeros(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(0, new TreeNode(0), new TreeNode(0));

        var expected = List.of(0.0, 0.0);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldHandleIntegerOverflowWhenCalculatingLevelSum(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(Integer.MAX_VALUE, new TreeNode(Integer.MAX_VALUE),
                new TreeNode(Integer.MAX_VALUE));

        var expected = List.of((double) Integer.MAX_VALUE, (double) Integer.MAX_VALUE);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldHandleIntegerMinValue(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE, new TreeNode(Integer.MIN_VALUE),
                new TreeNode(Integer.MIN_VALUE));

        var expected = List.of((double) Integer.MIN_VALUE, (double) Integer.MIN_VALUE);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldHandleMixedExtremeIntegerValues(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(0, new TreeNode(Integer.MAX_VALUE), new TreeNode(Integer.MIN_VALUE));

        var expected = List.of(0.0, -0.5);

        assertEquals(expected, solver.averageOfLevels(root));
    }

    @TestEachSolver
    void shouldHandleMultipleLevels(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        var expected = List.of(1.0, 2.5, 5.5);

        assertEquals(expected, solver.averageOfLevels(root));
    }

}
