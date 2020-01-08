# Rotate Image

Example:

```
[
    [1,2,3],
    [4,5,6],
    [7,8,9]
}

Becomes

[
    [7,4,1],
    [8,5,2],
    [9,6,3]
]
```

```java
public void rotate(int[][] matrix) {
    transpose(matrix);
    reverseRow(matrix);
}

public void transpose(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int temp = matrix[j][i];
            matrix[j][i] = matrix[i][j];
            matrix[i][j] = temp;
        }
    }
}

public void reverseRow(int[][] matrix) {
    int n = matix.length;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n/2; j++) {
            int temp = matrix[i][n - 1 - j];
            matrix[i][n-1-j] = matrix[i][j];
            matrix[i][j] = temp;
        }
    }
}
```