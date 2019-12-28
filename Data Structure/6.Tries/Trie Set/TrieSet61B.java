import java.util.List;

public interface TrieSet61B {
    /** Clears all items out of Trie. */
    void clear();

    /** Returns true if the Trie contains KEY, flase otherwise. */
    boolean contains(String key);

    /** Inserts string KEY into Trie. */
    void add(String key);

    /** Returns a list of all words that start with prefix. */
    List<String> keysWithPrefix(String prefix);

    /** Returns the longest prefix of KEY that exists in this Trie. */
    String longestPrefixOf(String key);
}