package SqrtX_69;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SqrtXTest {
	
	@Test
	void testZero() {
		assertEquals(0, SqrtX.mySqrt(0));
	}
    @Test
    void testLargeNumber() {
        assertEquals(46340, SqrtX.mySqrt(2147483647));    
    }

    @Test
    void testPerfectSquare() {
        assertEquals(10, SqrtX.mySqrt(100)); // Perfect square test
    }

    @Test
    void testSmallNumber() {
        assertEquals(1, SqrtX.mySqrt(1)); // Smallest non-zero input
    }

    @Test
    void testNonPerfectSquare() {
        assertEquals(3, SqrtX.mySqrt(15)); // Non-perfect square number
    }

    @Test
    void testJustBelowPerfectSquare() {
        assertEquals(9, SqrtX.mySqrt(99)); 
    }

}
