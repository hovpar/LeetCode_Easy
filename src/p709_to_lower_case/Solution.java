package p709_to_lower_case;

class Solution {

    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current >= 'A' && current <= 'Z') {
                current = (char) (current + ('a' - 'A'));
            }

            result.append(current);
        }

        return result.toString();
    }
}
