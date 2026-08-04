package p026_remove_duplicates_from_sorted_array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldHandleSingleElement() {
        assertResult(new int[] { 1 }, new int[] { 1 });
    }

    @Test
    void shouldRemoveDuplicates() {
        assertResult(new int[] { 1, 1, 2 }, new int[] { 1, 2 });
    }

    @Test
    void shouldRemoveMultipleDuplicates() {
        assertResult(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }, new int[] { 0, 1, 2, 3, 4 });
    }

    @Test
    void shouldHandleArrayWithoutDuplicates() {
        assertResult(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4 });
    }

    @Test
    void shouldHandleArrayContainingOnlyDuplicates() {
        assertResult(new int[] { 5, 5, 5, 5 }, new int[] { 5 });
    }

    @Test
    void shouldHandleNegativeNumbers() {
        assertResult(new int[] { -3, -3, -1, -1, 0, 2, 2 }, new int[] { -3, -1, 0, 2 });
    }

    @Test
    void shouldHandleValuesAtConstraintBoundaries() {
        assertResult(new int[] { -100, -100, 0, 100, 100 }, new int[] { -100, 0, 100 });
    }

    private void assertResult(int[] nums, int[] expected) {
        int uniqueCount = solution.removeDuplicates(nums);

        assertEquals(expected.length, uniqueCount);
        assertArrayEquals(expected, Arrays.copyOf(nums, uniqueCount));
    }

}
