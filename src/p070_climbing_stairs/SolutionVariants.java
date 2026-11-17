package p070_climbing_stairs;

class SolutionVariants {

    interface Solver {
        int climbStairs(int n);
    }

    static class NaiveRecursionSolver implements Solver {
        @Override
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;

            } else {
                return climbStairs(n - 1) + climbStairs(n - 2);
            }
        }
    }

    static class DPArraySolver implements Solver {
        @Override
        public int climbStairs(int n) {
            var memo = new Integer[n + 1];
            return climbStairs(memo, n);
        }

        private int climbStairs(Integer[] memo, int n) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else {
                if (memo[n] == null) {
                    memo[n] = climbStairs(memo, n - 1) + climbStairs(memo, n - 2);
                }
                return memo[n];

            }
        }
    }

    static class TwoVariablesSolver implements Solver {

        @Override
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            int previous = 1;
            int current = 2;

            for (int i = 3; i <= n; i++) {
                int next = previous + current;

                previous = current;
                current = next;
            }

            return current;
        }
    }

}
