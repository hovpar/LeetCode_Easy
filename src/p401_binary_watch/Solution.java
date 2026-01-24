package p401_binary_watch;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Use built-in bitCount method
//    List<String> readBinaryWatch(int turnedOn) {
//        List<String> times = new ArrayList<>();
//        for (int h = 0; h < 12; h++) {
//            for (int m = 0; m < 60; m++) {
//                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
//                    times.add(String.format("%d:%02d", h, m));
//                }
//            }
//        }
//
//        return times;
//
//    }
    // Backtracking approach is more effective.
    List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        // LED values: first 4 are hours (1, 2, 4, 8), next 6 are minutes (1, 2, 4, 8,
        // 16, 32)
        int[] ledValues = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };

        backtrack(turnedOn, 0, 0, 0, ledValues, times);
        return times;
    }

    private void backtrack(int remaining, int index, int hr, int min, int[] ledValues, List<String> times) {
        // Base Case: Invalid time
        if (hr >= 12 || min >= 60) {
            return;
        }

        // Base Case: All required LEDs are used
        if (remaining == 0) {
            times.add(String.format("%d:%02d", hr, min));
            return;
        }

        // Explore remaining LEDs
        for (int i = index; i < ledValues.length; i++) {
            if (i < 4) { // It's an hour LED
                backtrack(remaining - 1, i + 1, hr + ledValues[i], min, ledValues, times);
            } else { // It's a minute LED
                backtrack(remaining - 1, i + 1, hr, min + ledValues[i], ledValues, times);
            }
        }
    }
}
