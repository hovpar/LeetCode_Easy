package p258_add_digits;

class Solution {
//    public int addDigits(int num) {
//        int total = 0;
//        while (num > 0) {
//            total += num % 10;
//            num /= 10;
//        }
//        if (total > 10) {
//            return addDigits(total);
//        }
//        return total;
//    }

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }

}
