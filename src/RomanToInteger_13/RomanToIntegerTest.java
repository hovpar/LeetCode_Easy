package RomanToInteger_13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RomanToIntegerTest {
	
	RomanToInteger romanToInt = new RomanToInteger();

    @Test
    void testBasicNumerals() {
        assertEquals(1, romanToInt.romanToInt("I"));
        assertEquals(5, romanToInt.romanToInt("V"));
        assertEquals(10, romanToInt.romanToInt("X"));
        assertEquals(50, romanToInt.romanToInt("L"));
        assertEquals(100, romanToInt.romanToInt("C"));
        assertEquals(500, romanToInt.romanToInt("D"));
        assertEquals(1000, romanToInt.romanToInt("M"));
    }

    @Test
    void testSimpleCombinations() {
        assertEquals(3, romanToInt.romanToInt("III"));
        assertEquals(4, romanToInt.romanToInt("IV"));
        assertEquals(9, romanToInt.romanToInt("IX"));
        assertEquals(40, romanToInt.romanToInt("XL"));
        assertEquals(90, romanToInt.romanToInt("XC"));
        assertEquals(400, romanToInt.romanToInt("CD"));
        assertEquals(900, romanToInt.romanToInt("CM"));
    }

    @Test
    void testComplexNumerals() {
        assertEquals(58, romanToInt.romanToInt("LVIII"));
        assertEquals(1994, romanToInt.romanToInt("MCMXCIV"));
        assertEquals(621, romanToInt.romanToInt("DCXXI"));
        assertEquals(2024, romanToInt.romanToInt("MMXXIV"));
        assertEquals(1666, romanToInt.romanToInt("MDCLXVI"));
    }

    @Test
    void testEdgeCases() {
        assertEquals(0, romanToInt.romanToInt("")); // Empty string
        assertEquals(1, romanToInt.romanToInt("I")); // Single numeral
        assertEquals(2, romanToInt.romanToInt("II")); // Repeated numeral
    }

}
