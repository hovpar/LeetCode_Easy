package p303_range_sum_query_immutable;

class NumArray {

    // naive approach
//    private int[] nums;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        var sumRange = 0;
//
//        while (left <= right) {
//            sumRange += this.nums[left];
//            left++;
//        }
//        return sumRange;
//    }
    // Create an array with "Accumulated amounts" (`PrefixSum`).
    // For each number in this array,
    // record the sum of the prices from the beginning of the shelf up to that
    // number (inclusive).
    int prefix[];

//    public NumArray(int[] nums) {
//        prefix = new int[nums.length];
//        if (nums.length == 0) { //Prevents ArrayIndexOutOfBoundsException
//            return; 
//        }
//
//        prefix[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            prefix[i] = prefix[i - 1] + nums[i];
//        }
//    }
//
//    public int sumRange(int left, int right) {
//        if (left == 0) {
//            return prefix[right];
//        }
//        int sum = prefix[right] - prefix[left - 1];
//        return sum;
//    }

    // Prefix array with extra leading zero (cleaner sum logic)
    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
