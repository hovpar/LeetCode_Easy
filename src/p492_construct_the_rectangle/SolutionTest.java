package p492_construct_the_rectangle;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnSameSidesForPerfectSquare() {
        assertArrayEquals(new int[] { 2, 2 }, s.constructRectangle(4));
    }

    @Test
    void shouldReturnOneAsWidthForPrimeNumber() {
        assertArrayEquals(new int[] { 37, 1 }, s.constructRectangle(37));
    }

    @Test
    void shouldReturnClosestFactorPairForLargeComposite() {
        assertArrayEquals(new int[] { 427, 286 }, s.constructRectangle(122122));
    }

    @Test
    void shouldHandleMinimumInput() {
        assertArrayEquals(new int[] { 1, 1 }, s.constructRectangle(1));
    }

    @Test
    void shouldHandleAnotherPerfectSquare() {
        assertArrayEquals(new int[] { 3, 3 }, s.constructRectangle(9));
    }

    @Test
    void shouldChooseClosestFactorsNotJustAnyFactors() {
        assertArrayEquals(new int[] { 4, 3 }, s.constructRectangle(12));
    }

    @Test
    void shouldReturnLargerSideFirst() {
        assertArrayEquals(new int[] { 3, 2 }, s.constructRectangle(6));
    }

    @Test
    void shouldHandleEvenNumberWithDifferentFactorPairs() {
        assertArrayEquals(new int[] { 6, 4 }, s.constructRectangle(24));
    }

    @Test
    void shouldHandleOddCompositeNumber() {
        assertArrayEquals(new int[] { 5, 3 }, s.constructRectangle(15));
    }

    @Test
    void shouldHandlePowerOfTwo() {
        assertArrayEquals(new int[] { 8, 4 }, s.constructRectangle(32));
    }

    @Test
    void shouldHandleLargePerfectSquare() {
        assertArrayEquals(new int[] { 100, 100 }, s.constructRectangle(10_000));
    }

    @Test
    void shouldHandlePrimeNearSquare() {
        assertArrayEquals(new int[] { 97, 1 }, s.constructRectangle(97));
    }
}
