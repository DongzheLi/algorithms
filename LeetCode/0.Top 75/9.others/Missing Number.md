# Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example:

```
[3,0,1]
Output: 2

[9,6,4,2,3,5,7,0,1]
Output: 8
```

## Solution 1: use `^` XOR

```java
public int missingNumber(int[] nums) {
    // nums = 0,1,2,...,n with one number missing
    // so nums.length = n;
    // for every number i, i XOR i = 0
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
        missing = missing ^ i ^ nums[i];  
    }
    return missing;
}
```

## Solution 2: Gauss's formula

```java
public int missingNumber(int[] nums) {
    int len = nums.length;
    int expectedSum = len * (len + 1) / 2;
    int actualSum = 0;
    for (int num : nums) actualSum += num;

    return expectedSum - actualSum;
}
```
