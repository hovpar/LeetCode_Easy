package p697_degree_of_an_array;

import java.util.HashMap;
import java.util.Map;

class SolutionVariants {

    interface Solver {
        int findShortestSubArray(int[] nums);
    }

    static class ThreeHashMapSolver implements Solver {
        @Override
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> frequency = new HashMap<>();
            Map<Integer, Integer> firstIndex = new HashMap<>();
            Map<Integer, Integer> lastIndex = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                //frequency.put(num, frequency.getOrDefault(num, 0) + 1);
                //or: Integer::sum is a method reference equivalent to (oldValue, newValue) -> oldValue + newValue
                frequency.merge(num, 1, Integer::sum);
                firstIndex.putIfAbsent(num, i);
                lastIndex.put(num, i);
            }

            int degree = 0;
            for (int count : frequency.values()) {
                degree = Math.max(degree, count);
            }

            int shortestLength = nums.length;

            for (int num : frequency.keySet()) {
                if (frequency.get(num) == degree) {
                    int length = lastIndex.get(num) - firstIndex.get(num) + 1;
                    shortestLength = Math.min(shortestLength, length);
                }
            }

            return shortestLength;
        }
    }

    static class SingleHashMapSolver implements Solver {
        @Override
        public int findShortestSubArray(int[] nums) {

            Map<Integer, int[]> numberStats = new HashMap<>();

            final int FREQUENCY = 0;
            final int FIRST_INDEX = 1;
            final int LAST_INDEX = 2;

            for (int i = 0; i < nums.length; i++) {
                if (!numberStats.containsKey(nums[i])) {
                    // the first element in array is degree, second is first index of this key, third is last index of this key
                    numberStats.put(nums[i], new int[] { 1, i, i });
                } else {
                    int[] temp = numberStats.get(nums[i]);
                    temp[FREQUENCY]++;
                    temp[LAST_INDEX] = i;
                }
            }
            int degree = 0;
            int shortestLength = nums.length;

            for (int[] value : numberStats.values()) {
                if (value[FREQUENCY] > degree) {
                    degree = value[FREQUENCY];
                    shortestLength = value[LAST_INDEX] - value[FIRST_INDEX] + 1;
                } else if (value[FREQUENCY] == degree) {
                    shortestLength = Math.min(value[LAST_INDEX] - value[FIRST_INDEX] + 1, shortestLength);
                }
            }

            return shortestLength;
        }
    }

}
