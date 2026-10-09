package p263_ugly_number;

class SolutionVariants {

    interface Solver {
        boolean isUgly(int n);
    }

    static class IterativeSolver implements Solver {
        @Override
        public boolean isUgly(int n) {
            if (n < 1) {
                return false;
            }
            final int[] factors = { 2, 3, 5 };
            for (int factor : factors) {
                while (n % factor == 0) {
                    n /= factor;
                }
            }
            return n == 1;
        }
    }

    // O(log n)
    static class RecursiveSolver implements Solver {
        @Override
        public boolean isUgly(int n) {
            if (n < 1) {
                return false;
            } else if (n == 1) {
                return true;
            } else if (n % 2 == 0) {
                return isUgly(n / 2);
            } else if (n % 3 == 0) {
                return isUgly(n / 3);
            } else if (n % 5 == 0) {
                return isUgly(n / 5);
            } else {
                return false;
            }
        }
    }

}
