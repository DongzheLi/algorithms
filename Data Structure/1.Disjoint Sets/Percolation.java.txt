package Chapter1.Section5;
// supports 3 opertions:
// void union(int p, int q): Union two items
// boolean connected(int p, int q)
// int find(int p): Returns set number of a given item.
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // Instance variables
    private boolean[][] grid;                       // record each site's openness, true if open.
    private WeightedQuickUnionUF uf;                // record connectedness of each site, this is 1-D.
    private WeightedQuickUnionUF ufExcludeBottom;   // Avoid backwash
    private int[][] neighbours = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1,0}};
    private int top;                                // virtual top
    private int bottom;                             // virtual bottom
    private int numOpenSites;                       // number of open sites
    private int size;                               // size of each row(column)

    /**
     * Creates a N-by-N grid, with all sites initially blocked
     */
    public Percolation(int N) {                      // e.g N = 3
        grid = new boolean[N][N];                    // grid = {{false, false, false},
                                                     //         {false, false, false},
                                                     //         {false, false, false}}
        uf = new WeightedQuickUnionUF(N*N + 2);   // uf has N*N sites + virtual top + virtual bottom
                                                     // uf = {0=top, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10=bottom}
        ufExcludeBottom = new WeightedQuickUnionUF(N*N + 1);

        top = 0;
        bottom = N * N + 1;
        size = N;
    }

    /**
     * Returns the 1D representation in uf given (row, col) in grid.
     * grid(row, col) => uf(1D)
     */
    private int xyTo1D(int row, int col) {          // 0 is the virtual top
        return row * size + col + 1;                // (0,0)->1, (0,1)->2,(1,2)->6
    }

    /**
     * Throws IndexOutOfBoundsException if not (0<=row<size) and (0<=col<size).
     */
    private void validate(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Open the site (row, col) if it is not open already
     */
    public void open(int row, int col) {
        validate(row, col);

        if (isOpen(row, col)) {                 // return if it's already open
            return;
        } else {                                // else open site(row, col)
            grid[row][col] = true;
            numOpenSites += 1;

            if (row == 0) {
                uf.union(xyTo1D(row, col), top);                // connect to virtual top, if site is in first(top) row
                ufExcludeBottom.union(xyTo1D(row, col), top);
            }
            if (row == size -1) {                               // site in last row(bottom)
                uf.union(xyTo1D(row, col), bottom);             // connect to virtual bottom
            }
        }

        // If any of the neighbours(top, right, bottom, left) exists and is open, connect them.
        if (col + 1 < size && isOpen(row, col + 1)) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col + 1));// connect site to right-neighbour
            ufExcludeBottom.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }
        if (col -1 >= 0 && isOpen(row, col -1)) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col - 1));   //Connect(site, left-neighbour)
            ufExcludeBottom.union(xyTo1D(row, col), xyTo1D(row, col -1));
        }
        if (row + 1 < size && isOpen(row + 1, col)) {
            uf.union(xyTo1D(row,col), xyTo1D(row + 1, col));    //Connect(site, bottom-neighbour)
            ufExcludeBottom.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        if (row -1 >= 0 && isOpen(row -1, col)) {
            uf.union(xyTo1D(row, col), xyTo1D(row -1, col));    //Connect(site, top-neighbour)
            ufExcludeBottom.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
    }

    /**
     * Returns true if the site(row, col) is open.
     */
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row][col];
    }

    /**
     * Returns true if the site (row, col) is full.
     * Make sure it avoids backwash.
     * Bashwash: a site is full because it connects to bottom, and bottom is connected to top.
     */
    public boolean isFull(int row, int col) {
        validate(row, col);
        return ufExcludeBottom.connected(xyTo1D(row, col), top);   // site(row, col) connected to 0 without backwash
    }

    /**
     * Returns the number of open sites
     * @return
     */
    public int numberOfOpenSites() {
        return numOpenSites;
    }

    /**
     * Returns true if the system percolates.
     * @return
     */
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    // use for unit testing (not required, but keep this here for the autograder)
    public static void main(String[] args) {
        // use for unit testing.
        Percolation p = new Percolation(3);
        p.open(0,0);
        p.open(1,0);
        p.open(2,0);
        p.open(2,2);

        System.out.println(" is ( 2,0) full? " + p.isFull(2,0));
        System.out.println(" is ( 2,2) full? " + p.isFull(2,2));
        System.out.println(" is ( 1,2) full? " + p.isFull(1,2));
        System.out.println(" is p percolated? " + p.percolates());
        System.out.println(" how many sites are opened? " + p.numberOfOpenSites());
        System.out.println(" is (0,0) open? " + p.isOpen(0,0));
        System.out.println(" is (1,2) open? " + p.isOpen(1,2));

        // p.open(3,4);
    }

}
