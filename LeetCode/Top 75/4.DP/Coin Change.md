# Coin Change

## Solution 1: Recursion

```java
public int coinChange(int[] coins, int amount) {
    if (amount < 0)  return -1;
    if (amount == 0) return  0;

    int minimal = Integer.MAX_VALUE;

    for (int coin : coins) {
        int result = coinChange(coins, amount - coin);
        if (result >= 0 && result < minimal) min = 1 + result;
    }

    return minimal;
}
```

## Solution 2: Recursion with Memo

Let's take a look at the recursion tree.

```
s([2,5], 10)
    s(10)
    /   \
  s(8)  s(5)
  /  \
 s(6) s(3)
```

We want to memoriaze solutions to from 0,1,2,..., amount

```java
public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] memo = new int[amount + 1];
    return coinChange(coins, amount, memo);
}

private int coinChange(int[] coins, int amount, int[] memo) {
    if (amount < 0) return -1;
    if (amount == 0) return 0;
    memo[0] = 0;
    if (memo[amount] != 0) return memo[amount];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
        int result = coinChange(coins, amount - coin, memo);
        if (result >= 0 && result < min) {
            min = result + 1;
        }
    }
    if (min == Integer.MAX_VALUE) memo[amount] = -1;
    else memo[amount] = min;
    return memo[amount];
}
```