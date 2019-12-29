# Group Anagrams

Given an array of strings, group anagrams together.

Example:

```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

---

This is basically the same question as the last one, slightly more complicated.

Because just how complicated the code is, I use sort a string to check anagram.

```java
public List<List<String>> groupAnagrams(String[] strs) {
    // (key, value) = str in strs, its list of anagrams
    Map<String, List<String>> map = new HashMap<>();

    for (String s: strs) {
        // s and t are anagrams if they are the same after sorting.
        char[] ca = s.toCharArray();    // "cba" => {'c', 'b', 'a'}
        Arrays.sort(ca);                //       => {'a', 'b', 'c'}
        String key = String.valueOf(ca);//       => "abc"
        // if map doesn't contain this key, we put it in
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        // else, we have found a anagram for existing key, add original string s to its value list
        map.get(key).add(s);
    }
    return new ArrayList(map.values());
}
```

Notes:

+ How to sort a String:

```java
String s = "cba";               //    "cba"
char[] ca = s.toCharArray();    // => {'c', 'b', 'a'}
Arrays.sort(ca);                // => {'a', 'b', 'c'}
String key = String.valueOf(ca);// => "abc"
```
