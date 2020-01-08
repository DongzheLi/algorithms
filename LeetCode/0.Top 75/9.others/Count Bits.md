# Count Bits

For every non negative integer number num. For every number 0 <= i<= num calculate the number of 1's in their binary representation and return them as an array.


## Solution 

Even number ends with 0, odd number ends with 1.

Algorithm :

if num is even, then it ends with 0, then countBits(num) = countBits(num >> 1)

if num is odd, then it ends with 1, then countBits(num) = countBits(num >> 1) + 1

```java
public int[] countBits(int num) {
    int[] result = new int[num + 1];
    result[0] = 0;

    for (int i = 1; i <= num; i++) {
        if ((i & 1) == 0) {            // i.e. i ends with 0, i.e. i is even
            result[i] = res[i >> 1]; 
        } else {
            result[i] = res[i >> 1] + 1;
        }
    }
    return res;
}
```