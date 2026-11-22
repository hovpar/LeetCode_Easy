package p748_shortest_completing_word;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] required = new int[26];

        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                required[c - 'a']++;
            }
        }

        String result = null;

        for (String word : words) {
            if (result != null && word.length() >= result.length()) {
                continue;
            }

            int[] counts = new int[26];

            for (char c : word.toLowerCase().toCharArray()) {
                counts[c - 'a']++;
            }

            if (containsAll(required, counts)) {
                result = word;
            }
        }

        return result;
    }

    private boolean containsAll(int[] required, int[] counts) {
        for (int i = 0; i < 26; i++) {
            if (counts[i] < required[i]) {
                return false;
            }
        }

        return true;
    }
}
