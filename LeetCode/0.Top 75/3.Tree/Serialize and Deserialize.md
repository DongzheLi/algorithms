# Serialize and Deserialize a BST

Example:

```
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as 
"[1,2,3,null,null,4,5]"
```

---

## Solution : Pre-Order Traversal

Preorder does : root->left subtree-> right subtree

Example:
```
    1
   / \
  2   3
     / \
    4   5

[1,2,#,#,3,4,#,#,5,#,#]
```

```java
public class Codec {
    // Serialize a tree to a single string
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // preorder traversal of a BST
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(String.valueOf(root.val));
            // some string formatting.
            sb.append(",")
            preorder(root.left, sb);
            preorder(root.right, sb);
        } else {
            // when it is null, we replace it with a #.
            sb.append('#');
            sb.append(',');
        }
    }

    // Decode(deserialize) a String back to BST.
    public TreeNode desrialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] values = data.split(",");

        Queue<String> queue = new LinkedList<String>(Arrays.asList(values));

        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        if (queue == null || queue.isEmpty()) return null;

        String value = queue.poll(); // queue.poll() returns and removes the element at the front of the container.

        if (value.equals('#')) return null;

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}
```