package p476_number_complement;

class SolutionVariants {
    interface Solver {
        int findComplement(int num);
    }

    static class BitMaskConstructionSolver implements Solver {
        @Override
        public int findComplement(int num) {

            int ones = 0;
            int temp = num;
            // Create a mask of ones with the same size as the number.
            while (temp > 0) {
                ones <<= 1;
                ones += 1;
                temp >>= 1;
            }

            return ones - num;
            // or with XOR operator
            // return num ^ ones;
        }
    }

    // using built-in function
    static class HighestOneBitMaskSolver implements Solver {
        @Override
        public int findComplement(int num) {
            int mask = (Integer.highestOneBit(num) << 1) - 1;
            return num ^ mask;
        }
    }

}
