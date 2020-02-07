# Subtree of Another Tree

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.

s is a subtree of s.

---

Example:

```
s:
     3
    / \
   4   5
  / \
 1   2
t:
   4 
  / \
 1   2
```

## Solution 1:

```java
/** Just need to check if t is a subtree of s. */
public boolean isSubtree(TreeNode s, TreeNode t) {
    if (t == null) return true;
    if (s == null) return false;
    return isSubtree(s.left, t) || isSubtree(s.right, t) || isSametree(s, t);
}

public boolean isSametree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return  true;
    if (p == null || q == null) return false;
    if (q.val != q.val)         return false;

    return isSametree(p.left, q.left) && isSametree(p.right, q.right);
}
```