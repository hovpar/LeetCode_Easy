package _169ExcelSheetColumnNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testSingleLetter() {
        assertEquals(1, solution.titleToNumber("A"));
    }

    @Test
    void testTwoLetters() {
        assertEquals(28, solution.titleToNumber("AB"));

    }

    @Test
    void testLargeNumber() {
        assertEquals(701, solution.titleToNumber("ZY"));
    }

    @Test
    void testLargestNumber() {

        assertEquals(2147483647, solution.titleToNumber("FXSHRXW"));

    }

}
