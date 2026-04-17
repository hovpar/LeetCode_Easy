package p507_perfect_number;

import java.util.Set;

class SolutionVariants {

    interface Solver {
        boolean checkPerfectNumber(int num);
    }

    // Time: O(sqrt(n))
    static class SqrtDivisorSumSolver implements Solver {

        @Override
        public boolean checkPerfectNumber(int num) {
            if (num <= 1) {
                return false;
            }

            int sum = 1; // 1 is always a divisor

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    sum += i;

                    if (i != num / i) {
                        sum += num / i;
                    }
                }
            }

            return sum == num;
        }
    }

    static class PrecomputedPerfectNumberSolver implements Solver {
        private static final Set<Integer> PERFECTS = Set.of(6, 28, 496, 8128, 33550336);

        @Override
        public boolean checkPerfectNumber(int num) {
            return PERFECTS.contains(num);
        }
    }
}
