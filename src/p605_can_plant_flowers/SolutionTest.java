package p605_can_plant_flowers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void canPlaceOneInTheMiddle() {
        int[] flowerbed = { 1, 0, 0, 0, 1 };

        assertTrue(s.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    void cannotPlaceTwoInTheMiddle() {
        int[] flowerbed = { 1, 0, 0, 0, 1 };

        assertFalse(s.canPlaceFlowers(flowerbed, 2));
    }

    @Test
    void zeroFlowersAlwaysReturnsTrue() {
        int[] flowerbed = { 1, 0, 1, 0, 1 };

        assertTrue(s.canPlaceFlowers(flowerbed, 0));

    }

    @Test
    void canPlaceAtEndWhenBeginningIsOccupied() {
        int[] flowerbed = { 1, 0, 0 };

        assertTrue(s.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    void canPlaceAtTheEnd() {
        int[] flowerbed = { 0, 1, 0, 1, 0, 1, 0, 0 };
        assertTrue(s.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    void canPlaceTwoAtBothEnds() {
        int[] flowerbed = { 0, 0, 0 };

        assertTrue(s.canPlaceFlowers(flowerbed, 2));
    }

    @Test
    void cannotPlaceTwoAdjacentFlowers() {
        int[] flowerbed = { 0, 0 };

        assertFalse(s.canPlaceFlowers(flowerbed, 2));
    }

    @Test
    void canPlaceOneInTwoEmptySpots() {
        int[] flowerbed = { 0, 0 };

        assertTrue(s.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    void cannotPlaceBetweenExistingFlowers() {
        int[] flowerbed = { 1, 0, 1 };

        assertFalse(s.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    void canPlaceMultipleFlowers() {
        int[] flowerbed = { 0, 0, 0, 0, 0 };

        assertTrue(s.canPlaceFlowers(flowerbed, 3));
    }

    @Test
    void cannotPlaceTooManyFlowers() {
        int[] flowerbed = { 0, 0, 0, 0, 0 };

        assertFalse(s.canPlaceFlowers(flowerbed, 4));
    }

    @Test
    void singleEmptySpot() {
        int[] flowerbed = { 0 };

        assertTrue(s.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    void singleOccupiedSpot() {
        int[] flowerbed = { 1 };

        assertFalse(s.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    void singleEmptySpotWithZeroFlowers() {
        int[] flowerbed = { 0 };

        assertTrue(s.canPlaceFlowers(flowerbed, 0));
    }

}
