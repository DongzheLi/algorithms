# Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

---

Example:

```
Input: "A man, a plan, a canal: Panama"
Output: true

Input: "race a car"
Output: false
```

## Solution 1:

```java
public boolean isPalindrome(String s) {
    String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

    String reversed = new StringBuffer(actual).reverse().toString();

    return actual.equals(reversed);

}
```

## Solution 2: two pointer

```java
public boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i <= j;) {
        char head = s.charAt(i);
        char tail = s.charAt(j);
        // if s[i] is not alphanumeric, i++
        if      (!Character.isLetterOrDigit(head)) i++;
        // if s[j] is not alphanumeric, i--
        else if (!Character.isLetterOrDigit(tail)) j--;
        // if s[i] != s[j] return false
        else if (Character.toLowerCase(head) != Character.toLowerCase(tail)) return false;
        // move the pointers
        else {
            i++;
            j--;
        }
    }
    return true;
}
```

Notes: 

+ Some Character API: `Character.isLetterOrDigit()`, `Character.toLowerCase()`