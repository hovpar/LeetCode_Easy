package p292_nim_game;

class Solution {
    // All losing positions are exact multiples of 4
    public boolean canWinNim(int n) {
        return n % 4 != 0;

    }

}
