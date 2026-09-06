package p598_range_addition_ii;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRows = m;
        int minColumns = n;
        //        for (int i = 0; i < ops.length; i++) {
        //            int rows = ops[i][0];
        //            int columns = ops[i][1];
        //
        //            minRows = Math.min(minRows, rows);
        //            minColumns = Math.min(minColumns, columns);
        //        }
        //or just
        for (int[] operation : ops) {
            int rows = operation[0];
            int columns = operation[1];

            minRows = Math.min(minRows, rows);
            minColumns = Math.min(minColumns, columns);
        }
        return minRows * minColumns;
    }
}
