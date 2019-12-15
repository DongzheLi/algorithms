# BSTs

Depth: We define the depth of a node as how far it is from the root. Root has depth 0.

Height: Height of a tree is the depth of the deepest node.

# B-trees

We know 2-3 trees: A B-tree where each node has 2 or 3 children.

2-3-4 tree: B-tree where each node has 2,3 or 4 children.

Runtime of contains and add are both Theta(logN)

Height of a B-tree: Theta(logl(N)), where l is the limit of how many itmes a node can have.

# B-tree invariants

1. All leaves must be the same distance from the source
2. A non-leaf node with K items must have exactly k+1 children


# Problems

1. Draw 2-3 tree that results when you insert the keys A,B,C,D,E,F,G in order.