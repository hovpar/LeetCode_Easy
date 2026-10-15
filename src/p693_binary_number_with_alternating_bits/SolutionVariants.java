package p693_binary_number_with_alternating_bits;

class SolutionVariants {

    interface Solver {
        boolean hasAlternatingBits(int n);
    }

    static class IterativeBitComparisonSolver implements Solver {
        @Override
        public boolean hasAlternatingBits(int n) {
            boolean res = true;

            while (n > 0 && res) {
                var cur = n % 2;
                n /= 2;
                var prev = n % 2;
                if (cur == prev) {
                    res = false;
                }
            }
            return res;
        }
    }

    static class XorBitPatternSolver implements Solver {
        @Override
        public boolean hasAlternatingBits(int n) {
            int bits = n ^ (n >> 1);
            return (bits & (bits + 1)) == 0;
        }
    }

}
