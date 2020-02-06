# Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

--- 

Example:

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

Follow up: 

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

## Solution 1:

```java
public int maxSubarray(int[] nums) {
    int n         = nums.length;
    int maxHere   = nums[0];
    int maxGlobal = nums[0];

    for (int i = 1; i < n; i++) {
        maxHere = Math.max(maxHere + nums[i], nums[i]);
        maxGlobal = Math.max(maxGlobal, maxHere);
    }
    return maxGlobal;
```

