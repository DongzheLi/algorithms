# Clone Graph

[Leetcode 133](https://leetcode.com/problems/clone-graph/)

Return a deep copy of the specified graph.

Shallow copy : copy of the reference (memory address), if one is modified, the other changes.

Deep copy : Create a new object with exact same value for each field of the object.

This is the definition for a undirected graph.

```java
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {};

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
```

---

## Solution 1: DFS Recursive

DFS recursive is the easiest to do.

```java
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();              // use this hashmap to avoid duplicating work on same vertex
        return cloneGraph(node, map);     
    }

    private Node cloneGraph(Node node, Map<Integer, Node> cloneMap) {
        if (node == null) return null;

        if (map.containsKey(node.val)) return map.get(node.val);

        Node clone = new Node(node.val, new ArrayList<Node>());     // initialize a map with given source vertex

        map.put(clone.val, clone);

        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}
```

## Solution 2: BFS

```java
public Node cloneGraph(Node start) {
    if (node == null) return null;
    // (key, value) = (original node, its clone)
    HashMap<Node, Node> map = new HashMap<>();          // hashmap to avoid duplicate lookups
    // remember BFS use a queue
    Queue<Node> queue = new Queue<>();                  // initialize queue for bfs   
    Node clone = new Node(start.val, new ArrayList<>()); 
    map.put(start, clone);
    
    while (!queue.isEmpty()) {
        Node curr = queue.dequeue();
        
        for (Node neighbor : curr.neighbors) {
            if (!map.containsKey(neighbor)) {
                /** map doesn't contain this neighbor, add it to the queue and to the map */
                map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                queue.enqueue(neighbor);
            }
            // map : (curr, currCopy), (curr_this_neighbor, curr_this_neighborCopy)
            // do :         currCopy = (val, neighbors)
            // we have to add curr_this_neighborCopy to currCopy.neighbors
            map.get(curr).neighbors.add(map.get(neighbor));
        }
    }
    return map.get(start);
}
```