# Number of Islands

Idea: 

Loop over the grid, when see a '1', i.e. island :

+ count ++
+ dfs(i,j) from that entry, search all 4 directions, change all 1's to 0, sink all land.

This is how we find number of islands.

```java
class Solution {
    char[][] g; // given grid.

    public int numIslands(char[][] grid) {
        g = grid;   // store the given grid for recursion
        // dimensions of the given graph
        int n = g.length;   // number of rows
        int m = g[0].length;
        // count to return
        int count = 0;

        if (y == 0) return 0;

        // Iterate over the entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {   // it is a island
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        // Check for invalid indices and water sites.
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;
        // mark this site
        g[i][j] = '0';

        // Check all adjacent sites
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}