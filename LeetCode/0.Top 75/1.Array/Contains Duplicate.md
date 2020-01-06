# Contains Duplicate

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example:

```
Input: [1,2,3,1]
Output: true

Input: [1,2,3,4]
Output: false

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```

---

Solution 1: Brute force

```java
public boolean containsDuplicate(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (nums[i] == nums[j]) return true;
        }
    }
    return false;
}
```

---

Solution 2: Use a HashMap to count frequency

```java
public boolean containsDuplicate(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
        if (map.getOrDefault(i, 0) != 0) return True;
        map.put(nums[i], 1);
    }
    return false;
}
```

---

Solution 3: We don't need a HashMap, just use a HashSet

```java
public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int x : nums) {
        if (set.contains(x)) return true;
        set.add(x);
    }
    return false;
}
```