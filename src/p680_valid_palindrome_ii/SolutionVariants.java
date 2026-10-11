package p680_valid_palindrome_ii;

class SolutionVariants {

    interface Solver {
        boolean validPalindrome(String s);
    }

    static class IterativeSolver implements Solver {
        @Override
        public boolean validPalindrome(String s) {

            int left = 0, right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
                }
                left++;
                right--;
            }

            return true;
        }

        private boolean isPalindrome(String s, int i, int j) {

            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }

    static class RecursiveSolver implements Solver {
        @Override
        public boolean validPalindrome(String s) {
            return isValidPalindrome(s, 0, s.length() - 1, true);
        }

        private boolean isValidPalindrome(String s, int left, int right, boolean canDelete) {

            if (left >= right) {
                return true;
            }

            if (s.charAt(left) == s.charAt(right)) {
                return isValidPalindrome(s, left + 1, right - 1, canDelete);
            }

            if (!canDelete) {
                return false;
            }

            return isValidPalindrome(s, left + 1, right, false) || isValidPalindrome(s, left, right - 1, false);
        }
    }

}
