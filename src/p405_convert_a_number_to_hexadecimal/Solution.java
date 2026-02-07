package p405_convert_a_number_to_hexadecimal;

class Solution {
    String toHex(int num) {
        if (num == 0) {
            return "0";
        } else {

            String hex = "0123456789abcdef";
            // without built-in functions
            // String res = "";
            StringBuilder res = new StringBuilder();

            while (num != 0) {
                int rem = num & 15;
                // res = hex.charAt(rem) + res;
                res = res.append(hex.charAt(rem));
                num = num >>> 4;
            }
            // return res;
            return res.reverse().toString();
        }
    }

    //Built-in function
//    String toHex(int num) {
//        return Integer.toHexString(num);
//    }
}
