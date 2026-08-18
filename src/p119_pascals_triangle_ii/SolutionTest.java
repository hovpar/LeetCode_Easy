package p119_pascals_triangle_ii;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		return Stream.of(arguments(Named.of("recursive solver", new SolutionVariants.RecursiveSolver())),
				arguments(Named.of("math formula solver", new SolutionVariants.MathFormulaSolver())));
	}

	@TestEachSolver
	void testFirstRow(SolutionVariants.Solver solver) {
		List<Integer> expected = List.of(1);
		assertEquals(expected, solver.getRow(0));

	}

	@TestEachSolver
	void testFirstTwoRow(SolutionVariants.Solver solver) {
		List<Integer> expected = List.of(1, 1);
		assertEquals(expected, solver.getRow(1));

	}

	@TestEachSolver
	void testThirdRow(SolutionVariants.Solver solver) {
		List<Integer> expected = List.of(1, 2, 1);
		assertEquals(expected, solver.getRow(2));

	}

	@TestEachSolver
	void testFourthRow(SolutionVariants.Solver solver) {
		List<Integer> expected = List.of(1, 4, 6, 4, 1);
		assertEquals(expected, solver.getRow(4));

	}
}
