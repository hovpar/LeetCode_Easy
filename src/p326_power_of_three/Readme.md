# 326. Power of Three

Given an integer `n`, return `true` if it is a power of three. Otherwise, return `false`.

An integer n is a power of three, if there exists an integer x such that n == 3<sup>x</sup>.

 

#### Example 1:

>**Input:** n = 27  
**Output:** true  
**Explanation:** 27 = 3<sup>3</sup>

#### Example 2:

>**Input:** n = 0  
**Output:** false  
**Explanation:** There is no x where 3<sup>x</sup> = 0.

#### Example 3:

>**Input:** n = -1  
**Output:** false  
**Explanation:** There is no x where 3<sup>x</sup> = (-1).
 

##### Constraints:

- -2<sup>31</sup> <= n <= 2<sup>31</sup> - 1
 

**Follow up:** Could you solve it without loops/recursion?