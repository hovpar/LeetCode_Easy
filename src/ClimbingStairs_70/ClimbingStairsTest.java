package ClimbingStairs_70;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClimbingStairsTest {

	@Test
	void test() {
		assertEquals(1, ClimbingStairs.climbStairs(1));
	}

	@Test
	void test1() {
		assertEquals(3, ClimbingStairs.climbStairs(3));
	}
	
	@Test
	void test2() {
		assertEquals(2, ClimbingStairs.climbStairs(2));
	}
	
	@Test
	void test3() {
		assertEquals(5, ClimbingStairs.climbStairs(4));
	}
	@Test
	void test4() {
		assertEquals(8, ClimbingStairs.climbStairs(5));
	}

}
