# Graph Traversal

+ [CS61B notes](https://docs.google.com/presentation/d/143WntPl7CG5Po3utVK0jYSA0Jd6XKppT5h1juWEWhUU/edit#slide=id.g54593997ea_11_0)

+ [S-T Connectivity](https://docs.google.com/presentation/d/1OHRI7Q_f8hlwjRJc8NPBUc1cMu5KhINH1xGXWDfs_dA/edit)


+ [Depth First Search](https://docs.google.com/presentation/d/1lTo8LZUGi3XQ1VlOmBUF9KkJTW_JWsw_DOPq8VBiI3A/edit#slide=id.g76e0dad85_2_380)

+ [Breadth First Search](https://docs.google.com/presentation/d/1JoYCelH4YE6IkSMq_LfTJMzJ00WxDj7rEa49gYmAtc4/edit#slide=id.g76e0dad85_2_380)


---

# Graph Representation

Graph API

```java
public class Graph {
    public Graph(int V):                // Create empty graph with V vertices.
    public void addEdge(int v, int w);  // add and adge v-w, connect v and w.
    Iterable<Integer> adj(int v);       // vertices adjacent to v, v's neighbours
    int V();                            // number of vertices
    int E();                            // number of edges
}
```

Two are Three Graph implementations:

+ Set of edges: {(1,2), (2,3),..}
+ Adjacency Matrix
+ Array of Adjancency list: [{1,2,3},{2,3,4},...] at each index, it is a list of vertices that connect that index vertex.

----

+ [Depth First Search](Graph/DepthFirstPaths.java) : Find a path from s to every other reachable vertex
+ [Breadth First Search](Graph/BreadthFirstPaths.java) : Find a shortest path from s to every other reachable vertex

Runtime : O(V + E), very very hard.


# Topological Sorting

This is an application of DFS.

Algorithm:

+ Perform a DFS traversal from every vertex in the graph, not clearing marking in between traversals.
+ Record DFS postorder along the way.
+ Topological ordering in the reverse of the postorder.

Why it works:

Each vertex is added to the end of the postorder list only after considering all descendants of v.

```
topological(DAG):
    initialize marked array
    initialize postOrder list
    for all vertices in DAG:
        if vertex is not marked:
            dfs(vertex, marked, postOrder)
    return postOrder reversed

dfs(vertex, marked, postOrder):
    marked[vertex] = true
    for neighbor of vertex:
        dfs(neighbor, marked, postOrder)
    postOrder.add(vertex)
```
