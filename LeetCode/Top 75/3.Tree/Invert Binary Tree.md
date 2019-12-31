# Invert Binary Tree

Invert a binary tree.

---

Example:

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9

Becomes

     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    if (root.left == null && root.right == null) return root;
    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);
    return root;
}
```

Or

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    if (root.left == null && root.right == null) return root;
        
    TreeNode newLeft = invertTree(root.right);
    TreeNode newRight = invertTree(root.left);
    root.left = newLeft;
    root.right = newRight;
    return root;
}
```