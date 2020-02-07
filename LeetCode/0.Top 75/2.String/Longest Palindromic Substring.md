# Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

---

Example:

```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: "cbbd"
Output: "bb"
```

## Solution 1:

```java
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";

    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++) {
        // odd case
        int len1 = expandAroundCenter(s, i, i);
        // even case
        int len2 = expandAroundCenter(s, i, i + 1);

        int len = Math.max(len1, len2);
        // if found a longer palindrome, then change (start, end) to (i-(len-1)/2, i + len/2)
        if (len > end - start) {
            start = i - (len - 1)/2;
            end   = i + len/2;
        }
    }
    return s.substring(start, end + 1);
}
/** helper method:
 *  returns the length of a palindrome expands from center.
 *  left = right = i, when it is the odd case "aba"
 *  left = i, right = i + 1, when it is even case "abba"
 */
private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left   = left - 1;
        right = right + 1;
    }
    return right - left - 1;
}
```