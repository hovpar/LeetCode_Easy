package p657_robot_return_to_origin;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnToOriginWithOppositeMoves() {
        assertTrue(s.judgeCircle("UD"));
        assertTrue(s.judgeCircle("LR"));
    }

    @Test
    void shouldReturnToOriginWhenMovesCancelOut() {
        assertTrue(s.judgeCircle("UUDD"));
        assertTrue(s.judgeCircle("LLRR"));
        assertTrue(s.judgeCircle("UDLR"));
    }

    @Test
    void shouldReturnFalseWhenRobotDoesNotReturnToOrigin() {
        assertFalse(s.judgeCircle("U"));
        assertFalse(s.judgeCircle("R"));
        assertFalse(s.judgeCircle("UU"));
        assertFalse(s.judgeCircle("RR"));
    }

    @Test
    void shouldHandleEmptyMoves() {
        assertTrue(s.judgeCircle(""));
    }

    @Test
    void shouldHandleLongerSequence() {
        assertTrue(s.judgeCircle("UDUDLRLR"));
    }

    @Test
    void shouldReturnFalseWhenOnlyOneDirectionIsUsed() {
        assertFalse(s.judgeCircle("UUU"));
        assertFalse(s.judgeCircle("DDD"));
        assertFalse(s.judgeCircle("LLL"));
        assertFalse(s.judgeCircle("RRR"));
    }

}
