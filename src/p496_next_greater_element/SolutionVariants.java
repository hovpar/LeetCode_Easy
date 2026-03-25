package p496_next_greater_element;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class SolutionVariants {

    interface Solver {
        int[] nextGreaterElement(int[] nums1, int[] nums2);
    }

    static class BruteForcesolver implements Solver {
        @Override
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];

            for (int i = 0; i < nums1.length; i++) {
                int index = -1;

                for (int j = 0; j < nums2.length; j++) {
                    if (nums2[j] == nums1[i]) {
                        index = j;
                        break;
                    }
                }

                result[i] = -1;
                for (int j = index + 1; j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        result[i] = nums2[j];
                        break;
                    }
                }
            }

            return result;
        }
    }

    static class RightToLeftStackSolver implements Solver {
        @Override
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> nextGreater = new HashMap<>();
            ArrayDeque<Integer> stack = new ArrayDeque<>();

            for (int i = nums2.length - 1; i >= 0; i--) {
                int current = nums2[i];

                while (!stack.isEmpty() && stack.peek() <= current) {
                    stack.pop();
                }

                nextGreater.put(current, stack.isEmpty() ? -1 : stack.peek());
                stack.push(current);
            }

            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = nextGreater.get(nums1[i]);
            }

            return result;
        }
    }

}
