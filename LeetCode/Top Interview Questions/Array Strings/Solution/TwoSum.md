# Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

```
nums = [2,7,11,15], target = 9;

Since nums[0] + nums[1] = 2 + 7 = 9,
return [0,1]
```

## Solution1: Two loops

Algorithm:

1. Initialize solution array sol
2. Iterate over nums:

    + For every i:

        + Iterate over nums from i:

            + for each j, check nums[j] = target - nums[i]

3. return sol.

```java
class solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] = target) {
                    return new int[] {i, j}
                }
            }
        }
    }
}
```

## Solution 2: Two pass HashMap

Best way to maintain a mapping of element-index: HashMap

Algorithm:

1. Initialize a HashMap map;
2. Iterate over nums:

    + Put value-index pair (nums[i],i) into map.

3. Iterate over nums:

    + For every index j:

        + find value of target-nums[i]
        + put {i, map.get(complement)} into solution array



```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }

    for (int j = 0; j < nums.length; j++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] {i, map.get(complement)};
        }
    }
}
```