package p762_prime_number_of_set_bits_in_binary_representation;

class Solution {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);

            if (isPrimeSetBitCount(bits)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrimeSetBitCount(int bits) {
        return switch (bits) {
        case 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 -> true;
        default -> false;
        };
    }

}
