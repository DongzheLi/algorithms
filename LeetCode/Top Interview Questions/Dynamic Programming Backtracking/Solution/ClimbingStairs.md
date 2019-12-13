# Climbing Stairs

It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many ways can you climb to the top?

## Solution 1: Brute Force Recursion

Algorithm: 

Let's denote f(n) to be the number of ways to climb n stairs.
f(n) = f(n-1) + f(n-2);

At each Stair from 0 to n:

+ From Stair i to Stair n: we can take one step or two steps => f(i, n) = f(i+1, n) + f(i+2, n)

```java
class Solution {
    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    public int climbStairs(int step, int n) {
        if (i > n) return 0;
        if (i == n) return 1;

        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }
}
```

## Solution 2: Recursion with Memorization

```java
class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    public int climbStairs(int i, int n, int memo[]) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];

        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
        return memo[i];
    }
}
```

## Solution 3: Dynamic Programming

Algorithm:

Let dp[i] denote the number of ways to reach on ith step:

dp[i] = dp[i-1] + dp[i-2]

```java
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n]
    }   
}
```

## Solution 4: Fibonacci Number

```java
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int first = 1; 
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
```

