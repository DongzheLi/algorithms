package Sets_Maps_BST;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    private Node root;                      // Initialize BST node

    private class Node {
        private            K key;           // sorted by key
        private          V value;           // node label is key-value pair, that is why it is a map(not a set)
        private Node left, right;           // binary tree
        private int         size;

        /**
         * Constructor for Node.
         */
        public Node(K key, V value, int size) {
            this.key     = key;
            this.value = value;
            this.size   = size;
        }
    }

    /**
     * Initialize a BSTMap
     */
    public BSTMap(){}

    /**
     * Remove all mappings from this map.
     */
    @Override
    public void clear() { root = null; }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    /** Returns the value associated with the specified key in this map. */
    @Override
    public V get(K key) {
        return get(root, key);                      // call private helper method on Root node and given key
    }

    private V get(Node n, K key) {                  // utilize the fact that Node is a BST
        if (key == null) throw new IllegalArgumentException();
        if (n == null)   return null;

        // Compare key at n, with given key
        int cmp = key.compareTo(n.key);             // K extends Comparable<K>
        if      (cmp > 0) {                         // if key > n.key, search n.right
            return get(n.right, key);
        }
        else if (cmp < 0) {                         // if key < n.key, search n.left
            return get(n.left, key);
        }
        else return n.value;
    }


    /** Returns the number of key-value pairs in this map. */
    @Override
    public int size() {
        return root.size;
    }

    /** Associates the specified key with specified value in this map. */
    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException();
        root = put(key, value, root);
    }

    private Node put(K key, V value, Node n) {
        if (n == null) return new Node(key, value, 1);

        // Compare given key to n.key
        int cmp = key.compareTo(n.key);
        if      (cmp > 0) {
            n.right = put(key, value, n.right);
        }
        else if (cmp < 0) {
            n.left =   put(key, value, n.left);
        }
        else                   n.value = value;

        n.size = 1 + n.left.size + n.right.size;
        return n;
    }

    /** Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();        // Initialize an empty HashSet.
        for (int i = 0; i < size(); i++) {
            keys.add(select(i).key);
        }
        return keys;
    }

    /** Returns the node with (i+1)th smallest key in this map. */
    private Node select(int i) {
        if (i == 0 || i >=size()) throw new IllegalArgumentException();
        // (i+1)th because the index 0 is first smallest key.
        return select(i, root);
    }

    /** Returns the node with (i+1)th smallest key in the given node. */
    private Node select(int i, Node n) {
        if (n == null) return null;
        int left = n.left.size;
        // same as put, get method, select utilizes the fact size of n.left is
        // number of elements smaller than n.key.
        if      (i < left) {
            return select(i, n.left);
        }
        else if (i > left) {
            return select(i, n.right);
        }
        else return n;
    }

    /** Print key-value pair in order in this map */
    public void printInOrder() {
        for (int i = 0; i < size(); i++) {
            System.out.println(select(i).key + "," + select(i).value);
        }
    }

    @Override
    public V remove(K key) {
        if (!containsKey(key)) return null;
        V removed = get(key);
        root = remove(key, root);
        return removed;
    }

    @Override
    public V remove(K key, V value) {
        if (!containsKey(key)) return null;
        if (!get(key).equals(value)) return null;
        root = remove(key, root);
        return value;
    }

    /** Returns the Node which has the sub node with specified key removed. */
    private Node remove(K key, Node n) {
        if (n == null) return null;                             // return null if node is empty.

        int cmp = key.compareTo(n.key);                         // compare given key to node.key.

        if (cmp < 0) n.left = remove(key, n.left);
        else if (cmp > 0) n.right = remove(key, n.right);
        else {                                                  // cmp = 0, we are removing root.
            if (n.right == null)  return n.left;                // if one side is null,
            else if (n.left == null)  return n.right;           // we can just return the other side.
            // Neither left nor right are null.
            // assign root to temp, find the smallest node in right side, make that the new root.
            Node temp = n;                                      // assign root to temp.
            n = min(n.right);                                   // find the smallest node in right side, make it the new root.
            n.right = deleteMin(temp.right);                    // remove minimal node from right side.
            n.left = temp.left;                                 // no change to left side.
        }
        n.size = n.left.size + n.right.size + 1;
        return n;
    }

    /** Returns the minimal node in given node. */
    private Node min(Node n) {
        if (n.left == null) return n;
        return min(n.left);
    }

    /** Returns the node after deleting the minimal node. */
    private Node deleteMin(Node n) {
        if (n.left == null) return n.right;                     // if n.left is null, then n is the minimal node, delete that.
        // n.left is not null, minimal node is in left.
        n.left = deleteMin(n.left);
        n.size = n.left.size + n.right.size + 1;
        return n;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTIterator(root);
    }

    /** Private class for BSTMap Iterator */
    private class BSTIterator implements Iterator<K> {
        private Stack<Node> stack = new Stack<>();

        /** Constructor for BSTIterator */
        public BSTIterator(Node n) {
            while (n != null) {
                stack.push(n);
                n = n.left;
            }
        }
        @Override
        public boolean hasNext() {return !stack.isEmpty();}

        @Override
        public K next() {
            Node curr = stack.pop();

            if (curr.right != null) {
                Node temp = curr.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return curr.key;
        }
    }
}
