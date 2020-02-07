# Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree

A tree is a BST if and only if:

    + the left tree only contains nodes less than the node's val
    + the right tree only contains nodes larger than the node's val
    + Bothe left and right subtree must also be BST.

## Solution 1: Recursion

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode node, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && node.val) <= min && (max != null && node.val >= max)) return false;
        // for left subtree, node.val is its upper bound, for right subtree, node.val is its lower bound.
        return isValid(node.left, min, root.val) && isValid(node.right, root.val, max);
    }
}
```