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

---

Solution:

```
maxGlobal = nums[0] = -2
maxEndhere = nums[0] = -2
[-2,1,-3,4,-1,2,1,-5,4]
restart or continue : Math.max(maxEndhere + nums[i], nums[i])
i = 1 : restart or continue from before -> restart, maxEndhere = 1
i = 2 : continue -> maxEndhere = -2
i = 3 : restart -> maxHere = 4
i = 4 : continue -> maxHere = 3
i = 5 : continue -> maxHere = 5
i = 6 : continue -> maxHere = 6
i = 7 : continue -> maxHere = 1
i = 8 : continue -> maxHere = 5
```

How about a int[], where at each index i, it records the largest sum of contiguous subarray end at that index. we can just stop as soon as we see a negative number.

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

