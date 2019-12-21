# Postorder

![](img/treeexample.png)

Postorder: Traverse left, Traverse right, then visit the node:

A C B E G F D

    ```java
    postOrder(BSTNode x) {
        if (x == null) return;
        postOrder(x.left);
        postOrder(x.right);
        print(x.key);
    }
    ```

## Solution 1: Recursion 

```java
public List<Integer> postorder(TreeNode root) {
    if (root == null) return;
    List<Integer> result = new ArrayList<>();
    postorder(root.left);
    postorder(root.right);
    result.add(root.val);

    return result;
}
```


## Solution 2: Iteration

```java
public List<Integer> postorder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
        if (p != null) {
            stack.push(p);
            result.addFirst(p.val); 
            p = p.right;
        } else {
            TreeNode node = stack.pop();
            p = node.left;
        }
    }
    return result;
}
```