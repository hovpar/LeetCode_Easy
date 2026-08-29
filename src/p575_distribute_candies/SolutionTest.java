package p575_distribute_candies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsNumberOfTypesWhenTypesAreLimitedByHalf() {
        int[] candyType = { 1, 1, 2, 2, 3, 3 };

        assertEquals(3, s.distributeCandies(candyType));
    }

    @Test
    void returnsHalfWhenThereAreEnoughDifferentTypes() {
        int[] candyType = { 1, 1, 2, 3 };

        assertEquals(2, s.distributeCandies(candyType));
    }

    @Test
    void returnsOneWhenAllCandiesHaveSameType() {
        int[] candyType = { 6, 6, 6, 6 };

        assertEquals(1, s.distributeCandies(candyType));
    }

    @Test
    void returnsHalfWhenEveryCandyHasDifferentType() {
        int[] candyType = { 1, 2, 3, 4 };

        assertEquals(2, s.distributeCandies(candyType));
    }

    @Test
    void returnsOneWhenThereAreTwoCandiesOfSameType() {
        int[] candyType = { 1, 1 };

        assertEquals(1, s.distributeCandies(candyType));
    }

    @Test
    void returnsOneWhenThereAreTwoDifferentTypesButOnlyOneCandyCanBeEaten() {
        int[] candyType = { 1, 2 };

        assertEquals(1, s.distributeCandies(candyType));
    }

    @Test
    void returnsTwoWhenThereAreThreeTypesButOnlyTwoCandiesCanBeEaten() {
        int[] candyType = { 1, 2, 3, 3 };

        assertEquals(2, s.distributeCandies(candyType));
    }

    @Test
    void handlesManyDuplicates() {
        int[] candyType = { 1, 1, 1, 1, 2, 2, 2, 3 };

        assertEquals(3, s.distributeCandies(candyType));
    }
}
