# Add and Search Word - Data Structure Design

Support 

void addWord(word)

boolean search(word)

Use a Trie.

```java
class TrieNode {
    public boolean isLeaf;
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];    // we are only considering lower-case letters
        // if we are doing something more general, we'd use a HashMap (key, value) = (character, TrieNode[] children)
    }
}

```java
class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Inserts a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {   // e.g. word = "data"
            int index = word.charAt(i) - 'a';       // first char d, its index = 3
            if (p.children[index] == null) {        // if p.children is empty at index 3 now.
                TrieNode temp = new TrieNode(); 
                p.children[index] = temp;           // add a TrieNode at index 3.
            }
            p = p.children[index];
        }
        p.isLeaf = true;
    }

    // Returns true if the word is in the data structure.
    // A word could use contain '.' as wild card to represent any one letter.
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(TrieNode node, String word, int k) {
        if (k == word.length()) return node.isLeaf();
        if (word.charAt(k) == '.') {    // if at given index, it is a wild card '.'
            for (int i = 0; i < p.children.length; i++) {
                if (match(p.children[i], word, k + 1)) return true;
            }
        } else {
            int index = word.charAt(k) - 'a';
            return p.children[index] != null && match(p.children[index], word, k + 1);
        }
    }
}
```