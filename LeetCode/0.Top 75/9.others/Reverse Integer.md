# Reverse Integer

123 -> 321,  -123 -> -321, 120 -> 21

```java
public int reverse(int x) {
    int rev = 0;

    while (x != 0) {        // x = 1234
        int pop = x % 10;   // last digit of x, pop = 4
        x = x / 10;         // `/` is integer division : x = 123
        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0; // make sure rev don't overflow
        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;// make sure rev don't overflow negative side
        rev = rev * 10 + pop;   // the classic how to get a number with centain base.
        // if it is base 7, rev = rev * 7 + pop;
    }
    return rev;
}
```
