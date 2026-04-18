package p509_fibonacci_number;

import java.util.Arrays;

class SolutionVariants {

    interface Solver {
        int fib(int n);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public int fib(int n) {
            if (n < 2) {
                return n;
            } else {
                return fib(n - 1) + fib(n - 2);
            }
        }
    }

    //A dynamic programming recursive version
    static class MemoizedRecursiveSolver implements Solver {
        @Override
        public int fib(int n) {
            int[] memo = new int[n + 1];
            //Instead of using an Integer[] and checking if the index is null, assign values with -1.
            Arrays.fill(memo, -1);
            return fib(n, memo);
        }

        private int fib(int n, int[] memo) {
            if (n < 2) {
                return n;
            }
            if (memo[n] != -1) {
                return memo[n];
            }

            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
            return memo[n];
        }
    }

    static class IterativeSolver implements Solver {
        @Override
        public int fib(int n) {
            if (n < 2) {
                return n;
            }

            int a = 0;
            int b = 1;

            for (int i = 2; i <= n; i++) {
                int next = a + b;
                a = b;
                b = next;
            }

            return b;
        }
    }
}
