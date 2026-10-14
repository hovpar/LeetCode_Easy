package p367_valid_perfect_square;

class SolutionVariants {

    interface Solver {
        boolean isPerfectSquare(int num);
    }

    //Time O(sqrt(n))
    static class OddNumberSumSolver implements Solver {
        @Override
        public boolean isPerfectSquare(int num) {
            if (num <= 1) {
                return num >= 0;
            }
            int odd = 1;
            long sum = 1;//long avoids int overflow for Integer.MAX_VALUE

            while (sum < num) {
                odd += 2;
                sum += odd;
            }

            return sum == num;
        }
    }

    static class BinarySearchSolver implements Solver {
        @Override
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return num >= 0;
            }

            int left = 1;
            int right = num / 2;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long square = mid * mid;

                if (square == num) {
                    return true;
                } else if (square > num) {
                    right = (int) mid - 1;
                } else {
                    left = (int) mid + 1;
                }
            }

            return false;
        }
    }
}
