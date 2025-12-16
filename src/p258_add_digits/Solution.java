package p258_add_digits;

class Solution {
    // naive approach
//    public int addDigits(int num) {
//        int total = 0;
//        while (num > 0) {
//            total += num % 10;
//            num /= 10;
//        }
//        if (total >= 10) {
//            return addDigits(total);
//        }
//        return total;
//    }
    // O(1) Solution (Digital Root)
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }

}
