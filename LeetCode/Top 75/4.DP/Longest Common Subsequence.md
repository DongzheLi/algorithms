# Longest Common Subsequence


## Solution 1: Recursion

```java
public int LCS(String A, String B) {
    if (A.length() == 0 || B.length() == 0) return 0;

    String restOfA = A.substring(1);
    String restOfB = B.substring(1);

    if (A.charAt(0) == B.charAt(0)) return 1 + LCS(restOfA, restOfB);
    else                            return Math.max(LCS(restOfA, B), LCS(A, restOfB));
}
```

## Solution 2: Recursion with MEMO

```java
public int LCS(String A, String B) {
    if (A.length() == 0 || B.length() == 0) return 0;
    int[][] memo = new int[A.length()][B.length()];
    return LCS(A.toCharArray(), B.toCharArray(), A.length(), B.length(), memo);
}
private int LCS(char[] A, char[] B, int i, int j, int[][] memo) {
    if (i <= 0 || j <= 0) return 0;

    if (memo[i][j] != null) return memo[i][j];

    if (A[i - 1] == B[j - 1]) memo[i][j] = 1 + LCS(A, B, i - 1, j - 1, memo);
    else                      memo[i][j] = Math.max(LCS(A,B,i,j-1,memo), LCS(A,B,i-1,j,memo));

    return memo[i][j];
}
```

## Solution 2: Bottom up DP

```java
public int LCS(String A, String B) {
    /** 
     * Size is length + 1, to store base case.
     * dp[i][j] denotes LCS(A[1,...,i], B[1,...,j])
     */ 
    int[][] dp = new int[A.length() + 1][B.length() + 1];

    for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
            if (i == 0 || j == 0) dp[i][j] == 0;
            else if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
            else                                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[A.length()][B.length()];
}