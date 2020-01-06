# Hash Overflow and Hash Codes

In java, the biggest integer is 2,147,483,647 = 2^32 - 1

+ If you go over this limit, you overflow, starting back over at the smallest integer, which is -2,147,483,648 = -2^32.
+ In other words, the next number after 2147483647 is -2147483648

![](img/overflow.png)

Consequence of Overflow: Collisions

With base 126, we will run into overflow even for short strings.

Example: omens in 126 = 28,196,917,171, which is way greater than the biggest integer.

---

## Two fundamental Challenges

How do we **Handle collision**

How do we **Compute HashCode**