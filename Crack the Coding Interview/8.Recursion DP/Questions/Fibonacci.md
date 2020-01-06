# Fibonacci number

# 1. Recursive

```java
int fibonacci(int i) {
    if (i == 0) return 0;
    if (i == 1) return 1;
    return fibonacci(i - 1) + fibonacci(i - 2);
}
```

The recursion Tree

```
                  fib(5)
          fiib(4)          fib(3)
    fib(3)    fib(2)      fib(2)    fib(1)
 fib(2)  fib(1)  fib(1) fib(0) fib(1) fib(0) 

```

Drawing the recursive calls as a tree and count its nodes is a great way to figure out the runtime of a recursive algorihtm.

Runtime: O(2^n)

# 2. Recursion with Memorization

We cache the results of fib(i) between calls.

```java
int fibonacci(int n) {
    return fibonacci(n, new int[n + 1]);
}

int fibonacci(int i, int[] memo) {
    if (i == 0 || i == 1) return i;

    if (memo[i] == 0) {
        memo[i] = fibonacci(i-1, memo) + fibonacci(i - 2, memo);
    }
    return memo[i];
}
```

# 3. Bottom-up Dynamic Programming

Doing the same as Recursion with Memorization, but in reverse

```java
int fibonacci(int n) {
    if (n == 0) return n;
    else if (n == 1) return 1;

    int[] memo = new int[n];
    memo[0] = 0;
    memo[1] = 1;
    for (int i = 2; i < n; i++) {
        memo[i] = memo[i - 1] + memo[i - 2];
    }
    return memo[n - 1] + memo[n - 2];
}
```

We don't need to remember all the values, we only need memo[i] for memo[i+1] and memo[i+2]

```java
int fibonacci(int n) {
    if (n == 0) return 0;
    int a = 0;
    int b = 1;
    for (int i = 2; i < n; i++) {
        int c = a + b;
        a = b;
        b = c;
    }
    return a + b;
}
```