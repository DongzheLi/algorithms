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

Solution:


find 5 in {15,16,19,20,25,1,3,4,5,7,10,14}

---

Algorithms:

```
1. 
find 5 in {10, 15, 20, 0 , 5}
10 < 20, we know left half is sorted, and 10>5, then 5 must be in right half
2.
find 5 in {50, 5, 20, 30, 40}
50 > 20, then right side is sorted, 20 > 5, 40 > 5, then 5 must be in left half.
3. 
middle and left are identical.
{2,2,2,3,4,2}
```

We know half of the array is sorted.

Algorithm:

0. if low < hight, target is not in here, -1

1. if nums[mid] == target, return mid.

2. nums[low] <= nums[mid], left half is sorted:

    + nums[low] <= target <= nums[mid], left half has target
    + right half has target, go search right half.

3. else, right half is sorted:

    + nums[low] <= target <= nums[mid], right half has target
    + left half has target, go search left half

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