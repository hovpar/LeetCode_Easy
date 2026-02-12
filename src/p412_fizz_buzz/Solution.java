package p412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

class Solution {
//    List<String> fizzBuzz(int n) {
//        List<String> res = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            if (i % 15 == 0) {
//                res.add("FizzBuzz");
//            } else if (i % 3 == 0) {
//                res.add("Fizz");
//            } else if (i % 5 == 0) {
//                res.add("Buzz");
//            } else {
//                res.add(String.valueOf(i));
//            }
//        }
//        return res;
//    }
    // Using ternary operator
    List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i % 15 == 0 ? "FizzBuzz" : i % 5 == 0 ? "Buzz" : i % 3 == 0 ? "Fizz" : String.valueOf(i));
        }

        return ans;
    }
}
