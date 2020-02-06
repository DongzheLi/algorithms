# Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

---

Example

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

## Solution 1: Brute force

```java
public int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (nums[j] = target - target[i]) {
                return new int[] {i, j};
            }
        }
    }
    throw new IllegalArgumentException("No solution");
}
```

## Solution 2: HashTable

```java
public int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) return new int[] (i, map.get(complement));
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No solution");
}
```