package _136SingleNumber;

class Solution {
    // inefficient: O(n^2) time, O(1)space -> brute force
    // You can optimize this approach by storing whether `num` has already been seen
    // using a `boolean seenBefore`
//    public int singleNumber(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//            boolean found = false;
//
//            for (int j = 0; j < nums.length && !found; j++) {
//                if (i != j && nums[i] == nums[j]) {
//                    found = true;
//                }
//            }
//
//            if (!found) {
//                return nums[i]; // this one has no duplicate
//            }
//        }
//
//        // shouldn't reach here if input is valid
//        throw new IllegalArgumentException("No unique number found");
//
//    }

    // You can optimize the solution using a HashSet (toggle logic)

//    public int singleNumber(int[] nums) {
//        var set = new HashSet<Integer>();
//
//        for (int num : nums) {
//            if (set.contains(num)) {
//                set.remove(num); // seen twice -> remove it
//            } else {
//                set.add(num); // first time -> add it
//            }
//        }
//
//        // the only element left is the unique number
//        return set.iterator().next();
//    }

    // You can solve this with bitwise XOR:
    // this is the best solution: O(n) time and O(1) space
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num; // XOR cancels out duplicates
        }
        return result;
    }
}
