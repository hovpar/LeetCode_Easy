package p204_count_primes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testTwo() {
        assertEquals(0, solution.countPrimes(2)); // no primes < 2
    }

    @Test
    void testThree() {
        assertEquals(1, solution.countPrimes(3)); // primes: [2]
    }

    @Test
    void testSmallNumbers() {
        assertEquals(2, solution.countPrimes(5)); // primes: [2,3]
        assertEquals(3, solution.countPrimes(7)); // primes: [2,3,5]
        assertEquals(4, solution.countPrimes(10)); // primes: [2,3,5,7]
    }

    @Test
    void testPrimeBoundary() {
        assertEquals(25, solution.countPrimes(100)); // primes < 100
    }

    @Test
    void testLargerInput() {
        assertEquals(168, solution.countPrimes(1000)); // primes < 1000
    }

    @Test
    void testVeryLargeInput() {
        assertEquals(78498, solution.countPrimes(1_000_000)); // primes < 1 million
    }

    @Test
    void testConsecutiveInputs() {
        assertEquals(25, solution.countPrimes(100));
        assertEquals(25, solution.countPrimes(101)); // 101 is prime, but <101 = 25
    }

    @Test
    void testNegative() {
        assertEquals(0, solution.countPrimes(-5)); // negative numbers have no primes
    }

}
