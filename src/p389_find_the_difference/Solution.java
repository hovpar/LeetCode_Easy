package p389_find_the_difference;

class Solution {
    // sum approach
//    char findTheDifference(String s, String t) {
//
//	int sum = 0;
//
//	for (char c : t.toCharArray()) {
//	    sum += c;
//	}
//
//	for (char c : s.toCharArray()) {
//	    sum -= c;
//	}
//
//	return (char) sum;
//
//    }
    // using charAt(i) without converting to charArray
//    char findTheDifference(String s, String t) {
//	    int diff = 0;
//	    for (int i = 0; i < t.length(); i++) diff += t.charAt(i);
//	    for (int i = 0; i < s.length(); i++) diff -= s.charAt(i);
//	    return (char) diff;
//	}
    // XOR approach
    char findTheDifference(String s, String t) {
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            x ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            x ^= t.charAt(i);
        }
        return (char) x;
    }

}
