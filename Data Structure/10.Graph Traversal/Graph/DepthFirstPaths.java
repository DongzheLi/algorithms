public class DepthFirstPaths {
    private boolean[] marked;       // marked[v] = true iff there is a s-v path.
    private int[] edgeTo;           // edgeTo[v] = previous vertex on s-v path.
    private final int s;            // source vertex

    /** Computes a path between s and every other vertex in G. */
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];     // G.V() : number of vertices in the graph
        marked = new boolean[G.V()]; 
        dfs(G, s);
    }

    // depth first search from v.
    // cost model: O(V + E): 
    // each vertex is visited at most once, each edge is visited at most twice.
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {    // G.adj(v) : returns all the neighbours of v, a Iterator
            if (!marked[w]) {       // if w is not marked
                edgeTo[w] = v;      // set path v-w
                dfs(G, w);              
            }
            
        }
    }

    /** Is there a path between s and v ? */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /** Returns a path between source s and v. */
    public Iterable<Integer> pathTo(int v) {
        if (!hashPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}