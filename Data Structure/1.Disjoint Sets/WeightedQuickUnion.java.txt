package Chapter1.Section5;

/**
 * There are two approaches to weighted quick union, this is one of them,
 *  sets: {0, 1, 2, 3, 4, 5}, {6, 7, 8}, {8, 9}
 *  int[] parent: [-1, 0, 0, 0, 0, 0, -1, 6, 6, 8]
 *  int[] size:   [ 6, 1, 1, 1, 1, 1,  4, 1, 2, 1]
 *
 *  The other approach: there is only one array, root has the -weight as its value, other elements has their parent as value
 *  int[] parent: [-6, 0, 0, 0, 0, 0, -4, 6, 6, 8]
 */
public class WeightedQuickUnion implements UF{
    private int[] parent;       // parent link (site indexed)
    private int[] sz;       // size of component for roots (site indexed)
    private int count;      // number of components

    public WeightedQuickUnion(int N) {
        count = N;
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) return;

        // Make smaller root joint to larger one.
        if (sz[i] < sz[j]) {
            parent[i] = j;          // Change i's value to q's root.
            sz[j] += sz[i];     // Increase j's component's size by i's component's size.
        } else {
            parent[j] = i;
            sz[i] += sz[j];
        }

        count--;                // There is one less components now.
    }

    @Override
    public int find(int p) {
        // Follow links to find a root.
        while (p != parent[p]) p = parent[p];
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {return count;}
}
