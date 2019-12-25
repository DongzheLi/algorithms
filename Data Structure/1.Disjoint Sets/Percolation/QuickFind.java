package Chapter1.Section5;

public class QuickFind implements UF {
    private int[] id;       // access to component id(site indexed)
    private int count;      // number of components

    // Initialize N sites with integer names from 0 to N -1.
    public QuickFind(int N) {
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
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        // put p and q in the same component.
        int pID = find(p);
        int qID = find(q);

        // do nothing if p and q are already in the same component.
        if (pID == qID) return;

        // rename p's component to q's name. (could change q's component, the choice is arbitrary)
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count = count - 1;      // there is one less components now.
    }
}
