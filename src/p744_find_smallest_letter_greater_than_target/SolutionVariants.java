package p744_find_smallest_letter_greater_than_target;

class SolutionVariants {

    interface Solver {
        char nextGreatestLetter(char[] letters, char target);
    }

    static class LinearSolver implements Solver {

        @Override
        public char nextGreatestLetter(char[] letters, char target) {

            for (char ch : letters) {
                if (ch > target) {
                    return ch;
                }
            }
            return letters[0];
        }

    }

    static class BinarySearchSolver implements Solver {
        @Override
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0, right = letters.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (letters[mid] <= target) {
                    left = mid + 1;

                } else {
                    right = mid;
                }
            }
            return letters[left % letters.length];
        }
    }

}
