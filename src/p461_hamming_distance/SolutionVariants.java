package p461_hamming_distance;

class SolutionVariants {

    interface Solver {
        int hammingDistance(int x, int y);
    }

    // Time: O(32)
    // Compare bits by shifting both numbers
    static class BitByBitShiftSolver implements Solver {

        @Override
        public int hammingDistance(int x, int y) {
            int distance = 0;

            for (int i = 0; i < 32; i++) {
                if (((x ^ y) & 1) == 1) {
                    distance++;
                }
                x >>= 1;
                y >>= 1;
            }

            return distance;
        }
    }

    // Time: O(32)
    // XOR once, then count bits via shifting
    static class XorBitCountShiftSolver implements Solver {

        @Override
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int distance = 0;

            while (xor != 0) {
                distance += xor & 1;
                xor >>>= 1;
            }

            return distance;
        }
    }

    // Time: O(k), k = number of set bits
    // Brian Kernighan's bit-count algorithm
    static class KernighanBitCountSolver implements Solver {

        @Override
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int distance = 0;

            while (xor != 0) {
                xor &= (xor - 1);
                distance++;
            }

            return distance;
        }
    }
}
