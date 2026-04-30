package p014_longest_common_prefix;

class SolutionVariants {

    interface Solver {
        String longestCommonPrefix(String[] strs);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }

            return longestCommonPrefixRec(strs, 0);
        }

        private String longestCommonPrefixRec(String[] strs, int index) {
            char current;

            if (index >= strs[0].length()) {
                return "";
            }

            current = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != current) {
                    return "";
                }
            }

            return current + longestCommonPrefixRec(strs, index + 1);
        }
    }

    static class IterativeSolver implements Solver {
        @Override
        public String longestCommonPrefix(String[] strs) {

            if (strs.length == 0) {
                return "";
            } else {
                var prefix = strs[0];
                for (int i = 1; i < strs.length; i++) {
                    while (strs[i].indexOf(prefix) != 0) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                    }

                }

                return prefix;
            }
        }
    }

}