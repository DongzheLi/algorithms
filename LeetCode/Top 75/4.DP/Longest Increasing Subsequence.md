# Longest increasing Subsequence

## Solution 1 : Brute force Recursion

Key Observation: At each index 

```java
public int lengthOfLIS(int[] nums) {
    return lengthOFLIS(nums, Integer.MIN_VALUE, 0);
}
/** prev: Last element in the previous LIS.
 *  curPos: current index
 */
private int lengthOfLIS(int[] nums, int prev, int curPos) {
    if (curPos == nums.length) return 0;

    int include = 0;
    // if nums[curpos] > prev, we can add nums[curPos] to LIS
    if (nums[curpos] > prev) {
        include = 1 + lengthOfLIS(nums, nums[curPos], curPos + 1);
    } 

    int exclude = lengthOfLIS(nums, prev, curpos + 1);

    return Math.max(include, exclude);
}
```

-----

## Solution 2: Recursion with Memoization

We can store results in a 2-D array.

Let memo[i][j] denote the the length of LIS where, nums[i] is the previous element considered to be included/exclude in LIS,

and nums[j] is the current element to be considered.

```java
public int lengthOfLIS(int[] nums) {
    int[][] memo = new int[nums.length + 1][nums.length];
    for (int[] row : memo) {
        Arrays.fill(row, -1);
    }
    return lengthOfLIS(nums, -1, 0, memo);
}

public int lengthOfLIS(int[] nums, int prevPos, int currPos, int[][] memo) {
    if (currPos == nums.length) return 0;

    if (memo[prevPos + 1][currPos] >= 0) return memo[prevPos + 1][curPos];

    int include = 0;

    if (prevPos < 0 || nums[currPos] > nums[prevPos]) {
        include = 1 + lengthOfLIS(nums, currPos, currPos + 1, memo);
    }

    int exclude = lengthOfLIS(nums, prevPos, currPos + 1, memo);

    memo[prevPos + 1][currPos] = Math.max(include, exclude);

    return memo[prevPos + 1][currPos];
}
```


## Solution 3: Bottom up DP

Now we just might be ready to turn this into a iteration algorithm which is a bottom up dynamic programming solution.

```java
public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) return 0;

    int[] dp = new int[nums.length];
    Arrays.fill(memo, 1);                     // at each index, the length of LIS is at least 1.

    int currMax = 1;                          // the value we update whenever we see a longer LIS

    for (int i = 1; i < nums.length; i++) {
        // for every index i, we interate j from 0 to i-1
        // check if nums[i] > nums[j], if so, we can increase LIS length
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }
        // for every i, we need to see if we could update currMax
        currMax = Math.max(currMax, memo[i]);
    }
    return currMax;
}
```