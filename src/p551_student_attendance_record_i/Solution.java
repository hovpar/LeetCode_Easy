package p551_student_attendance_record_i;

class Solution {

    public boolean checkRecord(String s) {
        int absences = 0;
        int consecutiveLates = 0;

        for (char status : s.toCharArray()) {
            if (status == 'A') {
                absences++;
            }

            if (status == 'L') {
                consecutiveLates++;
            } else {
                consecutiveLates = 0;
            }

            if (absences >= 2 || consecutiveLates >= 3) {
                return false;
            }
        }

        return true;
    }

}
