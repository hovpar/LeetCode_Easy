package _168ExcelSheetColumnTitle;

class Solution {

    public String convertToTitle(int columnNumber) {
//  doesnt cover edge cases like columnNumber%26==0
//        StringBuilder result = new StringBuilder("");
//
//        Map<Integer, String> map = new HashMap<>();
//
//        for (int i = 0; i < 26; i++) {
//            map.put(i + 1, String.valueOf((char) ('A' + i)));
//        }
//
//        while (columnNumber > 26) {
//            result.append(map.get(columnNumber % 26));
//            columnNumber /= 26;
//
//        }
//        result.append(map.get(columnNumber));
//        return result.reverse().toString();
//
//    }
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // shift to make it 0-indexed
            result.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }

}
