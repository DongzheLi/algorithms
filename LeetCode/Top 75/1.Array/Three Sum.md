# 3Sum

Given an array nums of n integers, find a, b, c in nums such that a + b + c = 0.

Find all unique triplets in the array which gives the sum of 0.

The solution set must not contain duplicate triplets.

---

Example:

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

Algorithm:

Find three indices i, j, k where nums[i] + num[j] + nums[k] = target.



0. Sort the array. initialize solution list.
1. From i = 0 to n - 2:

    + j = i + 1, k = n - 1.
    + while j < k :

        + if (nums[i] + num[j] + nums[k] = target) triplet = {i, j, k}, solution.add(triplet)


```java
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        int j = i + 1;
        int k = n - 1;

        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == target) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(i);
                triplet.add(j);
                triplet.add(k);
                result.add(triplet);
                // avoid duplicates, since nums is sorted, duplicates are next to each other
                while (j < k && nums[j] == nums[j + 1]) j++;
                while (j < k && nums[k] == nums[k - 1]) k--;
                // otherwise, just increase left and decrease right
                j++;
                k--;
            }
            // sum > 0, we need to decrease our sum, we move k left.
            else if (nums[i] + nums[j] + nums[k] > 0) k--;
            else                                      j++;
        }
    }
    return result;
}
```