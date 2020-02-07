# Palindromic Substrings

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start index or end index are counted as differnt substrings even they consist of same characters.

---

Example:

```
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
```

```
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
```

## Solution 1:

```java
public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        count += countPalindromes(s, i, i);         // count even sized
        count += countPalindromes(s, i, i + 1);     // count odd sized
    }
    return count;
}
/** Returns the number of palindromes centered at (i,j=i) for even case, (i, j=i+1) for odd case. */
private int countPalindromes(String s, int i, int j) {
    int n = s.length();
    int count = 0;
    while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
        i--;
        j++;
        count++;
    }
    return count;
}
```