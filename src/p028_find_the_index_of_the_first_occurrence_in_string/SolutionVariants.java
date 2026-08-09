package p028_find_the_index_of_the_first_occurrence_in_string;

class SolutionVariants {

    interface Solver {
        int strStr(String haystack, String needle);
    }

    static class BooleanFlagMatcher implements Solver {
        @Override
        public int strStr(String haystack, String needle) {

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                var isSame = true;
                if (haystack.charAt(i) == needle.charAt(0)) {
                    for (int j = 1; j < needle.length() && isSame; j++) {
                        if (needle.charAt(j) != haystack.charAt(i + j)) {
                            isSame = false;
                        }
                    }

                    if (isSame) {
                        return i;
                    }
                }
            }

            return -1;
        }
    }

    static class IncrementalMatcher implements Solver {
        @Override
        public int strStr(String haystack, String needle) {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int j = 0;

                while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }

                if (j == needle.length()) {
                    return i;
                }
            }

            return -1;

        }
    }

}
