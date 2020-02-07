# Remove Duplicates in place

[Leetcode 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Solution 1:

```java
public int removeDuplicates(int[] nums) {
    Arrays.sort(nums);
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[i] != nums[j]) {
            i++;
            nums[i] = nums[j]   // copy nums[j] to ith index
        }
    }
    return i + 1;               // length of the no-duplicate is last index i + 1
}
```