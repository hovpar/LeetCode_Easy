package p566_reshape_the_matrix;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
                arguments(Named.of("flatten then reshape solver", new SolutionVariants.FlattenThenReshapeSolver())),
                arguments(Named.of("direct index mapping solver", new SolutionVariants.DirectIndexMappingSolver())));
    }

    @TestEachSolver
    void reshapeTwoByTwoToOneByFour(SolutionVariants.Solver solver) {
        int[][] mat = { { 1, 2 }, { 3, 4 } };

        int[][] expected = { { 1, 2, 3, 4 } };

        int[][] actual = solver.matrixReshape(mat, 1, 4);

        assertArrayEquals(expected, actual);
    }

    @TestEachSolver
    void reshapeOneByFourToTwoByTwo(SolutionVariants.Solver solver) {
        int[][] mat = { { 1, 2, 3, 4 } };

        int[][] expected = { { 1, 2 }, { 3, 4 } };

        assertArrayEquals(expected, solver.matrixReshape(mat, 2, 2));
    }

    @TestEachSolver
    void reshapeTwoByThreeToThreeByTwo(SolutionVariants.Solver solver) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 } };

        int[][] expected = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

        assertArrayEquals(expected, solver.matrixReshape(mat, 3, 2));
    }

    @TestEachSolver
    void keepOriginalMatrixWhenReshapeIsImpossible(SolutionVariants.Solver solver) {
        int[][] mat = { { 1, 2 }, { 3, 4 } };

        int[][] actual = solver.matrixReshape(mat, 2, 4);
        //the exact original matrix object is returned, 
        //not merely another matrix containing the same values
        assertSame(mat, actual);
    }

    @TestEachSolver
    void keepSameShape(SolutionVariants.Solver solver) {
        int[][] mat = { { 1, 2 }, { 3, 4 } };

        int[][] expected = { { 1, 2 }, { 3, 4 } };

        assertArrayEquals(expected, solver.matrixReshape(mat, 2, 2));
    }

    @TestEachSolver
    void reshapeSingleElementMatrix(SolutionVariants.Solver solver) {
        int[][] mat = { { 42 } };
        int[][] expected = { { 42 } };

        assertArrayEquals(expected, solver.matrixReshape(mat, 1, 1));
    }
}
