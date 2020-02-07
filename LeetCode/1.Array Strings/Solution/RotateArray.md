# Rotate Array

Given an array, rotate the array to the right by K steps, where k is non-negative.

---

Examples:

```
Input  = [1,2,3,4,5,6,7], k = 3
Output = [5,6,7,1,2,3,4]

Input  = [-1,-100,3,99], k = 2
Output = [3,99,-1,-100]
```

## Solution1: Use Extra array(extra memory)

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


## Solution2: Cyclic Replacement in place

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

## Solution3: Reverse the array

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