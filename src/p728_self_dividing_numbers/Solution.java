package p728_self_dividing_numbers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (idSelfDividing(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean idSelfDividing(int num) {

        var remaining = num;

        while (remaining > 0) {
            int digit = remaining % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            remaining /= 10;
        }
        return true;
    }
}
