package _171ExcelSheetColumnNumber;

class Solution {

    public int titleToNumber(String columnTitle) {

        var result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + ((int)columnTitle.charAt(i) - 64);
        }
        return result;
    }

}
