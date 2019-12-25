package Sets_Maps_BST;

/**
 * I dont know about this one man.
 */
public class MergeRight {
    /**
     * Assume that T and L are bst each with a single sentinel node, and that all left children in L
     * aside from the sentinel are empty, i.e. L is "right-leaning", returns (the sentinel of) a binary
     * tree containing the original elements of T and L.
     */
    public static IntTree mergeRight(IntTree T, IntTree L) {
        T.left = mergeRight(T.left, Integer.MAX_VALUE, L);
        return T;
    }

    /**
     * Assume T is a BST, L is the sentinel of a right-leaning BST,
     * Return the result of inserting all items of L that are <= NEXT in T,
     * And remove them from L.
     */
    public static IntTree mergeRight(IntTree T, int next, IntTree L) {
        // T and L.left are the actual trees.
        if (L.left == null) return T;       // we are done, there is nothing to add to T.

        if (T == null) {
            if (L.left.data <= next) {
                IntTree p = L.left;
                L.left = L.left.right;
                p.right = mergeRight(null, next, L);
                return p;
            }
        } else {
            if (L.left.data <= T.data)
                T.left = mergeRight(T.left, T.data, L);
            if (L.left != null && L.left.data > T.data)
                T.right = mergeRight(T.right, next, L);
            return T;
        }
        return T;   // this line is unnecessary.
    }

    private class IntTree {
        public final int data;
        public IntTree left, right;

        public IntTree(int data, IntTree left, IntTree right) {
            this.data = data; this.left = left; this.right = right;
        }
    }
}