# Longest Repeating Character Replacement

Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

In one operation, you can choose any character of the string and change it to any other uppercase English character.

Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

---

Example:

```
Input:
s = "ABAB", k = 2
Output:
4
Explanation:
Replace the two 'A's with two 'B's or vice versa.
```

```
Input:
s = "AABABBA", k = 1
Output:
4
Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
```

---

Solution: **Sliding window** with character table int[26]

idea: s[i,j), initially i = j. for each window starts at i, we want to find the most frequent character + k opeartions to make, that is the longest repeating character substring start at i.

Algorithm:

+ initialize:
   
   + charTable int[26]
   + sliding window: i = 0, j = 0.
   + we want to count the most frequent char: maxCount = 0
   + The value to return: maxLength

```java
public int characterReplacement(String s, int k) {
    int n = s.length();
    // character counts
    int[] charTable = new int[26];
    // frequencey of most appeared character
    int maxCount = 0;
    // the value to return
    int maxLength = 0;

    for (int i = 0, j = 0; j < n; j++) {
        // increase the count of that character
        charTable[s.charAt(j) - 'A']++;
        // update max count to be max(current one, the newly counted character)
        maxCount = Math.max(maxCount, charTable[s.charAt(j) - 'A']);
        // if we can't make operations, we decrease the frequency of s.charAt(i), and slide i.
        while (j - i - maxCount + 1 > k) {
            charTable[s.charAt(i) - 'A']--;
            i++;
        }
        maxLength = Math.max(maxLength, j - i + 1);
    }
    return maxLength;
}
```