package Chapter1.Section5;

public class WeightedQuickUnionPathCompression implements UF {
    private int[] parent;       // id[i] = parent of i
    private int[] size;         // size[i] = numbers of sites in tree rooted at i
    private int count;          // number of components

    public WeightedQuickUnionPathCompression(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = N;
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (p != root) {         // path compression happens
            int newp = parent[p];   // as we found the root
            parent[p] = root;       // we traverse from p to root, and change every parent in between's root to p's root
            p = newp;
        }
        return root;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
