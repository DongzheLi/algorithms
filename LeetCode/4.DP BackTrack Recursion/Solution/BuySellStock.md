# Best time to Buy and Sell Stock

You have an array for which the ith element is the price of a given stock on day i.

You were permitted to complete one transaction.

You cannot sell a stock before you buy one.

Example:

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and Sell on day 5 (price = 6), make 5
```

## Solution 1: Brute Force (two loops)

Algorithm: 

1. Initialize globalMax with 0;
2. Iterate over prices, For every index i:

    + Iterate over i + 1 to n, For every index j: 
        
         + if prices[j] - prices[i] > globalMax, then update globalMax

3. Return globalMax

```java
class Solution {
    public int maxProfit(int[] prices) {
        int globalMax = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currMax = prices[j] - prices[i];
                if (currMax > globalMax) globalMax = currMax;
            }
        }
        return globalMax;
    }
}
```
Algorithm:

1. Initialize currentMin, currentMaxProfit with 0
2. Iterate over prices:

    + For each Price:

        + Compare to currentMin, if price < currentMin, then update currentMin = price.
        + if price - currentMin > currentMaxProfit, then update currentMaxProfit = price - currentMin
3. return currentMaxProfit

```java
class solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int currentMin = prices[0];
        int curMaxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < currentMin) currentMin = prices[i];
            if (prices[i] - currentMin > curMaxProfit) curMaxProfit = prices[i] - currentMin;
        }
        return curMaxProfit;
    }
}
```