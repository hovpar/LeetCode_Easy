package p551_student_attendance_record_i;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void shouldReturnTrueForValidRecord() {
        assertTrue(solution.checkRecord("PPALLP"));
    }

    @Test
    void shouldReturnFalseForThreeConsecutiveLates() {
        assertFalse(solution.checkRecord("PPALLL"));
    }

    @Test
    void shouldReturnFalseForTwoAbsences() {
        assertFalse(solution.checkRecord("APPA"));
    }

    @Test
    void shouldReturnFalseForNonConsecutiveAbsences() {
        assertFalse(solution.checkRecord("ALPLPA"));
    }

    @Test
    void shouldReturnTrueForExactlyOneAbsence() {
        assertTrue(solution.checkRecord("PPAPPP"));
    }

    @Test
    void shouldReturnTrueForTwoConsecutiveLates() {
        assertTrue(solution.checkRecord("PPLLPP"));
    }

    @Test
    void shouldReturnTrueWhenLateStreakIsInterruptedByPresent() {
        assertTrue(solution.checkRecord("LLPLL"));
    }

    @Test
    void shouldReturnTrueWhenLateStreakIsInterruptedByAbsence() {
        assertTrue(solution.checkRecord("LLALL"));
    }

    @Test
    void shouldReturnFalseWhenRecordStartsWithThreeLates() {
        assertFalse(solution.checkRecord("LLLPP"));
    }

    @Test
    void shouldReturnFalseWhenRecordEndsWithThreeLates() {
        assertFalse(solution.checkRecord("PPLLL"));
    }

    @Test
    void shouldHandleSinglePresentDay() {
        assertTrue(solution.checkRecord("P"));
    }

    @Test
    void shouldHandleSingleAbsentDay() {
        assertTrue(solution.checkRecord("A"));
    }

    @Test
    void shouldHandleSingleLateDay() {
        assertTrue(solution.checkRecord("L"));
    }
}