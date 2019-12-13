# Rotate Array

Given an array, rotate the array to the right by K steps, where k is non-negative.

Examples:

```
Input  = [1,2,3,4,5,6,7], k = 3
Output = [5,6,7,1,2,3,4]

Input  = [-1,-100,3,99], k = 2
Output = [3,99,-1,-100]
```

My thoughts: 

First observation is that, given k, n = nums.length, we can get nums[n-k], from this index to the end of the array will be the first part of the array, and from nums[0] to nums[n-k-1] will be the second part.

Also the function doesn't return anything, so we have to modify the original array.

## Solution1: Use Extra array(extra memory)

Algorithm:

1. Initialize an extra array a with nums.length size.
2. Iterate over nums:

    + For each index i:

        + a[i+k] % nums.length = nums[i], we need `%nums.length` since the second half will rotate over
3. Copy a to nums.

```java
class solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            a[(i+k) % n] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
```

Note: 

+ Easy to come up with, easy to write.
+ Time: O(n)
+ Space: O(n)


## Solution2: Use Cyclic Replacement, in place

We can directly replace every element of the array with required rotated one, but we have to keep a reference to the original one.

Idea: start at index 0, we move nums[0] to nums[k], and keep a reference temp = nums[k], then move temp=nums[k] to nums[k+k], and so on.

e.g.

```
nums = [1,2,3,4], k = 2.
n = nums.length = 4
idx = 0, start = 0
idx = (idx+k) % n = 2,
idx = (idx+k) % n = 0,
now idx = start, increment both, idx = 1, start = 1.
```
Algorithm:

1. Initialize count = 0
2. Iterate over nums:

    + For every index i:

        + store 


```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;      // we need to move exactly n nums

        for (int start = 0; count < nums.length; start++ ) {
            int current = start;
            int prev = nums[start]; 
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;    // increment count at every move.
            } while (start != current);
        }
    }
}
```

## Solution3: Reverse

Example:

```
[1, 2, 3, 4, 5, 6, 7], k = 3

Reverse all: [7,6,5,4,3,2,1]

Reverse first k=3: [5,6,7,4,3,2,1]

Reverse last n-k: [5,6,7,1,2,3,4]
```

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void revese(int[] nums, int start, int end) {
        while (start < end ) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
```

Notes:

+ Time: O(n)
+ Space: O(1)