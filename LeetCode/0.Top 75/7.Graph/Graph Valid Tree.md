# Graph Valid Tree

[Reference](https://aaronice.gitbooks.io/lintcode/union_find/graph_valid_tree.html)

Given int n and list of edges, where n is the number of vertices from 0 to n-1.

Determine if these edges make up a valid tree.


It is actually better to use Union Find to solve such questions.

But we can do it use DFS, BFS tho.

```java
/** Build a adjacancy list graph from edges */

public Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
        if (!graph.containsKey(i)) {
            graph.put(i, new ArrayList<>());
        }
    }
    for (int[] edge: edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
    }
    return graph;
}
```

Graph is a valid tree when there is no cycle in it.
```java
public boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = buildGraph(n, edges);

    boolean[] visited = new boolean[n];
    // make sure there is no cycle
    if (!hasNoCycle(0, -1, map, visited)) return false;
    // make sure all vertices are connected
    for (boolean b : visited) {
        if (!b) return false;
    }
    return true;
}

/** Returns true when there is no cycle. */
public boolean hasNoCycle(int curr, int parent, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited) {
    // curr has already been visited, this would be the second time, there is a cycle, return false
    if (visited[curr]) return false;

    visited[curr] = true;

    // do DFS here for all i's neighbors
    for (int i : map.get(curr)) {
        // i is not the parent, and from i to curr there is a cycle
        if (i != parent && !hasCycle(i, curr, graph, visited)) return false;
    }
    return true;
}