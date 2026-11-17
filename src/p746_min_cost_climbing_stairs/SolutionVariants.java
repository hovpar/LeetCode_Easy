package p746_min_cost_climbing_stairs;

class SolutionVariants {

    interface Solver {
        int minCostClimbingStairs(int[] cost);
    }

    //Time:O(n^2), space: O(n) stack
    static class NaiveRecursionSolver implements Solver {
        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            return Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
        }

        private int minCost(int n, int[] cost) {
            if (n < 0) {
                return 0;
            }
            if (n == 0 || n == 1) {
                return cost[n];
            }
            return cost[n] + Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
        }
    }

    //Time: O(n), Space:O(n)
    static class DPArraySolver implements Solver {
        @Override
        public int minCostClimbingStairs(int[] cost) {

            int n = cost.length;

            int[] minCost = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                minCost[i] = Math.min(cost[i - 1] + minCost[i - 1], cost[i - 2] + minCost[i - 2]);
            }

            return minCost[n];
        }
    }

    //Fine tuning on DPArray Solver, space O(1)
    static class TwoVariablesSolver implements Solver {
        @Override
        public int minCostClimbingStairs(int[] cost) {
            int prevTwo = 0;
            int prevOne = 0;

            for (int i = 2; i <= cost.length; i++) {
                int current = Math.min(cost[i - 1] + prevOne, cost[i - 2] + prevTwo);

                prevTwo = prevOne;
                prevOne = current;
            }

            return prevOne;
        }
    }

}
