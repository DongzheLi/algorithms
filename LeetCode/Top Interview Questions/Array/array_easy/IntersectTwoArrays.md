# Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example:

```
Input: nums1 = [1,2,2,1], nums = [2,2]
output: [2,2]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
```

Note: 

+ Each element should appear as many times as it shows in both arrays.
+ The result can be in any order.

Follow up:

+ What if the given array is already sorted? How could you optimize your algorithm?
+ What if nums1 size is much smaller than nums2?
+ What if you have limited space?



My thoughts:
1. we can sort both arrays.
2. find the smaller one, say nums2, start to see if last element in nums2 is in nums1, and second last and so on.
3. at each time, we can just search the part from 0 to where last element in nums2 in nums1.

Also, we need to see how to handle duplicates, 

### Soluton 1: HashMap

We need HashMap, since there is duplicates, we need a key-value pair to be value-count.

Check array size, put smaller one into a HashMap. Better for memory usage too.

Algorithm:

0. Check size, if nums1 is larger than nums2, swap them.
1. For every element in nums1:
    
    + Add it to hashmap m; increment count if already there.

2. Initialize insertion pointer(k) with 0.
3. Iterate over nums2:

    + if current element is in nums1 and count is positive:

        + Copy this number to nums1[k], and increment k.
        + Decrement the count in hash map.

4. return the first k elements.
```java
class solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int n : nums1) {
            m.put(n, m.getOrDefault(n,0) + 1);
        }

        int k = 0;
        for (int n: nums2) {
            int count = m.getOrDefault(n, 0);
            if (count > 0) {
                nums1[k] = n;
                k += 1;
                m.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
```

Notes: 

+ Time: O(m + n)
+ Space: O(min(m, n))
+ HashMap: `m.put(n, m.getOrDefault(n,0) + 1)` a very common pattern
+ `Arrays.copyOfRange(nums1, 0, k)` a very useful array method

## Solution 2: Sort

We sort both arrays, and use two-pointers to find common numbers in a single scan.

Algorithm:

1. Sort nums1 and nums2
2. Initialize i, j, k with zero
3. Move i along nums1, j along nums2:

    + Increment i if nums1[i] is smaller
    + Increment j if nums2[j] is smaller
    + If nums1[i] == nums2[j], copy number into nums1[k], and increment i, j, k

4. return first k elements of nums1

```java
class solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if      (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                nums1[k] == nums1[i];
                k++;
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
```

Notes:

+ Time: O(nlogn + mlogm)
+ Space: O(1)