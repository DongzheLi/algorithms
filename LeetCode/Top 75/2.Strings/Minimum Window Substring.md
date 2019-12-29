# Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

---

Example:

```
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
```

Note:

+ If there is no such window in S that covers all characters in T, return empty string ""
+ If there is such window, there will always be only one unique minimum window in S.

---

My thoughts:

1. It is obviously sliding window, but how do we do that, we know the minimal length is T.length(). maximal length is S.length().

Algorithm:

```
left
A   D   O   B   E   C   O   D   E   B   A   N   C
right
Move right pointer until we contain T = "ABC". => ADOBEC
Move left  pointer until the window breaks, no longer contain T, => DOBEC, we start moving right pointer again
Move right pointer until we cantain T => "DOBECODEBA"
Move left pointer until the window breaks => "ODEBA", this step is a problem , we can use a map to keep occurances of each letter, or a ASCII table
Move right until we contain T, => "ODEBANC"
Move left                     => "BANC"
```

---

Implementation:

```java
public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) return "";
    // Use a HashMap to keep count of all unique characters in T.
    Map<Character, Integer> dict = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
        int count = dict.getOrDefault(t.charAt(i), 0);
        dict.put(t.charAt(i), count + 1);
    }
    // Our window has to be at least dict.size()
    int requiredSize = dict.size();
    // HashMap to keep count of all unique characters in current window
    Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
    // Keep track of how many unique characters of T are present in current window in desired frequency
    // e.g. it T = "AABBBC", then we need 2 "A", 3 "B", 1 "C" in our window, if we do, formed = 3.
    // if we only have 3 "B", then formed = 1.
    int formed = 0;
    // Left and Right pointer
    int left, right = 0;
    // Answer list
    int[] ans = {-1, 0, 0};

    while (right < s.length()) {
        // Move right by one, add one char to the window
        char c = s.charAt(right);
        int count = windowCounts.getOrDefault(c, 0);
        windowCounts.put(c, count + 1);

        // if the frequency of the current character = the desired count in dict, then increment formed.
        if (dict.containsKey(c) && windowCounts.get(c).intValue() == dict.get(c).intValue()) formed++;

        // move left pointer to shrink the window until it breaks, no longer contains T.
        // "Left" itself is not part of the window.
        while (left <= right && formed == required) {
            c = s.charAt(left);
            // save the smallest window until now.
            if (ans[0] == -1 || right - left + 1 < ans[0]) {
                // [6,3,4,9,2,10,3], right = 4, left = 1, length = 4 = right - left + 1
                ans[0] = right - left + 1;      // ans[0] = length   of our window
                ans[1] = left;                  // ans[1] = position of left pointer
                ans[2] = right;                 // ans[2] = position of right pointer
            }
            // Remove s[left] from window
            windowCounts.put(c, windowCounts.get(c) - 1);
            // if this has changed some desired frequency, change our formed variable
            if (dict.containsKey(c) && windowCounts.get(c).intValue() < dict.get(c).intValue()) formed--;
            // Move the left pointer
            left++;
        }
        right++;
    }
    if (ans[0] == -1) return "";
    return s.substring(ans[1], ans[2] + 1);
}
```

Notes : 

+ `Integer.intValue()` : [why use it](https://stackoverflow.com/questions/3131136/integers-caching-in-java?noredirect=1&lq=1%60)
+ `string.substring()` : [java doc](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#substring(int,int))