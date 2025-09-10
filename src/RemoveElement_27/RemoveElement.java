package RemoveElement_27;

class RemoveElement {
    static int removeElement(int[] nums, int val) {

        var start = 0;
        var end = nums.length - 1;

        while (start <= end) {
            if (nums[end] == val) {
                end--;
                continue;
            }
            if (nums[start] == val) {
                nums[start] = nums[end];
                end--;
            }
            start++;

        }
        return start;
        
//            int end = nums.length - 1;
//
//            for (int start = 0; start <= end; start++) {
//                if (nums[end] == val) {
//                    end--;
//                    start--;  // Decrease the start to skip this iteration
//                    continue; 
//                }
//
//                if (nums[start] == val) {
//                    nums[start] = nums[end];
//                    end--; 
//                }
//            }
//
//            return end + 1; 

    }

}
