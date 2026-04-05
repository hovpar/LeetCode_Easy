package p504_base_7;

class SolutionVariants {

    interface Solver {
        String convertToBase7(int num);
    }

    static class ReverseStringBuilderSolver implements Solver {
        @Override
        public String convertToBase7(int num) {

            if (num == 0) {
                return "0";
            }
            var isNegative = false;

            if (num < 0) {
                isNegative = true;
                num = -num;
            }

            StringBuilder sb = new StringBuilder();

            while (num != 0) {
                sb.append(num % 7);
                num = num / 7;
            }
            if (isNegative) {
                sb.append("-");
            }

            return sb.reverse().toString();
        }
    }

    //Worse performance: insert(0, …) is O(n) per operation -> overall O(n^2)
    static class PrependStringBuilderSolver implements Solver {
        @Override
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }

            boolean isNegative = num < 0;
            num = Math.abs(num);

            StringBuilder sb = new StringBuilder();

            while (num > 0) {
                sb.insert(0, num % 7);
                num /= 7;
            }

            return isNegative ? "-" + sb : sb.toString();
        }
    }

    //The best solution!
    static class CharArraySolver implements Solver {
        @Override
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }

            boolean isNegative = num < 0;
            num = Math.abs(num);

            char[] buffer = new char[32]; // enough for int
            int index = buffer.length;

            while (num > 0) {
                buffer[--index] = (char) ('0' + (num % 7));
                num /= 7;
            }

            if (isNegative) {
                buffer[--index] = '-';
            }

            return new String(buffer, index, buffer.length - index);
        }
    }

    static class RecursiveSolver implements Solver {
        @Override
        public String convertToBase7(int num) {
            if (num < 0) {
                return "-" + convertToBase7(-num);
            }
            if (num < 7) {
                return String.valueOf(num);
            }
            return convertToBase7(num / 7) + (num % 7);
        }
    }

    static class UsingBuiltInFunctionSolver implements Solver {
        @Override
        public String convertToBase7(int num) {
            return Integer.toString(num, 7);
        }
    }

}
