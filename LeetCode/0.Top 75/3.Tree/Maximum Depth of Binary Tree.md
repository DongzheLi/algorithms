# Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the path from the root node down to the farthest leaf node.

A leaf is a node with no children.

Example:

```
    3
   / \
  9  20
    /  \
   15   7
```

Maximum depth = 3


---

## Solution : Recursion

```java
public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
```