package _26RemoveDuplicatesFromSortedArray;

class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[uniqueIndex] != nums[i]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }

        }
        return uniqueIndex + 1;
    }
}
