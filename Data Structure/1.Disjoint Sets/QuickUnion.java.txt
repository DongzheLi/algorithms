package Chapter1.Section5;

/**
 * id[] entry for each site is the name of another site in the same component(possibly itself)
 * idea: for every index p, id[p], its value is its link, we keep following the link,
 * until we find the root, which is the one such that p = id[p].
 * so we when do find, we find its root, that is the component it belongs to
 * union(p, q), is quick, we just need to see if they have the same root, if not,
 * change p's root to q's root.
 */
public class QuickUnion implements UF{
    private int[] id;       // access to component id(site indexed)
    private int count;      // number of components

    public QuickUnion(int N) {
        // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {       // id = [0,1,2,3,...,N-1]
            id[i] = i;
        }
    }

    @Override
    public int count() {return count;}

    @Override
    public boolean connected(int p, int q) {return find(p) == find(q);}

    @Override
    public int find(int p) {
        // Find component name.
        while (p != id[p]) {    // the root are the ones p = id[p].
            p = id[p];          // in this algorithm, we keep following the link, until we find the root.
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        // find makes union easier, we only need to change p and q.

        // Give p and q the same root.
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;      // change p's root to q's root

        count --;
    }
}
