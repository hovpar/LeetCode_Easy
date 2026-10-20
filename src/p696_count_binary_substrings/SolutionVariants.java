package p696_count_binary_substrings;

class SolutionVariants {

    interface Solver {
        int countBinarySubstrings(String s);
    }

    static class CountConsecutiveBlocksSolver implements Solver {
        @Override
        public int countBinarySubstrings(String s) {
            int length = s.length();
            int[] blocks = new int[length];
            int blockCount = 0, count = 1;

            for (int i = 1; i < length; i++) {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    count++;
                } else {
                    blocks[blockCount++] = count;
                    count = 1;
                }

            }
            blocks[blockCount++] = count;

            int res = 0;
            for (int i = 1; i < blockCount; i++) {
                res += Math.min(blocks[i - 1], blocks[i]);
            }

            return res;
        }
    }

    static class TwoPointerSolver implements Solver {
        @Override
        public int countBinarySubstrings(String s) {
            int res = 0, prev = 0, cur = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) != s.charAt(i)) {
                    res += Math.min(prev, cur);
                    prev = cur;
                    cur = 1;
                } else {
                    cur++;
                }
            }

            return res + Math.min(prev, cur);
        }
    }

}
