package p717_1_bit_and_2_bit_characters;

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        var length = bits.length;
        var pointer = 0;

        while (pointer < length - 1) {
            pointer += 1 + bits[pointer];

        }
        return pointer == length - 1;

    }
}
