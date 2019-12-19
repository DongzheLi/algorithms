public class RedBlackBST<Key extends Comparable<Key>, value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; // root of the BST
    private int n; // number of key-value pairs in BST

    // BST helaper node data type
    private class Node {
        private Key key;
        private Value val; // associated data
        private Node left, right; // links to left and right subtrees
        private boolean color; // color of parent link

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    /** Standard BST search */
    public Value get(Key key) {
        return get(root, key);
    }

    // Nothing is different, just stardard binary search.
    public Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.val;
        }
        return null;
    }

    // is there a key-value pair in the symbol table with the given key?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /** Red-black tree insertion */

    public void put(Key key, Value val) {
        root = insert(root, key, value);
        root.color = BLACK;
        assert check();
    }

    private Node insert(Node h, Key key, Value val) {
        if (h == null) {
            n++;
            return new Node(key, val, RED); // why first one has RED as parent link
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0)
            h.left = insert(h.left, key, val);
        if (cmp > 0)
            h.right = insert(h.right, key, val);
        else
            h.val = val;

        // fix up any right-leaning links
        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        return h;
    }

    /** Red-black tree helper functions. */
    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    // Rotate right
    private Node rotateRight(Node h) {
        assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // rotate left
    private Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // precondition: two children are red, node is black
    // postcondition: two children are black, node is red
    private void flipColors(Node h) {
        assert !isRed(h) && isRed(h.left) && isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}