package p441_arranging_coins;

class SolutionVariants {

    interface Solver {
        int arrangeCoins(int n);
    }

    static class IterativeSolver implements Solver {
        @Override
        public int arrangeCoins(int n) {

            var k = 0;

            while (n >= 0) {
                k++;
                n = n - k;
            }

            return k - 1;
        }
    }

    static class BinarySearchSolver implements Solver {
        @Override
        public int arrangeCoins(int n) {
            long start = 0;
            long end = n;

            while (start <= end) {
                long mid = start + (end - start) / 2;

                long coinsUsed = mid * (mid + 1) / 2;

                if (coinsUsed == n) {
                    return (int) mid;
                } else if (coinsUsed < n) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return (int) end;

        }
    }

    // also O(log(n)) because of Math.sqrt()!
    static class QuadraticFormulaSolver implements Solver {
        @Override
        public int arrangeCoins(int n) {
            return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);

        }
    }

}
