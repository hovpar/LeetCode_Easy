package p599_minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionVariants {
    interface Solver {
        String[] findRestaurant(String[] list1, String[] list2);
    }

    static class NestedLoopSolver implements Solver {
        // O(n * m)
        @Override
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> candidates = new ArrayList<>();
            var minSum = Integer.MAX_VALUE;
            for (int i = 0; i < list1.length; i++) {
                for (int j = 0; j < list2.length; j++) {
                    if (list1[i].equals(list2[j])) {
                        if (i + j < minSum) {
                            candidates.clear();
                            candidates.add(list1[i]);
                            minSum = i + j;
                        } else if (i + j == minSum) {
                            candidates.add(list1[i]);
                        }
                    }
                }
            }

            String[] result = new String[candidates.size()];

            for (int i = 0; i < result.length; i++) {
                result[i] = candidates.get(i);
            }
            return result;
        }
    }

    static class HashMapSolver implements Solver {
        // O(n + m)
        @Override
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> indexMap = new HashMap<>();

            for (int j = 0; j < list2.length; j++) {
                indexMap.put(list2[j], j);
            }

            int minSum = Integer.MAX_VALUE;

            for (int i = 0; i < list1.length; i++) {
                Integer j = indexMap.get(list1[i]);

                if (j != null) {
                    minSum = Math.min(minSum, i + j);
                }
            }

            List<String> candidates = new ArrayList<>();

            for (int i = 0; i < list1.length; i++) {
                Integer j = indexMap.get(list1[i]);

                if (j != null && i + j == minSum) {
                    candidates.add(list1[i]);
                }
            }

            return candidates.toArray(new String[0]);
        }
    }
}
