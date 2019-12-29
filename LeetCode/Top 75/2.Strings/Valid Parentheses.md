# Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

+ Open brackets must be closed by the same type of brackets.
+ Open brackets must be closed in the correct order.


Note that an empty string is also considered valid.

---

Solution:

```java
public boolean isValid(String s) {
    // Set up the mapping
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
        // if c is a closing bracket.
        if (map.containsKey(c)) {
            // if stack is currently empty, return false
            if (stack.isEmpty()) return false;
            // pop the top element of the stack
            char top = stack.pop();
            // if top element doesn't match with the closing bracket, return false;
            if (top != map.get(c)) return false;
        }
        // if c is a opening bracket, push it onto stack
        else {
            stack.push(c);
        }
    }
    // after pushing and poping to the end of s, if stack is not empty return false
    return stack.isEmpty();
}
```


Same idea, but just be smart.

```java
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
```

Example:
```
"( ) ( { [ ] } )"
stack = [], the first element is the top of the stack.
0. c = "(", stack = [")"]
1. c = ")", stack is not empty stack.pop() = ")", stack=[]
2. c = "(", stack = [")"]
3. c = "{", stack = ["}", ")"]
4. c = "[", stack = ["]", "}", ")"]
5. c = "]", stack.pop = "]" = c, stack = ["}", ")"]
6. c = "}", stack.pop = "}" = c, stack = [")"]
7. c = ")", stack.pop = ")" = c, stack = [].

We finsihed our loop. 
stack is empty, return true.
```