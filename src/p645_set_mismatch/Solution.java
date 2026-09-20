package p645_set_mismatch;

class Solution {

    public int[] findErrorNums(int[] nums) {
        int[] frequencies = new int[nums.length];

        for (int num : nums) {
            frequencies[num - 1]++;
        }

        int duplicate = -1;
        int missing = -1;

        for (int number = 1; number <= nums.length; number++) {
            int frequency = frequencies[number - 1];

            if (frequency == 2) {
                duplicate = number;
            } else if (frequency == 0) {
                missing = number;
            }
        }

        return new int[] { duplicate, missing };
    }

}
