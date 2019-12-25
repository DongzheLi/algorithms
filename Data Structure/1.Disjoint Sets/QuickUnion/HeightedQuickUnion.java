package Chapter1.Section5;

public class HeightedQuickUnion implements UF{
    private int[] parent;       // parent[i] = parent of i
    private int[] height;       // height of subtree rooted at i
    private int count;          // number of components

    /**
     * Initializes an empty union-find data structure with
     * n elements from 0 to n-1.
     * Initially, each element is in its own set, thus, height is 0.
     * @param n the number of elements
     * @throws IllegalArgumentException if (n < 0)
     */
    public HeightedQuickUnion(int n) {
        count = n;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++ ) {
            parent[i] = i;
            height[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        // find root of p, find root of q
        int i = find(p);
        int j = find(q);

        if (i == j) return;

        // compare height, point shorter one'root to taller one
        // increase taller-one's height by one only when they have same height
        if (height[i] < height[j]) {
            parent[i] = j;
        } else if (height[i] > height[j]) {
            parent[j] = i;
        } else {    // point j's root to i, increase i's height by 1
            parent[j] = i;
            height[i] += 1;
        }
    }

    /**
     * Returns the root element of the set containing element p.
     * Note: an element i is root if and only if parent[i] == i.
     * @param p an element
     * @return the root element of the set containing p
     * @throws IllegalArgumentException unless (0<=p<n)
     */
    @Override
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * Returns true if p and q are in the same set.
     * @param p one element
     * @param q other element
     * @return true if p and q are in the same set;
     *         false othersie
     * @throws IllegalArgumentException unless both (0 <= p < n)
     *                                         and  (0 <= q < n)
     */
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Returns the number of sets.
     * @return the number of sets (between 1 and n)
     */
    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) throw new IllegalArgumentException();
    }
}
