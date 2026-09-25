# 653. Two Sum IV - Input is a BST

Given the `root` of a binary search tree and an integer `k`, return `true` *if there exist two elements in the BST such that their sum is equal to* `k`, *or* `false` *otherwise*.

 

#### Example 1:

<img src="sum_tree_1.jpg" alt="hint" style="max-width: 100%; height: auto;"/>

>**Input:** root = [5,3,6,2,4,null,7], k = 9  
**Output:** true

#### Example 2:

<img src="sum_tree_2.jpg" alt="hint" style="max-width: 100%; height: auto;"/>

>**Input:** root = [5,3,6,2,4,null,7], k = 28  
**Output:** false
 

#####Constraints:

- The number of nodes in the tree is in the range [1, 10<sup>4</sup>].
- -10<sup>4</sup> <= Node.val <= 10<sup>4</sup>
- root is guaranteed to be a valid binary search tree.
- -10<sup>5</sup> <= k <= 10<sup>5</sup>