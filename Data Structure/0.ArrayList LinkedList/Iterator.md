# Data Types in the Abstract

## 2.1 Iterators

Question: How are we going to get items out of a collection???

For **Array** :

```java
for (int i = 0; i < A.length; i++) {
    System.out.println(A[i] + ", ");
}
```

Array has a natural notion of an Nth element. But what about other colllections?? Sets? Maps?

Question: How to get itmes from a collection withoug indices, or possibly without relying on ordering at all.

---

## The Iterator Interface

**java.util.Iterator**

```java
package java.util;

public interface Iterator <T> {
    /** True iff there are more items. */
    boolean hashNext();
    /** Advance THIS to next item and return it. */
    T next();
    /** Remove the last item delivered by next() from the collection  * being iterated over. Optional operation: may throw
     * UnsupportedOperationException if removal is not possible. */
    void remove();
}
```

This is how we do it.

**java.util.Iterable**

```java
public interface Iterable<T> {
    Iterator<T> iterator();
}
```

-------

1. Our class needs to implement Iterable interface
2. Have own MyIterator class that implements Iterator interface

```java
public class MySet<T> implements Iterable<T> {
    ...
    ...
    @Override
    public Iterator<T> iterator() {return new MySetIterator();}

    private class MySetIterator implements Iterator<T> {
        ...
        ...
        @Override
        public boolean hasNext() {...;}
        @Override
        public T next() {...;}
    }
}
```

Now we can use the enhanced `for` loop:

```java
for (String i : C) 
    System.out.println(i + " ");
```

Which is equivalent to :

```java
for (Iterator<String> p = C.iterator(); p.hasNext();) {
    String i = p.next();
    System.out.println(i + " ");
}
```

------

## 2.2 The Java Collection Abstractions