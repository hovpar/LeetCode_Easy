package _190ReverseBits;

class Solution {
    public int reverseBits(int n) {
        var result = 0;

        for (int i = 0; i < 32; i++) {
            result = result << 1;

            if ((n % 2) > 0) { // or result = result | (n & 1);
                result++;
            }

            n = n >> 1; // n = n >>> 1; shift n to the right (unsigned)

        }

        return result;
    }

    // Divide and conquer approach O(1)

    public int reverseBits1(int n) {
        n = (n >>> 16) | (n << 16); // no mask needed
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

}
