# Lowest common Ancestor

Given a BST, find the lowest common ancestor of two given nodes in the BST.

Example:

```
      6
    /   \
   2    8
 /  \  /  \
 0  4 7    9
   / \
  3   5
```

LCA(2, 8) = 6

LCA(2, 4) = 2

---

## Solution:

```java
/** Returns the lowest common ancestor of p and q in root. */
public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > root.val && q.val > root.val) return LCA(root.right, p, q);
    if (p.val < root.val && q.val < root.val) return LCA(root.left, p, q);
    return root;
}
```