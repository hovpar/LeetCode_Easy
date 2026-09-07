package p599_minimum_index_sum_of_two_lists;

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
                arguments(Named.of("nested loops solver", new SolutionVariants.NestedLoopSolver())),
                arguments(Named.of("hashmap solver", new SolutionVariants.HashMapSolver())));
    }

    @TestEachSolver
    void returnsRestaurantWithLowestIndexSum(SolutionVariants.Solver solver) {
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
        String[] expected = { "Shogun" };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }

    @TestEachSolver
    void returnsRestaurantWithLowestIndexSumWhenMultipleRestaurantsMatch(SolutionVariants.Solver solver) {
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "KFC", "Shogun", "Burger King" };
        String[] expected = { "Shogun" };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }

    @TestEachSolver
    void returnsAllRestaurantsWhenTheyShareTheLowestIndexSum(SolutionVariants.Solver solver) {
        String[] list1 = { "happy", "sad", "good" };
        String[] list2 = { "sad", "happy", "good" };
        String[] expected = { "happy", "sad" };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }

    @TestEachSolver
    void returnsSingleRestaurantWhenBothListsContainOnlyThatRestaurant(SolutionVariants.Solver solver) {
        String[] list1 = { "sad" };
        String[] list2 = { "sad" };
        String[] expected = { "sad" };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }

    @TestEachSolver
    void correctlyHandlesRestaurantNamesContainingSpaces(SolutionVariants.Solver solver) {
        String[] list1 = { " " };
        String[] list2 = { " " };
        String[] expected = { " " };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }

    @TestEachSolver
    void doesNotReturnDuplicateRestaurantWhenItHasTheLowestIndexSum(SolutionVariants.Solver solver) {
        String[] list1 = { "Shogun", "KFC" };
        String[] list2 = { "KFC", "Shogun" };
        String[] expected = { "Shogun", "KFC" };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }

    @TestEachSolver
    void ignoresRestaurantsWithHigherIndexSum(SolutionVariants.Solver solver) {
        String[] list1 = { "Shogun", "KFC" };
        String[] list2 = { "Shogun", "KFC" };
        String[] expected = { "Shogun" };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }

    @TestEachSolver
    void returnsMultipleRestaurantsWithTheSameMinimumIndexSum(SolutionVariants.Solver solver) {
        String[] list1 = { "a", "b", "c" };
        String[] list2 = { "b", "a", "c" };
        String[] expected = { "a", "b" };
        assertArrayEquals(expected, solver.findRestaurant(list1, list2));
    }
}
