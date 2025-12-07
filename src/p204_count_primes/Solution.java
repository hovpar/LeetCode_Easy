package p204_count_primes;

class Solution {
    public int countPrimes(int n) {
        // No primes below 2
        if (n < 2) {
            return 0;
        }

        // isComposite[i] = true means "i is NOT a prime number"
        boolean[] isComposite = new boolean[n];
        isComposite[0] = isComposite[1] = true;

        // Sieve of Eratosthenes: mark multiples of each prime
        for (int i = 2; i * i < n; i++) {
            if (!isComposite[i]) {
                // Start from i*i (all smaller multiples already marked)
                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Count numbers that are still not marked as composite
        int count = 0;
        for (boolean composite : isComposite) {
            if (!composite) {
                count++;
            }
        }

        return count;
    }

}
