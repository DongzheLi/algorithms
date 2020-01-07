# Water Flow

1. Two Queues :

    + One queue: add all the pacific border
    + One queue: add all the atlantic border

2. Keep a visited matrix for each queue.


```java
class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        int n = matrix.length;     // number of rows
        int m = matrix[0].length;  // number of columns

        // boolean [][] to keep visited status
        boolean[][] pacific = new boolean[n][m];    // pacific[i][j]: means matrix[i][j] cell can flow pacific direction, i.e. left and top
        boolean[][] atlantic = new boolean[n][m];
        // Queue<int[]> to keep pacific or atlantic borders
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        for (int i = 0;i < n; i++) {  // vertical border
            pQueue.enqueue(new int[]{i, 0});
            aQueue.enqueue(new int[]{i, m-1});
        }
    } 
} 