# 258. Add Digits


Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.


#### Example 1:

> **Input:** num = 38  
**Output:** 2  
**Explanation:** The process is  
38 --> 3 + 8 --> 11  
11 --> 1 + 1 --> 2   
Since 2 has only one digit, return it.

#### Example 2:

> **Input:** num = 0  
**Output:** 0
 

##### Constraints:

- 0 <= num <= 2<sup>31</sup> - 1
 

**Follow up:** Could you do it without any loop/recursion in `O(1)` runtime?

**Hint 1**  
A naive implementation of the above process is trivial. Could you come up with other methods?  
**Hint 2**  
What are all the possible results?  
**Hint 3**  
How do they occur, periodically or randomly?  
**Hint 4**  
You may find this [Wikipedia](https://en.wikipedia.org/wiki/Digital_root) article useful.