package _1TwoSum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoSumTest {

	TwoSum twoSum = new TwoSum();

	@Test
	void testSimpleCase() {
		int[] array = { 2, 7, 11, 15 };
		int[] expected = { 0, 1 };
		assertArrayEquals(expected, twoSum.twoSum(array, 9));
	}

	@Test
	void testMultipleSolutions() {
		int[] array = { 3, 2, 4 };
		int[] expected = { 1, 2 };
		assertArrayEquals(expected, twoSum.twoSum(array, 6));
	}

	@Test
	void testSameElementTwice() {
		int[] array = { 3, 3 };
		int[] expected = { 0, 1 };
		assertArrayEquals(expected, twoSum.twoSum(array, 6));
	}

	@Test
	void testFirstAndLastElement() {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] expected = { 0, 3 };
		assertArrayEquals(expected, twoSum.twoSum(array, 5));
	}

	@Test
	void testWithNegativeNumbers() {
		int[] array = { -3, 4, 3, 90 };
		int[] expected = { 0, 2 };
		assertArrayEquals(expected, twoSum.twoSum(array, 0));
	}

	@Test
	void testMixedPositiveAndNegative() {
		int[] array = { 1, -1, 2, -2, 3, -3 };
		int[] expected = { 1, 2 };
		assertArrayEquals(expected, twoSum.twoSum(array, 1));
	}

	@Test
	void testDuplicateElements() {
		int[] array = { 5, 5, 10 };
		int[] expected = { 0, 1 };
		assertArrayEquals(expected, twoSum.twoSum(array, 10));
	}
	
	@Test
	void testNoSolution() {
		int[] array = { 1, 2, 3 };
		int[] expected = {};
		assertArrayEquals(expected, twoSum.twoSum(array, 10));
	}

}
