# 441. Arranging Coins

You have `n` coins and you want to build a staircase with these coins. The staircase consists of `k` rows where the i<sup>th</sup> row has exactly `i` coins. The last row of the staircase **may be** incomplete.

Given the integer `n`, *return the number of complete rows of the staircase you will build.*

 

#### Example 1:

<img src="arrangecoins1-grid.jpg" alt="hint" style="max-width: 100%; height: auto;"/>

>**Input:** n = 5  
**Output:** 2  
**Explanation:** Because the 3<sup>rd</sup> row is incomplete, we return 2.

#### Example 2:

<img src="arrangecoins2-grid.jpg" alt="hint" style="max-width: 100%; height: auto;"/>

>**Input:** n = 8  
**Output:** 3  
**Explanation:** Because the 4<sup>th</sup> row is incomplete, we return 3.
 

##### Constraints:

- 1 <= n <= 2<sup>31</sup> - 1