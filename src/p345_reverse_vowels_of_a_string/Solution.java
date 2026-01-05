package p345_reverse_vowels_of_a_string;

class Solution {
    public String reverseVowels(String s) {
        var word = s.toCharArray();
        int start = 0, end = word.length - 1;

        while (start < end) {
            while (start < end && !isVowel(word[start])) {
                start++;
            }
            while (start < end && !isVowel(word[end])) {
                end--;
            }
            var temp = word[start];
            word[start++] = word[end];
            word[end--] = temp;

        }

        return new String(word);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U';
    }
}
