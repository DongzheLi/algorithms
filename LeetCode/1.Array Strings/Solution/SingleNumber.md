# Single Number

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have linear runtime. Implement it without extra memory.

---

Example:

```
Input: [2,2,1]
Output: 1

Input: [4,1,2,1,2]
Output: 4
```

## Solution 1: HashTable

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