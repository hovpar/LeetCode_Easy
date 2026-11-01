package p703_kth_largest_element_in_a_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortedListBinarySearchKthLargest implements KthLargest {
    private final int k;
    private final List<Integer> sortedNumbers;

    public SortedListBinarySearchKthLargest(int k, int[] nums) {
        this.sortedNumbers = new ArrayList<>();
        this.k = k;
        for (int num : nums) {
            this.sortedNumbers.add(num);
        }
        Collections.sort(this.sortedNumbers);
    }

    @Override
    public int add(int val) {
        this.sortedNumbers.add(findInsertionIndex(val), val);
        return sortedNumbers.get(sortedNumbers.size() - k);
    }

    private int findInsertionIndex(int val) {
        int left = 0;
        int right = sortedNumbers.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sortedNumbers.get(mid) < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
