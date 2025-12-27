package p344_reverse_string;

class Solution {

    public void reverseString(char[] s) {
        var j = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            var temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j--;
        }

    }

}
