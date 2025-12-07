package p242_valid_anagram;

class Solution {

//    public boolean isAnagram(String s, String t) {
//        var array1 = s.toCharArray();
//        var array2 = t.toCharArray();
//
//        Arrays.sort(array1); //O(nlog(n))
//        Arrays.sort(array2);
//
//        return Arrays.equals(array1, array2);
//
//    }

    // Using count array approach O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
