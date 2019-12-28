import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class MyTrieSet implements TrieSet61B {

    private TrieNode root;
    /** Node is an object has {isKey: boolean, children: HashMap<Character, Node>} */
    private class TrieNode {
        private boolean isKey;
        private HashMap<Character, Node> children;
        
        public TrieNode(boolean isKey) {
            children = new HashMap<>();
            this.isKey = isKey;
        }
    }

    /** Consturctor emtpy. */
    public MyTrieSet() {
        root = new TrieNode(false);
    }

    /** Clears all items out of the Trie. */
    @Override
    public void clear() { root = new TrieNode(false);}

    /** Returns true if the Trie contains KEY, false otherwise */
    @Override
    public boolean contains(String key) {
        if (key == null || key.length() < 1) throw new IllegalArgumentException();

        TrieNode n = find(key);
        return n != null && n.isKey;    // we need to find given KEY, and make sure it is a key in this Trie.
    }
    /** Private helper: Return the node where key last char ends on. */
    private TrieNode find(String key) {
        Node curr = root; 
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!curr.children.containsKey(c)) return null;
            curr = curr.children.get(c);     // in our children map, character -> another node
        }
        return curr;
    }

    /** Inserts String KEY into Trie. */
    @Override
    public void add(String key) {
        if (key == null || key.length() < 1) throw new IllegalArgumentException();
    
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!curr.children.containsKey(c)) {    // if root.children doesn't have this key, then put it in
                curr.children.put(c, new TrieNode(false));
            }
            curr = curr.children.get(c);            // else, we found the first character, update curr, keep going.
        }
        curr.isKey = true;                          // don't forget to change its flag isKey to true.
    }

    /** 
     * Returns a list of all words that matches with given Prefix.
     * Example: prefix = "sa"
     */
    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> keys = new ArrayList<>();
        Node n = find(prefix);      
        collect(prefix, keys, n);
        return keys;
    }

    /** Collect all the strings with prefix. */
    private void collect(String s, List<String> x, Node n) {
        if (n == null) return;
        if (n.isKey) x.add(s);
        for (char c : n.map.keySet()) {
            collect(s + c, x, n.map.get(c));
        }
    }

    /** Returns the longest prefix of KEY that exists in the Trie. */
    @Override
    public String longestPrefixOf(String key) {
        StringBuilder longestPrefix = new StringBuilder();
        TrieNode currNode = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!currNode.children.containsKey(c)) {
                return longestPrefix.toString();
            } else {
                longestPrefix.append(c);
                currNode = currNode.children.get(c);
            }
        }
        return longestPrefix.toString();
    }
}