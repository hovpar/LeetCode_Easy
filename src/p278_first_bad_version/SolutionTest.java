package p278_first_bad_version;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    static class TestSolution extends Solution {
        private final int firstBad;

        TestSolution(int firstBad) {
            this.firstBad = firstBad;
        }

        @Override
        boolean isBadVersion(int version) {
            return version >= firstBad;
        }
    }

    @Test
    void firstBadInMiddle() {
        Solution s = new TestSolution(4);
        assertEquals(4, s.firstBadVersion(10));
    }

    @Test
    void firstBadIsFirstVersion() {
        Solution s = new TestSolution(1);
        assertEquals(1, s.firstBadVersion(5));
    }

    @Test
    void firstBadIsLastVersion() {
        Solution s = new TestSolution(10);
        assertEquals(10, s.firstBadVersion(10));
    }

    @Test
    void singleVersionBad() {
        Solution s = new TestSolution(1);
        assertEquals(1, s.firstBadVersion(1));
    }

}
