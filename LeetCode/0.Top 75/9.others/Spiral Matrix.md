# Spiral Matrix

Return all elements of matrix in spiral order

Example:

```
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

Let's just do what they are asking of us.

List = first row + las column + last row + first column + goinside + do it again.

```java
public List<Integer> spiralOrder(int[][] matrix) {
    List res = new ArrayList<>();
    int n = matrix.length;      // # of rows
    int m = matrix[0].length;   // # of cols
    if (r == 0) return res;
    int up = 0, down = n - 1;
    int left = 0, right = m - 1;

    while (res.size() < n * m) {
        // add the first row
        for (int j = left; j <= right; j++)      res.add(matrix[up][j]);
        // add the last column, gotta skip the last element of the first row
        for (int i = up + 1; i <= down - 1; i++) res.add(matrix[i][right]);
        // add the last row, from right to left
        for (int j = right; j >= left; j--)      res.add(matrix[down][j]);
        // add the first column, first bottom to top
        for (int i = down - 1; i >= up + 1; i--) res.add(matrix[i][left]);
        // spiral inward
        left  = left + 1;
        right = right - 1;
        up    = up + 1;
        down  = down - 1;
    }
    return res;
}
```