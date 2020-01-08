# Sum of Two Integers

Don't use `+` and `-`.

```java
public int getSum(int a, int b) {
    while (b != 0) {
        int carry = a & b;
        a = a ^ b;
        b = carry << 1;
    }
}
```


This question is actually suprisingly hard.