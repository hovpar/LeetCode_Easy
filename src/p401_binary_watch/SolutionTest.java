package p401_binary_watch;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testZeroLeds() {
        // Only one possible time: 0:00
        List<String> result = s.readBinaryWatch(0);
        assertEquals(List.of("0:00"), result, "Should return 0:00 when no LEDs are on");
    }

    @Test
    void testOneLed() {
        List<String> expected = List.of("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00");
        List<String> result = s.readBinaryWatch(1);

        // Use containsAll and size check to ignore order issues
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testMaxPossibleLeds() {
        // The maximum number of LEDs that can be on is 8
        // (8:59 = 1000 : 111011 -> 1+5 = 6 bits)
        // (11:51 = 1011 : 110011 -> 3+4 = 7 bits)
        // If we ask for 9 or 10, it's impossible.
        assertTrue(s.readBinaryWatch(9).isEmpty());
        assertTrue(s.readBinaryWatch(10).isEmpty());
    }

    @Test
    void testBoundaryConstraints() {
        // Test a high but valid number
        // For turnedOn = 8, there are specific valid times like 7:59 or 11:59
        List<String> result = s.readBinaryWatch(8);

        // 11:59 -> hours(1+2+8=3 bits) + mins(1+2+4+8+16+32=6 bits) = 9 bits.
        // So 8 bits is actually the upper practical limit for some combinations.
        assertFalse(result.isEmpty(), "There should be valid times for 8 LEDs");
    }

    @Test
    void testAgainstBruteForce() {
        int turnedOn = 4;
        List<String> backtrackingResult = s.readBinaryWatch(turnedOn);

        // Brute force calculation
        List<String> expected = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    expected.add(String.format("%d:%02d", h, m));
                }
            }
        }

        Collections.sort(backtrackingResult);
        Collections.sort(expected);
        assertEquals(expected, backtrackingResult);
    }

}
