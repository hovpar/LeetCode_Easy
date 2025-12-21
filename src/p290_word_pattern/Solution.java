package p290_word_pattern;

import java.util.HashMap;
import java.util.Map;

class Solution {
//    boolean wordPattern(String pattern, String s) {
//        String[] words = s.split(" ");
//        if (words.length != pattern.length()) {
//            return false;
//        }
//        Map<Character, String> map = new HashMap<>();
//
//        for (int i = 0; i < pattern.length(); i++) {
//            char ch = pattern.charAt(i);
//            String word = words[i];
//
//            if (map.containsKey(ch)) {
//                // If mapping for char already exists, check consistency
//                if (!map.get(ch).equals(word)) {
//                    return false;
//                }
//            } else {
//                // If mapping for char doesn't exist, 
//    // check if word is already mapped to another char
//                // not effective O(n)
//                if (map.containsValue(word)) {
//                    return false;
//                }
//                // Establish new mapping
//                map.put(ch, word);
//            }
//        }
//        return true;
//
//    }

    // Two HashMap approach
    boolean wordPattern(String pattern, String s) {

        String[] words = s.isEmpty() ? new String[0] : s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> p2w = new HashMap<>();
        Map<String, Character> w2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String w = words[i];

            if (p2w.containsKey(p)) {
                if (!p2w.get(p).equals(w)) {
                    return false;
                }
            } else {
                if (w2p.containsKey(w)) {
                    return false;
                }
                p2w.put(p, w);
                w2p.put(w, p);
            }
        }
        return true;
    }

}
