# Longest Consecutive Sequence

[Leetcode 128](https://leetcode.com/problems/longest-consecutive-sequence/)

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Find one runs in O(N) runtime.

Example:

```
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

## Solution 1: Brute force

How do we do a brute force????

```java
public int longestConsecutive(int[] nums) {
    int longest = 0;

    for (int num : nums) {
        int currentNum = num;
        int currentLongest = 1;
        
        while (arrayContains(nums, currentNum + 1)) {
            currentNum++;
            currentLongest++;
        }
        longest = Math.max(longest, currentLongest);
    }
    return longest;
}

private boolean arrayContains(int[] nums, int curr) {
    for (int num : nums) {
        if (num == curr) return true;
    }
    return false;
}
```

## Solution 2: Sorting

If we sort this array, it will be much faster.

```java
public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);  // .sort works in O(nlogn) time

    int longest = 1;
    int current = 1;

    for (i = 1; i < nums.length; i++) {
        if      (nums[i] == nums[i - 1]) continue;
        else if (nums[i] == nums[i - 1] + 1) current += 1;
        else {
            longest = Math.max(longest, current);
            current = 1;
        }
    }
    return Math.max(longest, current);
}
```

## Solution 3 : Optimaze Brute force with HashSet

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    // put numbers in a hashset allows us a O(1) lookup time
    for (int num : nums) set.add(num);

    int longest = 0;

    for (int num : num_set) {
        if (!set.contains(num - 1)) {
            int currNumber = num;
            int currStreak = 1;

            while (set.contains(currNumber + 1)) {
                currNumber += 1;
                currStreak += 1;
            }
            longest = Math.max(longest, currStreak);
        }
    }
    return longest;
}