# Unique Path

Start from the top-left corner of a m*n grid.

You can move either down or move right at any point.

Finish point is at bottom-right corner of the grid.

How many possible unique paths are there from start to finish?


## Solution 1: Recursion (backtracking)

Let uniquePaths(point) = number of possible unique paths to reach this point from the start.

Key Observation:

One can reach the finish point from its top, or from its left.
        
uniquePaths([m-1, n-1]) = uniquePaths([m-2, n-1]) + uniquePaths([m-1, n-2]) 

Algorithm:

1. Base Case:

    + if m or n is 0, that means a m*n = 0 grid, returns 0;
    + if m or n is 1, that means it is a 1-D array, there is only one path, returns 1;

2. Recursive Case:

    + Otherwise, use our observeration, unquePaths(m. n) = uniquepaths(m - 1, n) + uniquePaths(m, n - 1)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
```

## Solution 2: Recursion with Memoarization.

Algorithm:

1. if it is empty array, return 0;
2. Initialize a memo with size m+1 * n+1;
3. Invode the helper function with memo:

    1. If it is 1-D array, return 1;
    2. if there is a solution in the memo, return it;
    3. Else, use our observation formula;
    4. Returns memo[m][n];

```java
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] memo = new int[m + 1][n + 1];

        return uniquePathsMemorized(m, n, memo);
    }

    private int uniquePathsMemorized(int m, int n, int[][] memo) {
        if (m == 1 || n == 1) return 1;

        if (memo[m][n] != 0) return memo[m][n];

        memo[m][n] = uniquePathsMemorized(m-1, n, memo) + uniquePathsMemorized(m, n - 1, memo);

        return memo[m][n];
    }
}

```

## Solution 3: DP

```java
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
```

## Solution 4: DP with space optimazation

```java 
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0; i < n;i++) dp[i] = 1;    // fill the dp array
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
```