package _66PlusOne;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlusOneTest {

	@Test
	void test1() {
		int[] digits = {1,2,3};
		int[] result = {1,2,4};
		
		assertArrayEquals(result, PlusOne.plusOne(digits));
	}
	@Test
	void test2() {
		int[] digits = {4,3,2,1};
		int[] result = {4,3,2,2};
		
		assertArrayEquals(result, PlusOne.plusOne(digits));
	}
	@Test
	void test3() {
		int[] digits = {9};
		int[] result = {1,0};
		
		assertArrayEquals(result, PlusOne.plusOne(digits));
	}
	
	@Test
	void test4() {
		int[] digits = {9,9};
		int[] result = {1,0,0};
		
		assertArrayEquals(result, PlusOne.plusOne(digits));
	}
	@Test
	void test5() {
		int[] digits = {8,9,9,9};
		int[] result = {9,0,0,0};
		
		assertArrayEquals(result, PlusOne.plusOne(digits));
	}
}
