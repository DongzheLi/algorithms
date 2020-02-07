# Kth Smallest Element in a BST

Given a binary search tree, write a function to find the kth smallest element in it.

---

Example:

```
k = 1
   3
  / \
 1   4
  \
   2
Output: 1

k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
```

## Solution 1: Inorder traversal, recursion

```java
class Solution {
    List<Intege> ls = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return ls.get(k - 1);
    }
    /** Inorder traversal outputs the list that in sorted order. */
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left, ls);
            ls.add(root.val);
            inorder(root.right, ls);
        }       
    }
}
```

## Solution 2: Iteration

```java
public int kthSmallest(TreeNode root, int k) {
    // use a stack to trakc the ordering of inorder traversal
    Deque<Integer> stack = new ArrayDeque<Integer>();

    while (true) {
        while (root != null) {
            stack.addLast(root);
            root = root.left;
        }
        root = stack.removeLast();
        k = k -1;
        if (k == 0) return root.val;
        root = root.right;
    }
}
```