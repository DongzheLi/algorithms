# House Robber (question 198)

You can't robe adjacent houses.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police(rob adjacent houses).

Example:

```
Input: [1,2,3,1]
Output: 4
Explain: Rob house 1, then Rob house 3  => 1 + 3 = 4

Input; [2, 7, 9, 3, 1]
Output: 12
Explain: Rob house 1, house 3, house 5 => 2 + 9 + 1 = 12
```

## Solution 1: DP

**Key Observation**:

Let's denote the max amount one can rob at house i, f(i).

f(i) = max(f(i-1), f(i - 2) + amount(i));

Algorithm:

1. Initialize int[n] maxRob;
2. maxRob[0] = amounts[0], maxRob[1] = max(maxRob[0], amounts[1]);
3. Iterate over amounts from i = 2:

    + for each index i:

        + maxRob[i] = max(maxRob[i-1], maxRob[i-2]+amounts[i])

4. Returns maxRob[n-1];

```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] maxRob = new int[n];
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(maxRob[0], 0 + nums[1]);

        for (int i = 0; i < n; i++) {
            maxRob[i] = Math.max(maxRob[i-1], maxRob[i-2] + nums[i]);
        }
        return maxRob[n - 1];
    }
}
```