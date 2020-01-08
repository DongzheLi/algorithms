# Trees

- Tree Traversal

  - Depth First Search

    - [Pre order traversal](<../../Data Structure/8.Tree Traversals/Preorder.md>)

    - [In order traversal](<../../Data Structure/8.Tree Traversals/Inorder.md>)

    - [Post order traversal](<../../Data Structure/8.Tree Traversals/Postorder.md>)

- Breadth First Search

  - [Level order traversal](<../../Data Structure/8.Tree Traversals/Levelorder.md>)

* Binary Heaps(Min-Heaps and Max-Heaps)

* Tries (Prefix Trees)

# Graphs

- Graphs

- Grapsh Search

  - Depth-first Search : pseudocode

    ```java
    void search(Node root) {
        if (root == null) return;
        visit(root);
        root.visited = true;
        for each (Node n in root.neighbors) {
            if n.visited == false :
                search(n);
        }
    }
    ```

  - Breadth-first Search : Use a Queue, its not recursive

    ```java
    void search(Node root) {
        Queue queue = new Queue();
        root.marked = true;
        queue.enqueue(root);    // add root to the queue

        while (!queue.isEmpty()) {
            Node r = queue.dequeue();
            visit(r);   // do whatever
            for (Node n: root.neighor) {
                if n.marked == false {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
        }
    }
    ```

# Questions

Graph:

1. [Path between two Nodes](Questions/1.Path&#32;between&#32;two&#32;Nodes.md) : BST or DFS

7. [Build Order](Questions/7.BuildOrder.md) : DFS or BFS to perform Topological sort

Trees:

2. [Minimal Tree](Questions/2.MinimalTree.md)

3. [Level Order Traversal](Questions/3.LevelOrderTraversal.md)

4. [Check Balanced](Questions/4.CheckBalanced.md)

5. [Validate BST](Questions/5.ValidateBST.md)

6. [Inorder Successor](Questions/6.InorderSuccessor.md)

8. [First Common Ancestor](Questions/8.FirstCommonAncestor.md)

9. [BST Sequences](Questions/9.BSTsequences.md)

10. [Check Subtree](Questions/10.Check&#32;Subtree.md)

11. [Paths with Sum](Questions/12.PathsWithSum.md)
