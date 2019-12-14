# Coin Change

You are given coins of different denominations and a total amount of money amount.

Write a function to compute the fewest number of coins that you need to make up the amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example:

```
Input: coins = [1,2,5], amount = 11
outuput: 3
Explain: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output = -1
```

Note: You may assume that you have an infinite number of each kind of coin.


## Solution 1: Recursion

Let f(n) denote the least number of coins to make up the amount n.

Suppose, we are one more coin away to make up the full amount.

f(amount) = 1 + min(f(amount - coin)), for every coin in coins.

f(amount) = 0, when amount = 0.

f(amount) = -1, when  = 0.


Algorithm:

1. If amount < 1, return 0;
2. Calls helper Recursive function;

1. Base case:

    + if amount < 0, return -1;    
    + if amount == 0, return 0;

2. Recursive case:

    + Initialize min with Integer.MAX_VALUE
    + Iterate over coins:

        + recursively call result = coinChangeHelper(coins, amount - coin);

        + update min = result;

    + If min == Integer.MAX_VALUE, return -1;
    + Returns min+1;

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        return coinChangeHelper(int[] coins, int amount);
    }

    private coinChangeHelper(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int min = Integer.MAX_VALUE;

        for (int coin: coins) {
            int result = coinChangeHelper(coins, amount - coin);

            if (result >= 0 && result < min) min = result;
        }

        if (min == Integer.MAX_VALUE) return -1;

        return min + 1;
    }
}
```

## Solution 2: Top-Down DP

Algorithm:

Everything is the same as before, we just need to memoriaze solution.

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        // Set up memorization.
        int[] count = new int[amount];

        return coinChange(coins, amount, count);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;

        // Check memo
        if (count[rem - 1] != 0) return count[rem - 1]; 

        int min = Integer.MAX_VALUE;

        for (int coin: coins) {
            int result = coinChange(coins, rem - coin, count);
            if (result >= 0 && result < min) min = 1 + res;
        }

        // Put Result in the memo
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[rem - 1];
    }
}
```

## Solution 3: Bottom-Up DP

Algorithm:


```java
class Solution {
    public int coinChange(int[], int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) { // i ranges from 1 to amount
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```