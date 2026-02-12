package p415_add_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void addsWhenFirstIsShorter() {
        assertEquals("134", s.addStrings("11", "123"));
    }

    @Test
    void addsWhenSecondIsShorter() {
        assertEquals("533", s.addStrings("456", "77"));
    }

    @Test
    void addsTwoZeros() {
        assertEquals("0", s.addStrings("0", "0"));
    }

    @Test
    void addsZeroToNumber() {
        assertEquals("999", s.addStrings("999", "0"));
        assertEquals("999", s.addStrings("0", "999"));
    }

    @Test
    void handlesSingleDigitWithoutCarry() {
        assertEquals("7", s.addStrings("3", "4"));
    }

    @Test
    void handlesSingleDigitWithCarry() {
        assertEquals("10", s.addStrings("9", "1"));
    }

    @Test
    void propagatesCarryAcrossAllDigits() {
        assertEquals("1000", s.addStrings("999", "1"));
    }

    @Test
    void handlesDifferentLengthsWithMultipleCarries() {
        assertEquals("1107", s.addStrings("789", "318"));
        assertEquals("10000", s.addStrings("1", "9999"));
    }

    @Test
    void handlesVeryLargeNumbersBeyondLongRange() {
        assertEquals("111111111111111111111111111111111111111111111111110",
                s.addStrings("99999999999999999999999999999999999999999999999999",
                        "11111111111111111111111111111111111111111111111111"));
    }

    @Test
    void preservesExactResultForLargePowerOfTenPlusOne() {
        assertEquals("1000000000000000000000000000001", s.addStrings("1000000000000000000000000000000", "1"));
    }
}
