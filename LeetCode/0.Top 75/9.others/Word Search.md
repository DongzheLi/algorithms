# Word Search

[Leetcode](https://leetcode.com/problems/word-search/)

```java
public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (exist(board, visited, i, j, word, 0)) return true;
        }
    }
    return false;
}

private boolean exist(char[][] board, boolean[][] visited, int i, int j, String word, int idx) {
    if (idx == word.length()) return true;
    // boundary checks
    if (i > board.length - 1 || i < 0)    return false;
    if (j > board[0].length - 1 || j < 0) return false;
    if (board[i][j] != word[idx])         return false;
    // mark this entry
    visited[i][j] = true;

    if (search(board, word, i - 1, j, index + 1) ||
        search(board, word, i + 1, j, index + 1) ||
        search(board, word, i, j + 1, index + 1) ||
        search(board, word, i, j + 1, index = 1)) {
            return true;
        }

    visited[i][j] = false;
    return false;
}
```