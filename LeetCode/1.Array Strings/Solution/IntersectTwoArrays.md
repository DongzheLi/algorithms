# Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

---

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


## Soluton 1: HashMap

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