package p191_number_of_1_bits;

class Solution {

    int hammingWeight(int n) {

        var count = 0;

        for (int i = 0; i < 32; i++) {

            if ((n & 1) > 0 ) {
                count++;
            }
            n >>= 1;
        }

        return count;

        // return Integer.bitCount(n);

    }

}
