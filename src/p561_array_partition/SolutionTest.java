package p561_array_partition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
	
	private final Solution solution = new Solution();

	@Test
	void shouldHandleTwoElements() {
	    int[] array = {1, 2};

	    assertEquals(1, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleUnsortedInput() {
	    int[] array = {4, 1, 3, 2};

	    assertEquals(4, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleNegativeNumbers() {
	    int[] array = {-1, -2, -3, -4};

	    assertEquals(-6, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleMixedPositiveAndNegativeNumbers() {
	    int[] array = {-5, -2, 0, 3};

	    assertEquals(-5, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleDuplicateValues() {
	    int[] array = {5, 5, 5, 5};

	    assertEquals(10, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleZeros() {
	    int[] array = {0, 0, 0, 0};

	    assertEquals(0, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleMinimumAndMaximumConstraintValues() {
	    int[] array = {-10_000, 10_000};

	    assertEquals(-10_000, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleMultiplePairs() {
	    int[] array = {7, 3, 1, 9, 2, 8, 4, 6};

	    assertEquals(18, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleAlreadySortedInput() {
	    int[] array = {1, 2, 3, 4, 5, 6};

	    assertEquals(9, solution.arrayPairSum(array));
	}

	@Test
	void shouldHandleReverseSortedInput() {
	    int[] array = {6, 5, 4, 3, 2, 1};

	    assertEquals(9, solution.arrayPairSum(array));
	}
}
