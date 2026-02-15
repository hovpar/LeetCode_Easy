package p441_arranging_coins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returns60070ForLargeInputFromLeetCode() {
        assertEquals(60070, s.arrangeCoins(1_804_289_383));
    }

    @Test
    void returns2WhenNIs5() {
        assertEquals(2, s.arrangeCoins(5));
    }

    @Test
    void returns3WhenNIs8() {
        assertEquals(3, s.arrangeCoins(8));
    }

    // --- Edge cases & boundaries ---

    @Test
    void returns0WhenNIs0() {
        assertEquals(0, s.arrangeCoins(0));
    }

    @Test
    void returns1WhenNIs1() {
        assertEquals(1, s.arrangeCoins(1));
    }

    @Test
    void returns1WhenNIs2() {
        assertEquals(1, s.arrangeCoins(2));
    }

    @Test
    void returns2WhenNIs3ExactlyTwoFullRows() {
        assertEquals(2, s.arrangeCoins(3)); // 1 + 2
    }

    @Test
    void returns3WhenNIs6ExactlyThreeFullRows() {
        assertEquals(3, s.arrangeCoins(6)); // 1 + 2 + 3
    }

    // --- Off-by-one around triangular numbers T(k)=k(k+1)/2 ---

    @Test
    void returns3WhenNIs5JustBeforeT3() {
        assertEquals(2, s.arrangeCoins(5)); // T2=3, T3=6 -> still 2 rows
    }

    @Test
    void returns3WhenNIs7JustAfterT3() {
        assertEquals(3, s.arrangeCoins(7)); // T3=6, T4=10 -> 3 rows
    }

    @Test
    void returns4WhenNIs10ExactlyT4() {
        assertEquals(4, s.arrangeCoins(10));
    }

    @Test
    void returns4WhenNIs11JustAfterT4() {
        assertEquals(4, s.arrangeCoins(11));
    }

    // --- Large boundary / overflow-sensitive cases ---

    @Test
    void returns65535ForMaxInt() {
        // k=65535 -> T(k)=2,147,450,880
        // k=65536 -> T(k)=2,147,516,416 (exceeds Integer.MAX_VALUE)
        assertEquals(65535, s.arrangeCoins(Integer.MAX_VALUE));
    }

    @Test
    void returns65535ForLargestTriangularWithinIntRange() {
        assertEquals(65535, s.arrangeCoins(2_147_450_880));
    }

    @Test
    void returns65534ForOneLessThanLargestTriangularWithinIntRange() {
        assertEquals(65534, s.arrangeCoins(2_147_450_879));
    }

    // --- Additional representative cases ---

    @Test
    void returns4WhenNIs9() {
        assertEquals(3, s.arrangeCoins(9)); // T3=6, T4=10 -> 3 rows
    }

    @Test
    void returns5WhenNIs15ExactlyT5() {
        assertEquals(5, s.arrangeCoins(15));
    }
}
