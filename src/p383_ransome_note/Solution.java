package p383_ransome_note;

class Solution {

    // HashMap approach
//    boolean canConstruct(String ransomNote, String magazine) {
//
//        Map<Character, Integer> magaHash = new HashMap<>();
//
//        for (char c : magazine.toCharArray()) {
//            magaHash.put(c, magaHash.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : ransomNote.toCharArray()) {
//            if (!magaHash.containsKey(c) || magaHash.get(c) <= 0) {
//                return false;
//            }
//            magaHash.put(c, magaHash.get(c) - 1);
//        }
//
//        return true;
//    }

    // Array approach
    boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
