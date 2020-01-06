# Tree Representations

## How do we Represent a Tree in Java ?

### Approach 1a

![](img/1a.png)

### Approach 1b

![](img/1b.png)

### Approach 1c

![](img/1c.png)

### Approach 1

![](img/1.png)

### Approach 2

![](img/2.png)

### Approach 3

![](img/3.png)

We don't need a parents array, since it is complete tree, we can always find a node's parent.

## Deep dive into Approach 3

### How to find a node's parent

![](img/parent.png)

```java
public int parent(int k) {
    return (k-1)/2;
}
```

Small note: in java

```java
9/2 = 4
8/2 = 4
```

## Summary

![](img/summary.png)

![](img/summary2.png)