# B-Trees

## BST Tree Height

Trees height range from best case "bushy" to worst-case "spindly".

Example:

![](./img/bstheight.png)

Let H(n) be the height of a tree with N nodes. Give H(N) in Big-Theta notation for "bushy" and "spindly" trees, 

H = Theta(logN) for bushy tree

H = Theta(N) for spindly tree

### Note: Big-O is not worst case

Example: Which of the these statements are true?

A. Worst case BST height is Theta(N).

B. BST height is O(N).

C. BST height is O(N^2).

All of above are true.

All BSTs have a height that grows linearly or better than O(N), so even better than O(N^2).

But only A have useful information.


In conclusion, BST height is : Theta(logN) in best case, Theta(N) in worst case.

## Height and Depth of a Tree

Height and average depth are important properties of BSTs.

+ The depth of a node is how far it is from the root. root has depth 0. e.g. depth(g) = 2
+ The height of a tree is the depth of its deepest leaf, e.g. height(T) = 4
+ The average depth of a tree is the average depth of all its nodes:
    
    + (0x1 + 1x2 + 2x4 + 3x6 + 4x1)/ (1+2+4+6+1) = 2.35
    
![](./img/treeheight.png)

## BST in practice.

The order of how we add elements result in different trees.

We want BSTs to be as bushy as possible.

### Randomized BSTs

It does give us expected average depth 4.7log(N) so, Theta(logN).

So we can have Theta(logN) insertion if we insert randomly,

But we can't always insert our items in a random order, why?

: Data comes in over time, we don't have all the data at once.


## B-trees/2-3 trees/ 2-3-4 trees

So how to keep a log(N) height?

### 1. Crazy idea 1: we just over-stuff the leaf nodes.

    
            13                                      13
         5      15      add(17), add(18)       5          15
       2   7  14  16                        2    7     14   (16,17,18)

    
### 2. 
  
