package p557_reverse_words_in_a_string_iii;

class SolutionVariants {

    interface Solver {
        String reverseWords(String s);
    }
    //O(n) time, but it performs several unnecessary allocations:
    //split(" ") creates an array and individual word strings.
    //reverse() creates a new StringBuilder and String for every word.
    //A second loop rebuilds the final result.

    static class SplitAndRebuildSolver implements Solver {
        @Override
        public String reverseWords(String s) {

            StringBuilder output = new StringBuilder();
            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++) {
                words[i] = reverse(words[i]);
            }

            for (int i = 0; i < words.length - 1; i++) {
                output.append(words[i]);
                output.append(" ");
            }
            output.append(words[words.length - 1]);
            return output.toString();
        }

        static String reverse(String s) {
            var result = new StringBuilder();

            for (int i = s.length() - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }

            return result.toString();
        }
    }

    static class InPlaceCharArraySolver implements Solver {
        @Override
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int wordStart = 0;

            for (int i = 0; i <= chars.length; i++) {
                if (i == chars.length || chars[i] == ' ') {
                    reverse(chars, wordStart, i - 1);
                    wordStart = i + 1;
                }
            }

            return new String(chars);
        }

        private static void reverse(char[] chars, int left, int right) {
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }
    }

}
