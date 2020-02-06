# Best time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

---

Example:

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: 
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Not 7-1 = 6, as selling price needs to be larger than buying price.
```

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

---

## Solution 1: Brute force

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    int maxprofit = 0;
    for (int i = 0; i< n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (prices[j] - prices[i] > maxprofit) maxprofit = prices[j] - prices[i];
        }
    }
    return maxprofit;
}
```

## Solution 2:

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;
    int currMax = 0;
    int lowestPrice = prices[0];

    for (int i = 1; i < n; i++) {
        if (prices[i] < lowestPrice) lowestPrice = prices[i];

        if (prices[i] - lowestPrices > currMax) currMax = prices[i] - lowestPrice;
    }
    return currMax;
}
```