package _205IsomorphicStrings;

import java.util.HashMap;

class Solution {

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (!charMap.containsKey(sc)) {
                if (!charMap.containsValue(tc)) {
                    charMap.put(sc, tc);
                } else {
                    return false;
                }

            } else {
                if (charMap.get(sc) != tc) {
                    return false;
                }
            }

        }

        return true;

    }

}
