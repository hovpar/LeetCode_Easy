package p605_can_plant_flowers;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;

        for (int i = 0; i < flowerbed.length && count < n; i++) {
            // Check if the current position is empty and its neighboring positions are also empty
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1; //That prevents the algorithm from planting next to a flower it just planted
                count++;

            }
        }

        return count >= n;
    }
}
