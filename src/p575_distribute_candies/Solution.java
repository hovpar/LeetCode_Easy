package p575_distribute_candies;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        var n = candyType.length;
        Set<Integer> candyTypes = new HashSet<>();

        for (int candy : candyType) {
            candyTypes.add(candy);
        }

        return Math.min(candyTypes.size(), n / 2);
    }
}
