package p461_hamming_distance;

class Solution {
    // Time complexity: O(32)
//    int hammingDistance(int x, int y) {
//        int distance = 0;
//
//        for (int i = 0; i < 32; i++) {
//            // mask the lowest bit
//            if (((x ^ y) & 1) == 1) {
//                distance++;
//            }
//            x >>= 1;
//            y >>= 1;
//        }
//
//        return distance;
//    }

    // Compute XOR once (cleaner)
    // Time complexity: O(32)
//    int hammingDistance(int x, int y) {
//        int xor = x ^ y;
//        int distance = 0;
//
//        while (xor != 0) {
//            distance += xor & 1;
//            xor >>>= 1;   // unsigned shift
//        }
//
//        return distance;
//    }

    // Most optimal (Brian Kernighan’s algorithm)
    // Time complexity: O(k) where k = number of differing bits
    int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;

        while (xor != 0) {
            xor &= (xor - 1);
            distance++;
        }

        return distance;
    }

}
