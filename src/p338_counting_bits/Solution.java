package p338_counting_bits;

class Solution {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i < result.length; i++) {
            // result[i] = result[i / 2] + i % 2;
            // or use bitwise operator and logical and
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

}
