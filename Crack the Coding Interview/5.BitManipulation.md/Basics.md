# Basics of Bit Manipulation

## Bitwise OR

"|" : takes 2 operands. 

The bitwise operator compares the corresponding bits of the two operands. 

If any of the operand bit is 1 then the output is 1 it not it will be 0.

Example:

```
15 = 00001111 (In binary)
or      |
27 = 00011011 (In binary)
    
   = 00011111 (In binary)

   = 31 (In decimal)
```

---

## Bitwise AND

"&" : takes 2 operands. 

If both the operand bits are 1 then the output is 1 otherwise 0.

Example:

```
15 = 00001111 (In binary)
or      &
27 = 00011011 (In binary)
   = 00001011 (In binary)
   = 1 * 2^0 + 1 * 2^1 + 0 + 1 * 2^3
   = 11
```

---

## Bitwise Complement

"~" : takes one operand

This operator inverts the bit of the operand. Converts 1 to 0 and 0 to 1.

Example:

```
15 = 00001111 (In Binary)
Bitwise complement Operation of 15
~ 00001111
= 11110000
= 2^4 + 2^5 + 2^6 + 2^7
= 16 + 32 + 64 + 128 
= 240 (in decimal)
```

---

## Bitwise XOR

"^" : takes 2 operands.

This operator compares the corresponding bits of the two operands. If the corresponding bits of the two operands are differnt then it gives 1 as an output else 0.

Exclusive OR: it returns 1 when it is (1,0) or (0,1)

Example:
```
15 = 00001111 (In Binary)
27 = 00011011 (In Binary)
Bitwise XOR Operation of 15 and 27
  00001111
^ 00011011
________
  00010100  = 20 (In decimal)
```

---

## Signed Left Shift

"<< x" : shift the bit pattern to the left by x times.

is Equivalent to multiply the bit pattern with 2^x.

Example:

```
123                       (In binary: 01111011)
123 << 1 evaluates to 246 (In binary: 011110110)
123 << 2 evaluates to 492 (In binary: 0111101100)
123 << 3 evaluates to 984 (In binary: 01111011000)
```

---

## Signed Right Shift

">> x" : adds x zero bits shifted to the high order position.

is Equivalent to divide the bit pattern with 2^x.


```
123                      (In binary: 01111011)
123 >> 1 evaluates to 61 (In binary: 00111101)
123 >> 2 evaluates to 30 (In binary: 00011110)
123 >> 3 evaluates to 15 (In binary: 00001111)
```


---

Tricks:

```
x ^ 0s = x
x ^ 1s = ~x
x ^ x = 0
```

```
x & 0s = 0
x & 1s = x
x & x = x
```

```
x | 0s = x
x | 1s = 1s
x | x = x
```

---

## Two's Complement and Negative Numbers

-K(negative K) as a N-bit number is concat(1, 2^(N-1) - k)

Example:

-3 as a 4-bit integer. If it's 4 bit, we have one bit for the sign, and three bits for the value. 

we want the complement with respect to 2^3 = 8. The complement of 3 with respect to 8 is 5. turn 5 into binary is 101, 

Therefor, -3 in binary as a 4-bit number is 1101, with the first being the sign bit.

---

Another way to look at this is that we invert the bits in the positive representation and then add 1.

Example:
```
3 = 011
flip the bits
    100
add 1 
    101
prepend 1 for the sign
   1101
```

---

## Arithmetic vs. Logical Right Shift

1. Arithmetic right shift: divides by two, ">>"

Shift everything to right by 1, the last digit disappears, and we add 1 for the negative sign.

```
-75 = 1 0 1 1 0 1 0 1
-38 = 1 1 0 1 1 0 1 0   
   sign
```

2. Logical right shift: ">>>"

Does what we visually see as shifting the bits.

```
-75 = 1 0 1 1 0 1 0 1
        1 0 1 1 0 1 0
then put 0 in the front
90  = 0 1 0 1 1 0 1 0
```

---

## Questions:

What do you think these functions would do on parameters x = -93242 and count = 40?

```java
int repeatedArithmeticShift(int x, int count) {
  for (int i = 0; i < count; i++) {
    x >>= 1;  // Arithmetic shift by 1
  }
  return x;
}

int repeatedLogicShift(int x, int count) {
  for (int i = 0; i < count; i++) {
    x >>>= 1;  // Logical shift by 1
  }
  return x;
}
```

Logical gives us 0: we are putting a 0 into the most significant bit repeatedly.

Arithmetic shift gives us -1: because we are shifting a 1 into the most significant bit repeatedly. A sequence of all 1s in a (signed) integer represents -1.

---

## Common bit tasks: Getting and Setting

Get Bit

```java
/** Returns true if num has 1 at bit i. */
boolean getBit(int num, int i) {
  // 1. we shift i by i bits, we have something like 000100000
  // 2. perfrom AND with num, we clear all bits other than at bit i.
  // 3. compare this value to 0, if it is 0, then that bit is 0, if it is not 0, then that bit has 1.
  return ((num & (1 << i)) != 0); 
}
```

---

Set Bit

```java
/* Set the ith bit of num to 1. */
int setBit(int num, int i) {
  // 1. Shift 1 by i bits, we have 00010000.
  // 2. perfrom OR on num and 00010000. 
  // All other bits stay the same, and bit i is made sure become 1.
  return num | (1 << i);
}
```

---

Clear Bit

```java
/* Clear the bit at ith bit of num. */
int clearBit(int num, int i) {
  // 1. shift 1 by i bits, we have 00010000.
  // 2. perform COMPLEMENT on that,11101111.
  // we have 0 on bit i.
  int mask = ~(1 << i);
  // 3. peform AND on num, everything else stay same, ith bit becomes 0.
  return num & mask;
}
```

```java
/* Clear all bits from most significant bit to i(inclusive). */
int clearBitsFromHeadToI(int num, int i) {
  // 1. 1<<i : 00010000
  // 2. -1   : 00001111
  int mask = (1 << i) - 1;
  // 11111001 & 00001111 = 00001001 
  // we cleared all bits from The head to ith bit.
  return num & mask;
}
```

```java
/* Clear all bits from bit i to bit 0(inclusive). */
int clearBitsFromIToZero(int num, int i) {
  // 1. -1 = 11111111...1111
  // 2. -1 << (i + 1)
  // = 11110000
  int mask = (-1 << (i + 1));
  // 10011111 & 11110000 = 10010000
  return num & mask;
}
```

---

Update Bit

```java
int updateBit(int num, int i, boolean bitIs1) {
  // 0. find out value is 1 or 0
  int value = bitIs1 ? 1 : 0;
  // 1. shift 1 by i bits, we have 00010000
  //    take ~: 11101111, 0 at bit i.
  int mask = ~(1 << i);
  // 2. num & mask: change bit i of num to 0.
  // 3. shift value to bit i.
  // 4. | : change bit i to value.
  return (num & mask) | (value << i);
}
```