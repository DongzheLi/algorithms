# Longest Substring without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example:

```
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
```

```
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

```
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

---

## Solution 1

Brute force: find all substrings that has no duplicates, find the max length.

```java
/* Generate all substring, see if it contains no duplicate characters. */
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j <= n; j++) {
            if (allUnique(s, i, j)) maxLength = Math.max(maxLength, j - i);          
        }
    }
    return maxLength;
}
/* Returns true if the characters if s(start, end) are all unique. */
private boolean allUnique(String s, int start, int end) {
    // use a set to track duplicates.
    Set<Character> set = new HashSet<>();
    
    for (int i = start; i < end; i++) {
        Character ch = s.charAt(i);
        if (set.contains(ch)) return false;
        set.add(ch);
    }
    return true;
}
```

---

Solution 2: Sliding window

If a substring s(i, j) from index i to j-1 has no duplicate. 

We don't need to check s(i, j+1) has no duplicate, we only need to check if s(i, j) contains s(j+1).

Again, we use a hashset to check for duplicates.

Algorithm:

Use HashSet to store characters in current window [i, j) (j = i initially.)

We slide j to the right, j++. If it is not in the HashSet, we slide j further.

```java
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    for (int i = 0; i < n; i++) {
        // Use a HashSet as a sliding window for each i
        Set<Character> substring = new HashSet<>();
        // slide j from i to the end.
        for (int j = i; j< n; j++) {
            Character ch = s.charAt(j);
            if (substring.contains(ch)) break;
            substring.add(ch);
        }
        maxLength = Math.max(maxLength, substring.size());
    }
    return maxLength;
}
```

---

Solution 3: Sliding windown Optimized(use HashMap)

We don't have to slide i 1 by 1.

if s[j] is a duplicate in s[i, j), say s[j'], we don't need to increase i 1 by 1, we can jump to j' + 1 directly.

For each character in String, we want to keep its index too.

```java
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    // (key, value) = (character, index)
    Map<Character, Integer> map = new HashMap<>();

    for (int start = 0, end = 0; end < n; end++) {
        // if s[j] is a duplicate of s[j'], change start to j'+1
        if (map.containsKey(s.charAt(end)))
            start = Math.max(map.get(s.charAt(end)), start);
        maxLength = Math.max(maxLength, end - start + 1);
        // if s[j] is not a duplicate, store (s[j], j) in map.
        map.put(s.charAt(end), end + 1);
    }
    return maxLength;
}
```

---

Solution 4: Sliding window (int[128] for ASCII trick)

If we know we are working with English, or ASCII or Extended ASCII. Then we can replace HashMap with an int[].

Commonly used tables are:

+ int[26] : for letters 'a' - 'z' or 'A' - 'Z'
+ int[128] : for ASCII
+ int[256] : for extended ASCII

```java
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    int[] index = new int[128]; // current index of character

    for (int i = 0, j = 0; j< n; j++) {
        i = Math.max(index[s.charAt(j) - '0'], i);
        maxLength = Math.max(maxLength, j - i + 1);
        index[s.charAt(j)] = j + 1;
    }
    return ans;
}
```