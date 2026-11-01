package p703_kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

class MinHeapKthLargest implements KthLargest {
    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public MinHeapKthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    @Override
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
