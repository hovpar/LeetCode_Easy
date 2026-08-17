package p067_add_binary;

class Solution {

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); // Use StringBuilder for efficient appending
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }

            result.append((char) (carry % 2 + '0')); // Append the current digit
            carry /= 2; // Update carry
        }

        return result.reverse().toString(); // Reverse the string to get the correct order
    }

}
