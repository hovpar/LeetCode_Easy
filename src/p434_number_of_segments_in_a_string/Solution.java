package p434_number_of_segments_in_a_string;

class Solution {
//    int countSegments(String s) {
//        var length = s.length();
//        var count = 0;
//
//        for (int i = 0; i < length; i++) {
//            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
//                count++;
//            }
//        }
//        return count;
//    }

    // use built-in trim and split functions
    int countSegments(String s) {

        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }

        return trimmed.split("\\s+").length;

    }
}
