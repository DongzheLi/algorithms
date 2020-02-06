# Search in Rotated Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

---

Example:
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

---

## Solution 1: Sort, then binary search

```java
public int search(int[] nums, int target) {
    return search(nums, target, 0, target.length - 1);
}

private int search(int[] nums, int target, int low, int high) {
    if (low < high) return -1;

    int mid = (low + high) / 2;
    if (nums[mid] == target) return mid;

    // if left half is sorted
    if (nums[low] <= nums[mid]) {
        // if target is in left half, search left half
        if (nums[low] <= target && target <= nums[mid]) {
            return search(nums, target, low, mid - 1);
        } else {
            return search(nums, target, mid + 1, high);
        }
    }
    // right half is sorted
    else {
        // if target is in right half, search right half
        if (nums[mid] <= target && target <= nums[high]) {
            return search(nums, target, mid + 1, high);
        } else {
            return search(nums, target, low, mid - 1);
        }
    }
}
```