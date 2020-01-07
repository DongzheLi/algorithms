# Number of Connected Components in undirected graph

Algorithm:

1. int[] visited
2. For every vertex v :

    + if v is not visited, dfs(v)
    + print new line 

dfs(v) :

1. mark v
2. Print v
3. For every neighbor n : v.neighbors:

    if n is not visited, then call dfs(n)

```java
public void connectedComponents(int n, int[][] edges) {
    if (n == 0) return 0;
    if (edges == null || edges.length == 0) return n;

    // build a adjacency list graph of array of edges.
    Map<Integer, List<Integer>> graph = buildGraph(n, edges);
    int count = 0;  // number of components
    boolean[] visited = new boolean[n];
    // for every non-visited vertex, dfs it
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(graph, visited, i);
            count++;
        }
    }
    return result;
}

public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int i) {
    if (visited[i]) return;

    visited[i] = true;
    // iterate over i's neighbors
    for (int n : graph.get(i)) {
        dfs(graph, visited, j);
    }
}

/** Build a adjacency list graph of list of edges */
public Map<Integer, List<Integer>> buildGraph(int n, int[][] graph) {
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