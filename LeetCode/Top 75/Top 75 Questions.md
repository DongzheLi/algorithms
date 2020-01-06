## Array

### HashMap or HashSet

+ [Two Sum](https://leetcode.com/problems/two-sum/) : [HashMap : (key, value) = (element, its index)](1.Array/Two&#32;Sum.md)
+ [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)[HashMap, HashSet to count frequency](1.Array/Contains&#32;Duplicate.md)
+ [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) : [just maturity in writing code](1.Array/Product&#32;of&#32;Array&#32;Ecept&#32;Self.md)

### Local maximal to Global maximal

+ [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) : [local maximal lead to global maximal](1.Array/Buy&#32;and&#32;Sell&#32;Stock.md)
+ [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) : [Find right variable to keep track, local maximal lead to global maximal](1.Array/Maximum&#32;Subarray.md)


### Binary Search

+ [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) : [Binary Search, CTCI has better questions in this topic](1.Array/Find&#32;Mininum&#32;in&#32;rotated&#32;array.md)
+ [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) : [Binary search](1.Array/Search&#32;in&#32;Rotated&#32;Array.md)


### Two pointer

+ [3Sum](https://leetcode.com/problems/3sum/): [Two pointers](1.Array/Three&#32;Sum.md)
+ [Container With Most Water](https://leetcode.com/problems/container-with-most-water/): [Two pointer](1.Array/Container&#32;with&#32;most&#32;water.md)


---


## String

### Sliding windows:

- [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) : [Sliding window](2.Strings/Longest&#32;Substring&#32;Without&#32;Repeating&#32;Characters.md)
- [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/): [Sliding Window](2.Strings/Longest&#32;Repeating&#32;Character&#32;Replacement.md)

### HashMap for frequency table ( int[126] ):

- [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/):[Sliding window, use HashMap to keep frequency of occurence](2.Strings/Minimum&#32;Window&#32;Substring.md)
- [Valid Anagram](https://leetcode.com/problems/valid-anagram/): [HashMap for frequency-count table, int array for ASCII count](2.Strings/Valid&#32;Anagram.md)
- [Group Anagrams](https://leetcode.com/problems/group-anagrams/):[turn string into char array, turn char array back to string](2.Strings/Group&#32;Anagrams.md)

### Stack:

- [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/):[Use stack to track parentheses](2.Strings/Valid&#32;Parentheses.md)

### Palindrome, two pointers:

- [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/): [Two pointers, one from start ,one from end](2.Strings/Valid&#32;Palindrome.md)
- [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/): [Expand from middle to check for palindromic substring](2.Strings/Longest&#32;Palindromic&#32;Substring.md)
- [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/) : [Expand from middle to check for odd even case palindrome](2.Strings/Palindromic&#32;Substrings.md)
- [Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/)


---

## Tree

### Tree Recursion

- [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) :[Classic Tree Recursion](3.Tree/Maximum&#32;Depth&#32;of&#32;Binary&#32;Tree.md)
- [Same Tree](https://leetcode.com/problems/same-tree/):[Work out a recursive definition and follow that](3.Tree/Same&#32;Tree.md)
- [Invert/Flip Binary Tree](https://leetcode.com/problems/invert-binary-tree/) : [Write recursion according to defintion](3.Tree/Invert&#32;Binary&#32;Tree.md)
- [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/) : [Another classic tree recursion](3.Tree/Subtree&#32;of&#32;another&#32;tree.md)
- [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) :[Tree recursion](3.Tree/Subtree&#32;of&#32;another&#32;tree.md)
- [Lowest Common Ancestor of BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) : [Recursion](3.Tree/Lowest&#32;common&#32;ancestor.md)
- [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) : [Very difficult question](3.Tree/Binary&#32;Tree&#32;Maximum&#32;Path&#32;Sum.md)


### Tree Traversal

- [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) :[Preorder, inorder traversal]
- [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) :[Preorder or inorder traversal](3.Tree/Serialize&#32;and&#32;Deserialize.md)
- [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) :[Inorder traversal](3.Tree/Kth&#32;Smallest&#32;element.md)
- [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) : [Use queue(stack) to do levelorder traversal](3.Tree/Level&#32;Order&#32;Travel.md)
  

### Trie

- [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/) : [Trie from cs61b](../../Data&#32;Structure/6.Tries/Trie&#32;Set/MyTrieSet.java)
- [Add and Search Word](https://leetcode.com/problems/add-and-search-word-data-structure-design/) :[Use trie](3.Tree/Add&#32;and&#32;Search&#32;Word.md)
- [Word Search II](https://leetcode.com/problems/word-search-ii/) : [Very difficult](3.Tree/Word&#32;Search.md)

---

## Dynamic Programming

- [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) : [Easy memorized recursion](4.DP/Climbing&#32;Stairs.md)
- [Coin Change](https://leetcode.com/problems/coin-change/) : [Classic DP, memoarized recursion, slightly more complex code](4.DP/Coin&#32;Change.md)
- [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) : [Super good question, a bit too hard, but very instructional](4.DP/Longest&#32;Increasing&#32;Subsequence.md)
- [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) : [Another very instructional solution, find out the induction trick -> recursion -> recursion with memo -> dp](4.DP/Longest&#32;Common&#32;Subsequence.md)
- [Word Break Problem](https://leetcode.com/problems/word-break/)
- [Combination Sum](https://leetcode.com/problems/combination-sum-iv/)
- [House Robber](https://leetcode.com/problems/house-robber/)
- [House Robber II](https://leetcode.com/problems/house-robber-ii/)
- [Decode Ways](https://leetcode.com/problems/decode-ways/)
- [Unique Paths](https://leetcode.com/problems/unique-paths/)
- [Jump Game](https://leetcode.com/problems/jump-game/)


---




## Linked List

- [Reverse a Linked List](https://leetcode.com/problems/reverse-linked-list/)
- [Detect Cycle in a Linked List](https://leetcode.com/problems/linked-list-cycle/)
- [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- [Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [Remove Nth Node From End Of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
- [Reorder List](https://leetcode.com/problems/reorder-list/)



---



## Heap

- [Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

---

## Graph

- [Clone Graph](https://leetcode.com/problems/clone-graph/)
- [Course Schedule](https://leetcode.com/problems/course-schedule/)
- [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)
- [Number of Islands](https://leetcode.com/problems/number-of-islands/)
- [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
- [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/)
- [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)
- [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)

---

## Interval

- [Insert Interval](https://leetcode.com/problems/insert-interval/)
- [Merge Intervals](https://leetcode.com/problems/merge-intervals/)
- [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
- [Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
- [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)

---

## Binary

- [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/)
- [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
- [Counting Bits](https://leetcode.com/problems/counting-bits/)
- [Missing Number](https://leetcode.com/problems/missing-number/)
- [Reverse Bits](https://leetcode.com/problems/reverse-bits/)

---

## Matrix

- [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)
- [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)
- [Rotate Image](https://leetcode.com/problems/rotate-image/)
- [Word Search](https://leetcode.com/problems/word-search/)



