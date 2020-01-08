# Number of 1 Bits

Write a function that takes an unsigned integer and return the number of '1' bits it has.

## Solution 1: Loop thru with a mask

```java
public int hammingWeight(int n) {
    int count = 0;
    int mask = 1;

    for (int i = 0; i < 32; i++) {
        if ((n & mask) != 0) count++;
        mask = mask << 1;
    }
    return count;
}
```

## Solution 2: n & n-1

```java
public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
}
```