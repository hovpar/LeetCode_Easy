package p070_climbing_stairs;

class ClimbingStairs {
	
	static int climbStairs(int n) {
		var memo = new Integer[n+1];
		return climbStairs(memo, n);
	}

	private static int climbStairs(Integer[] memo, int n) {
		if(n==1) {
			return 1;
		}
		else if (n == 2) {
			return 2;
		} else {
			if (memo[n] == null) {
				memo[n] = climbStairs(memo, n - 1) + climbStairs(memo, n - 2);
			}
			return memo[n];

		}
	}
}
