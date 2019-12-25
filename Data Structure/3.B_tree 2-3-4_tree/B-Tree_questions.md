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

```
insert(a),insert(b),insert(c)
                b
(a,b,c) -->  a     c

insert(d), insert(e)
    b             -->        (b, d)
a     (c,d,e)              a    c    e  

insert(f), insert(g)
    (b, d)         -->     (b, d, f)
 a    c    (e,f,g)       a   c   e   g

 -->     d
      b      f
    a   c  e   g
```

2. How many compares does it take in the worst case to decide whether to go left, middle, or gith from a 3 node ?

```
      (2,     9)
1        (3,7)    (11,13)
```

Worst case is : 2 comparisons.


3.  Question 5 in 2014 midterm2

 The following classes represent nodes in a 2-3-4 tree. In order to avoid having to handle leaf nodes specially(all of which are empty in a 2-4 trees), this representation uses a single leaf object (Node2_4.EMPTY) to represent all leaves (instead of the usual null value). 

```java
/** Represents a node in a 2-3-4 tree. There is only one 
 *  instance of this base class itslef, Node2_4.EMPTY, 
 *  representing the empty tree. */

class Node2_4 {
    /** The unique empty node. */
    final static Node2_4 EMPTY = new Node2_4();

    /** Return my Kth child (numbering from 0) */
    Node2_4 kid(int k) {/* Implementation not shown. */}

    /** Return the number of my children (which is one more than the number of my keys) */
    int arity() {/* Implementation not shown. */}

    /** Return my Kth key (numbering from 0) */
    String key(int k) {/* Implementation not shown. */}

    /** Return true iff KEY is a key in the tree rooted at me. */
    boolean contains(String key) {return false;}
}
```

question:

[soltuion link](http://www-inst.eecs.berkeley.edu/~cs61b/fa14/test-solutions/test2-soln.pdf)

```java
/** Represents non-empty nodes. Exam note: Java short-circuits
    conditions, e.g. if (true || b) doesnot evaluate b. */
class InnerNode2_4 extends Node2_4 {
    // look up keys in a tree
    @Override
    boolean contains(String key) {
        for (int k = 0; k <size() - 1; k += 1) {
            if (key(k).equals(key)) {
                return true;
            } else if (key(k).compareTo(key) > 0) {
                return kid(k).contains(key);
            }
        }
        return kid(size()-1).contains(key);
    }
}
```

### Question 1 c, e in spring 2018 Midterm 2

1. Draw the 2-3 tree that results from inserting 1,2,3,7,8,9,5

```
insert(1),insert(2),insert(3)
                2
(1,2,3) -->  1     3

insert(7), insert(8)
    2                       (2, 7)
1      (3,7,8)    -->     1    3    8

insert(9), insert(5)

    (2,     7)
1      (3,5)    (8,9)
```

2. Draw a valid BST of minimum height containing the keys

1,2,3,7,8,9,5

```
        5
    2       8
 1     3  7    9

``` 


### Question 8b is Spring 2016 midterm 2

In what order can we get this tree?

```
            4
    2              (6, 8)
1       3       5     7    9
```

Recognize that the final numbers inserted could be 8, 9

1,2,3,4,5,6,7,8,9 works