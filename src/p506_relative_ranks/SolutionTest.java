package p506_relative_ranks;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsMedalsAndRanks_forLeetCodeExample1() {
        int[] score = { 5, 4, 3, 2, 1 };
        String[] expected = { "Gold Medal", "Silver Medal", "Bronze Medal", "4", "5" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void returnsCorrectRanks_forLeetCodeExample2() {
        int[] score = { 10, 3, 8, 9, 4 };
        String[] expected = { "Gold Medal", "5", "Bronze Medal", "Silver Medal", "4" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void returnsGoldOnly_forSingleAthlete() {
        int[] score = { 99 };
        String[] expected = { "Gold Medal" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void returnsGoldAndSilver_forTwoAthletes() {
        int[] score = { 20, 10 };
        String[] expected = { "Gold Medal", "Silver Medal" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void returnsAllThreeMedals_forThreeAthletes() {
        int[] score = { 30, 10, 20 };
        String[] expected = { "Gold Medal", "Bronze Medal", "Silver Medal" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void preservesOriginalOrder_whenScoresAreUnsorted() {
        int[] score = { 50, 80, 70, 90, 60 };
        String[] expected = { "5", "Silver Medal", "Bronze Medal", "Gold Medal", "4" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void handlesLargeValues() {
        int[] score = { 1000000, 999999, 999998, 1 };
        String[] expected = { "Gold Medal", "Silver Medal", "Bronze Medal", "4" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void handlesAlreadyDescendingScores() {
        int[] score = { 9, 8, 7, 6 };
        String[] expected = { "Gold Medal", "Silver Medal", "Bronze Medal", "4" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }

    @Test
    void handlesAlreadyAscendingScores() {
        int[] score = { 1, 2, 3, 4 };
        String[] expected = { "4", "Bronze Medal", "Silver Medal", "Gold Medal" };

        assertArrayEquals(expected, s.findRelativeRanks(score));
    }
}
