package p268_missing_number;

class Solution {
    // Sum approach
//    public int missingNumber(int[] nums) {
//        var sum = 0;
//        var expectedSum = nums.length * (nums.length + 1) / 2;
//        for (int n : nums) {
//            sum += n;
//        }
//
//        return expectedSum - sum;
//    }
    // XOR operator approach
    int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

}
