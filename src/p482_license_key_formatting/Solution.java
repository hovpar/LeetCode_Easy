package p482_license_key_formatting;

class Solution {
    String licenseKeyFormatting(String s, int k) {

        StringBuilder formatted = new StringBuilder();
        int groupSize = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);

            if (current == '-') {
                continue;
            }

            if (groupSize == k) {
                formatted.append('-');
                groupSize = 0;
            }

            formatted.append(Character.toUpperCase(current));
            groupSize++;
        }

        return formatted.reverse().toString();
    }
}
