# Resizing Array Stack

The underlying structure is an Item[], it resizes when it reaches capacity.

## Implementation:

```java
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;       // array of items
    private int n;          // number of elements on stack

    // Initialize an empty stack.
    public ResizingArrayStack() {
        a = (Item[]) new Object[2];
        n = 0;
    }
    // Is this stack empty?
    public boolean isEmpty() { return n = 0; }
    // Returns the number of items in the stack.
    public int size() { return n; }

    // Resize the underlying array holding the elements.
    private void resize(int capacity) {
        assert capacity >= n;

        Item[] temp = (Item[]) new Object[capacity];
        // copy everything from a to temp
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
        // Alternative implementation
        // a = java.util.Arrays.copy(a, capacity)
    }

    // Add item to this tack, (top of the stack)
    public void push(Item item) {
        if (n == a.length) resize(2 * a.length);    // double size of array if necessary
        a[n++] = item           // add item, same as a[n] = item, n++
    }
    // Removes and returns the item recently added to this stack.
    // top of the stack
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");

        Item item = a[n-1]; // the last item, to be returned
        a[n-1] = null;
        n--;

        if (n >0 && n == a.length/4) resize(a.length/4);
        return item;
    }
    // Returns the item most recently added to this stack.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");

        return a[n-1];
    }
}
```