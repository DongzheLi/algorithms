# Valid Anagram

Given two Strings s and t, write a function to determine if t is an anagram of s.

---

Example:

```
s = "anagram", t = "nagaram"
Output = true
```

## Solution 1: Frequency table

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    
    int n = s.length();

    Map<Character, Integer> countTable = new HashMap<>();

    // Iterate over s. (key, value) = (char in s, its frequency)
    // Then substract from interating over t.
    for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        int count = countTable.getOrDefault(c, 0);
        countTable.put(c, count + 1);

        char d = s.charAt(i);
        int count = countTable.getOrDefault(d, 0);
        countTable.put(d, count - 1);
    }

    // Iterate over countTable, if there is non-0 value, return false
    for (char c : countTable.keySet()) {
        if (countTable.get(c) != 0) return false;
    }
    
    return true;
}
```

Notes:

`HashMap.getOrDefault()` : [doc](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#getOrDefault-java.lang.Object-V-)


## Solution 2: ASCII

If we assume there is only letters in this thing, espically only "abc", lower letters.

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}
```