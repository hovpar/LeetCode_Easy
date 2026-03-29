package p500_keyboard_row;

import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        String[] rows = { "qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM" };
        for (String word : words) {
            for (String row : rows) {
                if (isInRow(row, word)) {
                    result.add(word);
                    break; // avoid extra iterating after finding the word
                }
            }
        }
        return result.toArray(new String[0]);
    }

    private boolean isInRow(final String row, final String word) {
        for (char c : word.toCharArray()) {
            if (row.indexOf(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
