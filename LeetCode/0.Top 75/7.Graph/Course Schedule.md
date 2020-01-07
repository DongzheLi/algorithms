# Course Schedule

[Leetcode](https://leetcode.com/problems/course-schedule/)

Total of n courses you have to take, labeled from 0 to n-1.

Some courses may have preprequisites, for example to take course 0 you have to first take course 1. [0, 1].

Indegree(v) : the number of edges ended on a vertex v


We do a topological sort.

```java
class Solution {
    private ArrayList[] graph;      // array of lists

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we use the array of lists, each index is an vertex, list at that index is the vertices going to that vertex
        List[] graph = new ArrayList[numCourses];
        // states: 0 = unknown, 1 = visiting, 2 = visited
        int[] visit = new int[numCourses];
        // Change this array of edges to Adjancency list
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }

        // DFS here
        for (int i = 0; i < numCourses; i++) {
            if (dfsCyclic(i, visit)) return false;
        }
        return true;
    }

    private boolean dfsCyclic(int curr, int[] visit) {
        if (visit[curr] == 1) return true;
        if (visit[curr] == 2) return false;
        // change status of curr to visiting now.
        visit[curr] = 1;
        // Iterate over current index's neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            // recursive call to dfsCyclis
            if (dfsCyclis(graph[curr].get(i), visit)) return true;
        }
        // curr vertex is visited
        visit[curr] = 2;
        return false;
    }
}
```