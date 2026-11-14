package p744_find_smallest_letter_greater_than_target;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        for (char ch : letters) {
            if (ch > target) {
                return ch;
            }
        }
        return letters[0];
    }

    //Also possible binary search solution
}
