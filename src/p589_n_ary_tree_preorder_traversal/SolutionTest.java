package p589_n_ary_tree_preorder_traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())));
    }

    @TestEachSolver
    void shouldReturnPreorderTraversal(SolutionVariants.Solver solver) {
        Node root = deserialize(1, null, 3, 2, 4, null, 5, 6);

        var output = solver.preorder(root);

        var expected = List.of(1, 3, 5, 6, 2, 4);

        assertEquals(expected, output);
    }

    @TestEachSolver
    void shouldReturnPreorderTraversalForComplexTree(SolutionVariants.Solver solver) {
        Node root = deserialize(
                1,
                null,
                2,
                3,
                4,
                5,
                null,
                null,
                6,
                7,
                null,
                8,
                null,
                9,
                10,
                null,
                null,
                11,
                null,
                12,
                null,
                13,
                null,
                null,
                14);

        var output = solver.preorder(root);

        var expected = List.of(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10);

        assertEquals(expected, output);
    }

    @TestEachSolver
    void shouldReturnEmptyListIfRootIsNull(SolutionVariants.Solver solver) {
        var output = solver.preorder(null);

        assertEquals(List.of(), output);
    }

    @TestEachSolver
    void shouldReturnRootValueForSingleNodeTree(SolutionVariants.Solver solver) {
        Node root = new Node(1, new ArrayList<>());

        var output = solver.preorder(root);

        assertEquals(List.of(1), output);
    }

    @TestEachSolver
    void shouldVisitChildrenFromLeftToRight(SolutionVariants.Solver solver) {
        Node root = new Node(1, new ArrayList<>());

        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(3, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));
        root.children.add(new Node(5, new ArrayList<>()));

        var output = solver.preorder(root);

        assertEquals(List.of(1, 2, 3, 4, 5), output);
    }

    @TestEachSolver
    void shouldVisitDeepTreeInPreorder(SolutionVariants.Solver solver) {
        Node root = deserialize(1, null, 2, null, 3, null, 4, null, 5);

        var output = solver.preorder(root);

        assertEquals(List.of(1, 2, 3, 4, 5), output);
    }

    @TestEachSolver
    void shouldVisitGrandchildrenBeforeFollowingSiblings(SolutionVariants.Solver solver) {
        Node root = deserialize(1, null, 2, 3, null, 4, 5, null, 6, null);

        var output = solver.preorder(root);

        assertEquals(List.of(1, 2, 4, 5, 3, 6), output);
    }

    @TestEachSolver
    void shouldHandleNodeWithoutChildren(SolutionVariants.Solver solver) {
        Node root = new Node(1, new ArrayList<>());

        var output = solver.preorder(root);

        assertEquals(List.of(1), output);
    }

    private Node deserialize(Integer... values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }

        Node root = new Node(values[0], new ArrayList<>());
        Queue<Node> parents = new ArrayDeque<>();
        parents.offer(root);

        // values[1] is the separator after the root.
        int index = 2;

        while (!parents.isEmpty() && index < values.length) {
            Node parent = parents.poll();

            // Read all children belonging to the current parent.
            while (index < values.length && values[index] != null) {
                Node child = new Node(values[index], new ArrayList<>());

                parent.children.add(child);
                parents.offer(child);
                index++;
            }

            // Skip the null ending this parent's child list.
            if (index < values.length) {
                index++;
            }
        }

        return root;
    }
}
