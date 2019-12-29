# Product of Array Except Self

Given an array nums of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

```
Input:  [1,        2,      3,     4]
Output: [24,      12,      8,     6]
        [2*3*4, 1*3*4, 1*2*4, 1*2*3]
```

Do it without division.

---

Solution:

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;

    int[] left   = new int[n];
    int[] right  = new int[n];
    int[] result = new int[n];

    // for every index i, left[i] = product of all elements to the left of i.
    // since for i = 0, there is no elements to the left, let left[0] = 1.
    left[0] = 1;
    for (int i = 1; i < n; i++) {
        left[i] = left[i - 1] * nums[i - 1];
    }
    // for every index i, right[i] = product of al elements to the right of i.
    // for the last element, i = n -1, there is no elemetns to the right, let right[n - 1] = 1;
    right[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
        right[i] = right[i + 1] * nums[i + 1];
    }
    // Conduct the result
    for (int i = 0; i < n; i++) {
        result[i] = left[i] * right[i];
    }
    return result;
}
```

```java
public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] answer = new int[length];

    answer[0] = 1;
    for (int i = 1; i < length; i++) {
        answer[i] = nums[i - 1] * answer[i - 1];
    }

    int R = 1;
    for (int i = length - 1; i >= 0; i--) {
        answer[i] = answer[i] * R;
        R *= nums[i];
    }
    return answer;
}
```