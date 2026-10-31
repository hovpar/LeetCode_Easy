package p703_kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

class KthLargest {

    //    List<Integer> stream;
    //    int kth;
    //
    //    public KthLargest(int k, int[] nums) {
    //        this.stream = new ArrayList<>();
    //        this.kth = k;
    //        for (int num : nums) {
    //            this.stream.add(num);
    //        }
    //        Collections.sort(this.stream);
    //    }
    //
    //    public int add(int val) {
    //        this.stream.add(getIndex(val), val);
    //        return stream.get(stream.size() - kth);
    //    }
    //
    //    private int getIndex(int val) {
    //        int left = 0;
    //        int right = stream.size() - 1;
    //        while (left <= right) {
    //            int mid = (left + right) / 2;
    //            int midElement = stream.get(mid);
    //            if (midElement == val) {
    //                return mid;
    //            }
    //            if (midElement > val) {
    //                // Go to left half
    //                right = mid - 1;
    //            } else {
    //                // Go to right half
    //                left = mid + 1;
    //            }
    //        }
    //        return left;
    //    }

    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */