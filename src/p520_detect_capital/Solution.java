package p520_detect_capital;

class Solution {
    boolean detectCapitalUse(String word) {
        var count = 0;
        var size = word.length();
        for (int i = 0; i < size; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }

        return (count == 0 || (count == 1 && Character.isUpperCase(word.charAt(0))) || count == size);
    }

}
