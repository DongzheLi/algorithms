# Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values.

---

Example:

Given binary tree [3,9,20,null,null, 15, 7]

```
    3
   / \
  9  20
    /  \
   15   7
```

Returns 

```
[
  [3],
  [9,20],
  [15,7]
]
```

## Solution 1: Recursion

```java
class Solution {
    // instance variable to store returned results
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode node, int level) {
        // current level, add a new empty List
        if (levels.size() == level) levels.add(new ArrayList<Integer>());
        // put current node.val into its level List
        levels.get(level).add(node.val);
        // process its left, right children in next level
        if (node.left != null)  helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }
}
```

## Solution 2: Iteration with a Queue

```java
public List<List<Integer>> levelorder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();

    if (root == null) return levels;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    int level = 0;
    while (!queue.isEmpty()) {
        levels.add(new ArrayList<Integer>());

        int levelLength = queue.size();
        for (int i = 0; i < levelLength; i++) {
            TreeNode node = queue.remove();

            levels.get(level).add(node.val);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        level++;
    }
    return levels;
}
```
