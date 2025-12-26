package p303_range_sum_query_immutable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumArrayTest {

    @Test
    void testExampleFromProblemStatement() {
        NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });

        assertEquals(1, numArray.sumRange(0, 2));   // -2 + 0 + 3
        assertEquals(-1, numArray.sumRange(2, 5));  // 3 - 5 + 2 - 1
        assertEquals(-3, numArray.sumRange(0, 5));  // full range
    }

    @Test
    void testSingleElementArray() {
        NumArray numArray = new NumArray(new int[] { 5 });

        assertEquals(5, numArray.sumRange(0, 0));
    }

    @Test
    void testAllPositiveNumbers() {
        NumArray numArray = new NumArray(new int[] { 1, 2, 3, 4, 5 });

        assertEquals(6, numArray.sumRange(0, 2));   // 1 + 2 + 3
        assertEquals(9, numArray.sumRange(1, 3));   // 2 + 3 + 4
        assertEquals(15, numArray.sumRange(0, 4));  // full range
    }

    @Test
    void testAllNegativeNumbers() {
        NumArray numArray = new NumArray(new int[] { -1, -2, -3, -4 });

        assertEquals(-6, numArray.sumRange(0, 2));
        assertEquals(-9, numArray.sumRange(1, 3));
    }

    @Test
    void testZerosOnly() {
        NumArray numArray = new NumArray(new int[] { 0, 0, 0, 0 });

        assertEquals(0, numArray.sumRange(0, 3));
        assertEquals(0, numArray.sumRange(1, 2));
    }

    @Test
    void testLeftEqualsRight() {
        NumArray numArray = new NumArray(new int[] { 4, -1, 7 });

        assertEquals(4, numArray.sumRange(0, 0));
        assertEquals(-1, numArray.sumRange(1, 1));
        assertEquals(7, numArray.sumRange(2, 2));
    }
}
