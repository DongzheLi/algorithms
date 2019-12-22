# Stack.

Stack is last-in first-out ordering. Imagine a stck of dinner plates.

![](img/stack.png)

Operations:

+ pop(): Remove the top item from the stack.
+ push(item): Add an item to the top of the stack.
+ peek(): Return the top of the stack.
+ isEmpty(): Return true iff the stack is empty.

```java
public class Stack<Item> implements Iterable<Item> {
    private int n;      // size of the stack
    private Node first;  // top of the stack

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    // Initialize an empty stack.
    public Stack() {
        first = null;
        n = 0;
    }
    // Returns true if this stack is empty
    public boolean isEmpty() {
        return first == null;
    }
    // Returns the number of items in this stack
    public int size() {
        return n;
    }
    // Adds the item to the top of the stack
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }
    // Removes and returns the top item
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item; //save item to return
        first = first.next;     // delete first item
        n--;
        return item;            // return the saved item
    }
    // Returns(do not remove) the top item
    public Item peek() {
        return first.item;
    }
}
```