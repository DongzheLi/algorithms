# Maximum Subarray (question 53)

Given an int[] nums, find the contiguous subarray(containing at least one number) which has the largest sum and return its sum.
 
Example:

```
Input:[-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6;
```

## Solution 1: Greedy

Algorithm:

1. Initialize globalMax, localMax with 0;
2. Iterate over nums, for every index i:

    + localMax = max(nums[i], localMax + nums[i]);
    + globalMax = max(globalMax, localMax);
  
3. Return globalMax;

```java
class Solution {
    public int maxSubarray(int[] nums) {
        int n = nums.length;

        int globalMax = 0;
        int localMax = 0;

        for (int i = 1; i < n; i++ ) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);
        } 
        return globalMax;
    }
}
```

## Solution 2: In place DP

Algorithm:

1. Initialize maxSum;
2. Iterate over nums, for each index i:

    + if (nums[i-1] > 0), then it is good to add that value to nums[i]:

        + nums[i] = nums[i] + nums[i-1];

    + Update maxSum to be the max(maxSum, nums[i]);

3. Return maxSum;

Example:

```
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

At every index i, we restart if currentSum < 0;
            
currSum = [-2, 1, -2, 4, 3, 5, 6, 1, 5];

At every index i, we rewrite its value if nums[i] < previous max

maxSoFar = [-2,1, 1, 4, 4, 5, 6, 6, 6];

But we need to do all this in place by modifying the given array.
```

```java
class Solution {
  public int maxSubArray(int[] nums) {
    int n = nums.length, maxSum = nums[0];
    for(int i = 1; i < n; ++i) {
      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
      maxSum = Math.max(nums[i], maxSum);
    }
    return maxSum;
  }
}
```

