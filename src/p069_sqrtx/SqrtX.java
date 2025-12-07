package p069_sqrtx;

class SqrtX {
	static int mySqrt(int x) {
		if (x == 0) {
			return 0; // The square root of 0 is 0
		}

		int start = 1, end = x, result = 0;

		while (start <= end) {
			int mid = start + (end - start) / 2; // Prevents overflow

			if (mid <= x / mid) { // Avoid overflow by dividing x by mid
				result = mid; // mid is a potential answer
				start = mid + 1; // Move to the right half to find a closer result
			} else {
				end = mid - 1; // Move to the left half
			}
		}

		return result;
	}

}
