# Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

---

Example:

```
Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
```

## Solution 1: Trie

```java
class TrieNode {
    char c;
    HashMap<Character, TrieNode> children;
    boolean isLeaf;
    String s;

    public TrieNode() {
        children = new HashMap<Character, TriNode>();
        s = "";
    }

    public TrieNode(char ch){
        c = ch;
        s = "";
        children = new HashMap<Character, TrieNode>();
        isLeaf = false;
    } 
}
```

```java
class Trie {
    public TriNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            if (i == word.length() - 1) {
                t.isLeaf = true;
                t.s = word;
            }
        }
    }

    public boolean search(String word) {
        TrieNode t = searchTrieNode(word);
        if (t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    public TrieNode searchTrieNode(String str) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }   
}
```

```java
class Solution {
    int[] dirX = {0,0,1,-1};
    int[] dirY = {-1,1,0,0};

    public void searchWord(char[][] board, int i, int j, TrieNode root, ArrayList<String>) {
        if (root.isLeaf == true) {
            if (!ans.contains(root.s)) ans.add(root.s);
        }
        if (i >= 0 && j < board.length &&
            j > = 0 && j < board[0].lemgth &&
            board[i][j] != '#' && root != null) {
                if (root.children.containsKey(board[i][j])) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dirX[k];
                    int y = j + dirY[k];
                    char temp = board[i][j];
                    board[i][j] = '#';
                    searchWord(board, x, y, root.children.get(temp), ans);
                    board[i][j] = temp;
                }
            }
    }

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> ans = new ArrayList<String>();

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                searchWord(board, i, j, trie.root, ans);
            }
        }

        return ans;
    }
}
```