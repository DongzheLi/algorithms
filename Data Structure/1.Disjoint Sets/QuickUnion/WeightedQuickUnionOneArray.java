package Chapter1.Section5;

public class WeightedQuickUnionOneArray {
    // instance variables
    private int[] parent;       // int[i] is i's parent, if i is a root, int[i] = - (number of elements) in the site i belongs to.

    // Create a UnionFind data structure holding n vertices.
    // Initially, all vertices are in disjoint sets
    public WeightedQuickUnionOneArray(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++ ) {
            parent[i] = -1;     // initialize parent to: [-1, -1, -1,...]
        }
    }

    // Throws an exception if v1 is not a valid index.
    public void validate(int v1) {
        if (v1 < 0 || v1 >= parent.length) {
            throw new IllegalArgumentException("Invalid vertex");
        }
    }

    // Returns the size of the set v1 belongs to.
    public int sizeOf(int v1) {
        validate(v1);
        return -parent(find(v1));   // Find v1's root, and return -parent[root], that is the size of set v1 belongs to.
    }

    // Returns the parent of v1.
    // If v1 is a root of a tree, returns the negative size of the tree for which v1 is the root.
    public int parent(int v1) {
        validate(v1);
        return parent[v1];
    }

    // Returns true if vertices v1 and v2 are connected.
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    // Connects two vertices v1 and v2 together.
    // if sizes of the sets are equal, connect v1's root to v2's root.
    // Weighted union: union the smaller set to the larger set.
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);

        if (!connected(v1, v2)) {
            if (sizeOf(v1) > sizeOf(v2)) {          // connect v2 to v1.
                parent[find(v1)] -= sizeOf(v2);     // Update parent[v1's root], sizeOf(v1) by sizeOf(v2).
                parent[find(v2)] = find(v1);        // Update v2-root's parent to be v1's root.
            }
            else {                                  // connect v1 to v2
                parent[find(v2)] -= sizeOf(v1);
                parent[find(v1)] = find(v2);
            }
        }
    }

    // Returns the root of the set v1 belongs to.
    // Returns -1 if v1 is by itself.
    // Path-compression for fast search-time.
    public int find(int v1) {
        validate(v1);
        int root = v1;
        while (root > -1) {
            root = parent[root];
        }
        while (v1 != root) {          // path compression: on our path to root
            int newV1 = parent[v1];   // change parent[parent(v1)] to root, we flatten the tree.
            parent[newV1] = root;     // we traverse from p to root, and change every parent in between, their value to p's root.
            v1 = newV1;
        }
        return root;
    }
}
