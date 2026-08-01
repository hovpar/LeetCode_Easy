package p541_reverse_string_ii;

class SolutionVariants {

    interface Solver {
        String reverseStr(String s, int k);
    }

    static class SubstringSolver implements Solver {
        @Override
        public String reverseStr(String s, int k) {
            var result = new StringBuilder();
            var length = s.length();
            for (int i = 0; i < length; i = i + 2 * k) {
                int reverseEnd = Math.min(i + k, length);
                int blockEnd = Math.min(i + 2 * k, length);

                result.append(reverse(s.substring(i, reverseEnd)));
                result.append(s, reverseEnd, blockEnd);

            }

            return result.toString();
        }

        static String reverse(String s) {
            var result = new StringBuilder();

            for (int i = s.length() - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            return result.toString();
        }
    }

    static class CharArraySolver implements Solver {
        @Override
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();

            for (int start = 0; start < chars.length; start += 2 * k) {
                int left = start;
                int right = Math.min(start + k - 1, chars.length - 1);

                while (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;

                    left++;
                    right--;
                }
            }

            return new String(chars);
        }
    }

}
