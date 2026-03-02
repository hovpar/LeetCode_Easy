package p455_assign_cookies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    void returnsZeroWhenNoCookies() {
        int[] g = { 1, 2, 3 };
        int[] s = {};
        assertEquals(0, sol.findContentChildren(g, s));
    }

    @Test
    void returnsZeroWhenNoChildren() {
        int[] g = {};
        int[] s = { 1, 2, 3 };
        assertEquals(0, sol.findContentChildren(g, s));
    }

    @Test
    void returnsZeroWhenBothEmpty() {
        int[] g = {};
        int[] s = {};
        assertEquals(0, sol.findContentChildren(g, s));
    }

    @Test
    void singleChildSatisfied() {
        int[] g = { 1 };
        int[] s = { 2 };
        assertEquals(1, sol.findContentChildren(g, s));
    }

    @Test
    void singleChildNotSatisfied() {
        int[] g = { 5 };
        int[] s = { 1 };
        assertEquals(0, sol.findContentChildren(g, s));
    }

    @Test
    void examplePartialSatisfaction() {
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };
        assertEquals(1, sol.findContentChildren(g, s));
    }

    @Test
    void exampleAllSatisfied() {
        int[] g = { 1, 2 };
        int[] s = { 1, 2, 3 };
        assertEquals(2, sol.findContentChildren(g, s));
    }

    @Test
    void unsortedInputStillWorks() {
        int[] g = { 10, 9, 8, 7 };
        int[] s = { 5, 6, 7, 8 };
        assertEquals(2, sol.findContentChildren(g, s));
    }

    @Test
    void allChildrenHaveSameGreed() {
        int[] g = { 2, 2, 2 };
        int[] s = { 1, 2, 2, 3 };
        assertEquals(3, sol.findContentChildren(g, s));
    }

    @Test
    void allCookiesSameSize() {
        int[] g = { 1, 2, 3 };
        int[] s = { 2, 2, 2 };
        assertEquals(2, sol.findContentChildren(g, s));
    }

    @Test
    void largeGreedValuesNoMatch() {
        int[] g = { 100, 200, 300 };
        int[] s = { 1, 2, 3 };
        assertEquals(0, sol.findContentChildren(g, s));
    }

    @Test
    void moreCookiesButOnlySmallOnes() {
        int[] g = { 5, 6, 7 };
        int[] s = { 1, 1, 1, 1, 1 };
        assertEquals(0, sol.findContentChildren(g, s));
    }

    @Test
    void exactMatches() {
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 2, 3 };
        assertEquals(3, sol.findContentChildren(g, s));
    }
}
