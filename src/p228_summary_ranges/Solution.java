package p228_summary_ranges;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {

        var result = new LinkedList<String>();
        if (nums.length == 0) {
            return result;
        }

        var start = nums[0];
        var end = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                result.add(range(start, end));
                start = nums[i];
                end = nums[i];
            }
        }
        result.add(range(start, end));

        return result;
    }

    private String range(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }

}
