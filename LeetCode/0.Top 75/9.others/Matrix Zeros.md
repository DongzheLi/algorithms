# Set Matrix Zeros

Given a m*n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example :

```
[
    [1,1,1]
    [1,0,1]
    [1,1,1]
]

output:

[
    [1,0,1],
    [0,0,0],
    [1,0,1]
]
```

## Solution 1: O(M + N) space

```java
public void setZeros(int[][] matrix) {
    int R = matrix.length;       // # of rows
    int C = matrix[0].length;    // # of columns
    // if matrix[i][j] = 0, put i in zeroRows, j in zeroCols
    Set<Integer> zeroRows = new HashSet<>();
    Set<Integer> zeroCols = new HashSet<>();

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (matrix[i][j] == 0) {
                zeroRows.add(i);
                zeroCols.add(j);
            }
        }
    }
    // Iterate over the matrix again, change entry to 0 according to our sets
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (zeroRows.contains(i) || zeroCols.contains(j)) matrix[i][j] = 0;
        }
    }
}
```