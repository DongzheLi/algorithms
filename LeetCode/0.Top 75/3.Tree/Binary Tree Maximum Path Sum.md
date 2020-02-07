# Binary Tree Maximum Path sum

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections, the path must contain at least one node and does not need to go through the root.


---

Example:

```java

    1
   / \
  2   3

Output: 2 + 1 + 3 = 6

   -10
   / \
  9  20
    /  \
   15   7
Output: 15 + 20 + 7 = 42
```

# Solution 1:

```java
class Solution {
    int maxSum = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0; 
        pathSum(root);
        return maxSum;
    }
    private int pathSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));
        
        maxSum = Math.max(maxSum, root.val + left + right);
        return Math.max(left, right) + node.val;
    }
}
```

Recursion tree of this algorithm:

```
   -10
   / \
  9  20
    /  \
   15   7

            f(-10) = 32
            /   \
     f(9) = 9   f(20) = 42
          /  \   / \
          0  0 f(15) f(7)
                /  \
               0   0
```