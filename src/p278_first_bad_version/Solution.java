package p278_first_bad_version;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

class Solution extends VersionControl {
    // Binary search approach
    public int firstBadVersion(int n) {

        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

}
