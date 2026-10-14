package p342_power_of_four;

class SolutionVariants {

    interface Solver {
        boolean isPowerOfFour(int n);
    }

    static class IterativeDivisionSolver implements Solver {
        @Override
        public boolean isPowerOfFour(int n) {

            if (n < 1) {
                return false;
            }

            while (n > 1 && n % 4 == 0) {
                n /= 4;
            }
            return n == 1;
        }
    }

    static class PowerEnumerationSolver implements Solver {
        // Check whether n equals 2^(2k) by comparing it to all powers of four
        // representable in a 32-bit int
        @Override
        public boolean isPowerOfFour(int n) {
            for (int i = 2; i <= 32; i += 2) {
                if ((1 << i) == n) {
                    return true;
                }
            }
            return false;
        }
    }

    static class BitManipulationSolver implements Solver {
        // n must be positive, a power of two, and have its single set bit at an even
        // position, time O(1)
        @Override
        public boolean isPowerOfFour(int n) {
            return n > 0 && (n & (n - 1)) == 0 // power of two
                    && (n & 0x55555555) != 0; // Keeps only bits at even positions.
            // 0x55555555 =
            // 01010101 01010101 01010101 01010101
        }
    }
}
