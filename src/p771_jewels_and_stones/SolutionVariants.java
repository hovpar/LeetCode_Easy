package p771_jewels_and_stones;

import java.util.HashSet;
import java.util.Set;

class SolutionVariants {

    interface Solver {
        int numJewelsInStones(String jewels, String stones);
    }

    static class HashSetSolver implements Solver {
        @Override
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> occurences = new HashSet<>();

            for (int i = 0; i < jewels.length(); i++) {
                occurences.add(jewels.charAt(i));
            }
            var count = 0;

            for (int i = 0; i < stones.length(); i++) {
                if (occurences.contains(stones.charAt(i))) {
                    count++;
                }
            }

            return count;
        }
    }

    static class BooleanArraySolver implements Solver {
        @Override
        public int numJewelsInStones(String jewels, String stones) {
            boolean[] isJewel = new boolean[128];

            for (char jewel : jewels.toCharArray()) {
                isJewel[jewel] = true;
            }

            int count = 0;

            for (char stone : stones.toCharArray()) {
                if (isJewel[stone]) {
                    count++;
                }
            }

            return count;
        }
    }

}
