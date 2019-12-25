# Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

```
Input: [10, 9, 2, 5, 3, 7, 101, 18]
Output: 4
Explain: THe longest increasing subsequence is [2,3,7,101]
```

My thoughts: 

let LIS(i) denote the length of longest increasing subsequence at that index.

Then for every index i: 

    + if nums[i] > the previous lis, then nums[i] can contribute, then we can add in, LIS(i) = LIS(i-1) + 1;
    + else, then we start over, LIS(i) = 1


## Solution 1: Recursion (brute force)

Simplest approach is to find all increasing subsequences, then returning the maximum length of longest increasing subsequence.

Algorithm:

(int[] nums, int prev: last element included in the LIS, int curPos: current index) => length of the LIS possible from curPos

1. If current element is out of nums, then it is 0, otherwise, at each element, the LIS is at least 1.
2. There will be 2 cases:

    + if nums[curPos] > prev, we include current element, update taken = 1 + call recursively on curPos+1, move the current Position by 1
    + if we cann't include current element, we move on to next element.

3. Returns the max(taken, notTaken);

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    // Returns the length of the LIS possible from the current element(curPos) onwards.
    public int lengthOfLIS(int[] nums, int prev, int curPos) {
        if (curPos == nums.length) return 0;
        
        int taken = 0;
        if (nums[curPos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curPos], curPos + 1);
        }
        int notTaken = lengthOfLIS(nums, prev, curPos + 1);

        return Math.max(taken, notTaken);
    }
}
```

## Solution 2: Recursiopn with Memoization

Algorithm: We need to memorize some information to speed up.

Let memo[i][j] represents the length of LIS;

where nums[i] is the previous element to be considered included/not included in the LIS,

where nums[j] is the current element to be considered included/not included in the LIS.

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n+1][n];
        for (int[] l : memo) {
            Arrays.fill(1, -1);
        }

        return lengthOfLIS(nums, -1, 0, memo);
    }

    public int lengthOfLIS(int[] nums, int prevIndex, int currIndex, int[][] memo) {
        if (currIndex == nums.length) return 0;

        if (memo[prevIndex + 1][currIndex] >= 0) return memo[prevIndex + 1][currIndex];

        int taken = 0;

        if (preIndex < 0 || nums[currIndex] > nums[prevIndex]) {
            taken = 1 + lengthOfLIS(nums, currIndex, currIndex + 1, memo);
        }

        int notTaken = lengthOfLIS(nums, prevIndex, currIndex + 1, memo);

        memo[prevIndex + 1][currIndex] = Math.max(taken, notTaken);

        return memo[prevIndex + 1][curPos];
    }
}
```

## Solution 3: DP

```java
class Solution {
    public int lengthOfLIS(int[] nums) {    
        // Make leetcode happy
        if (nums.length == 0) return 0;
        // initialzie dynamic programming memory
        int[] memo = new int[nums.length];
        
        Arrays.fill(memo, 1);    // the LIS at each index is 1, i.e. itslef
        
        int curMax = 1; // the updater, also the result we will return
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {       // for each j<i, check if we can append nums[i] to the previous best LIS at index j
                if (nums[i] > nums[j]){         // append when nums[i]>nums[j], since we want increasing sequence
                    memo[i] = Math.max(memo[i], memo[j] + 1);   // compare each nums[j] + 1 to previous memo[i]
                }
            }
            curMax = Math.max(curMax, memo[i]); // For each LIS, we compare to current max LIS to update to the larger of the two.
        }
        return curMax;
    }
}
```