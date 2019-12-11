# Single Number

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have linear runtime. Implement it without extra memory.

Examples:

```
Input: [2,2,1]
Output: 1

Input: [4,1,2,1,2]
Output: 4
```

### Solution 1: Use HashSet, or HashMap

Algorithm:

1. initialize a set, which allows no duplicate.
2. iterate over nums, put each num into set if it is not already in set, if it is already in set, take it out. We can gurantee only the single element is left in the set
3. Unfortunately, the only way to get the element out from a set is use an iterator and call iterator.next().

```java
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            // boolean set.add(E e) returns true if this set did not already contain the specified element
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
```

## Solution 2: 2(a + b + c) - (a + b + a + b + c) = c

Algorithm: 

1. We put all nums into a set, then there is no duplicates any more, we add together all the numbers in the set * 2
2. we add together all the numbers in the array.

This could be very hard to write in Java, since there is no build-in support for list comprehension or set comprehension.

## Solution 3: **Bit Manipulation**

`XOR`:

+ if we take XOR of zero and some bit, it returns that bit: ` a XOR 0 = a `
+ if we take XOR of two same bits, it returns 0: `a XOR a = 0`
+ Commutative: `a XOR b XOR a = a XOR a XOR b = 0 XOR b = b`

Algorithm:

since a XOR a = 0, and XOR is commutative, we have 

a * a * b * b * c = c

```java
class solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
```