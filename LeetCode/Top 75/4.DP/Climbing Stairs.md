# Climbing stairs

This is an easy DP question, not even really.

```java
class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairs(n, memo);
    }
    private int climbStairs(int n, int[] memo) {
        if (n < 0)       return 0;
        else if (n == 0) return 1;
        
        // if we already have the solution, just return it.
        else if (memo[n] > -1) return memo[n];
        else {
            memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
            return memo[n];
        }
    }
}
```