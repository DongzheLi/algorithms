# Container with most water

Given n non-negative integers a1, a2, ..., a2, where each represents a point at coordinate (i, ai), n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

---

Example:

```
Input: [1,8,6,2,5,4,8,3,7]
Output: 49

i = 1, j = 9.
output = 7 * (j - i - 1)
```

## Solution 1:

We are looking for the max[min(height[i], height[j]) * (j - i - 1)]

```java
public int maxArea(int[] height) {
    int maxarea = 0;
    int i =0, j = height.length - 1;
    while (i < j) {
        maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i - 1));
        if (height(i) < height(j)) i++;
        else                       j--;
    }
    return maxarea;
}
```
