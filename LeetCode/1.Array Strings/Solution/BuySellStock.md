# Buy or Sell Stock

[Leetcode 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## Solution 1:

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;
    int maxProfit = 0;
    int lowestPrice = prices[0];

    for (int i = 1; i < n; i++) {
        lowestPrice = Math.min(lowestPrice, prices[i]);
        maxProfit   = Math.max(maxProfit, prices[i] - lowestPrice);
    }
}
```


[Leetcode 122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

## Solution 1:

TotalProfit = sum(peeks) - sum(vallys)

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;
    int max = 0;

    int high = prices[0];
    int low = prices[0];

    int i = 0
    while (i < n - 1) {
        while (i < n - 1 and prices[i + 1] <= prices[i]) i++;
        low  = prices[i];
        while (i < n - 1 and prices[i] <= prices[i + 1]) i++;
        high = prices[i];
        max += high - low;
    }
    return max;
}
