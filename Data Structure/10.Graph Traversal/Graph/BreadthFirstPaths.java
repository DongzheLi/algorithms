public class BreadFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;       // distTo[v] = number of edges on shortest s-v path

    /** Computes the shortest path between s and every other vertex in G. */
    public BreadFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];

        bfs(G, s);
    }

    /** breadth-first search from a single source. */
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = INFINITY;
        }
        distTo[s] = 0;
        marked[s] = 0;
        queue.enqueue(s);

        while (!q.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    
    /** Is there a path between s and v? */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /** Returns the number of edges in a shortest path between s and v. */
    public int distTo(int v) {
        return distTo[v];
    }

    /** Returns a shortest path between s and v. */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> stack = new Stack<>();
        // start from v, trace back until distTo[x] = 0, which means it is s.
        for (int x = v; distTo[x] != 0; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}