package p190_reverse_bits;

class SolutionVariants {

    interface Solver {
        int reverseBits(int n);
    }

    static class BitByBitSolver implements Solver {
        //take lowest bit -> append it to result -> shift n -> repeat 32 times
        @Override
        public int reverseBits(int n) {
            var result = 0;

            for (int i = 0; i < 32; i++) {

                result = result << 1;
                result = result | (n & 1);
                n = n >> 1; // n = n >>> 1; shift n to the right (unsigned)

            }

            return result;
        }
    }

    // Divide and conquer approach O(1)
    static class BitPermutationSolver implements Solver {
        @Override
        public int reverseBits(int n) {
            n = (n >>> 16) | (n << 16); // no mask needed
            n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
            n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
            n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
            n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
            return n;

        }
    }

    static class BuiltInFunctinSolver implements Solver {
        @Override
        public int reverseBits(int n) {
            return Integer.reverse(n);
        }
    }

}
