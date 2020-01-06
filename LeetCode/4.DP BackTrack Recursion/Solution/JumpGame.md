# Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example:

```
Input=[2,3,1,1,4]
Output: true
Explain: Jump 1 step from index 0 to 1, then 3 steps to the last index


Input: [3, 2,1, 0,4]
Output: false
Explain: Always arrive at position 3, which has value 0, you can never reach the end.
```


## Solution 1: Greedy

Key observation: 

The most distance one can reach from 0 to index i: Math.max(maxSofar, i + nums[i]).

Algorithm:

1. Initialize maxJumpSofar, which denotes the distance one can reach from o to current index;
2. Iterate over nums, for each index i:

    + Update maxJumpSofar to be Math.max(maxJumpSofar, i + nums[i]);
    + If maxJuampSofar >= n -1 returns true;

3. Return false;
```java
class Solution {
    public boolean canJump(int[] nums) {
        int nums.length = n;
        int maxJumpSofar = 0;
        for (int i = 0; i < n; i++) {
            maxJumpSofar = Math.max(maxJumpSofar, i + nums[i]);
            if (maxJumpSofar >= n - 1) return true;
        }
        return false;
    }
}
```

## Case Study:

Solving and fully Understanding a DP problem is a 4 step process:

1. Start with the recursive backtracking solution.
2. Optimize with a memorization table, top-down DP.
3. Remove the need for recursion, bottom-up DP.
4. Apply final trick, normally, Greedy.

### Step 1: Backtracking

We try every single jump fr

