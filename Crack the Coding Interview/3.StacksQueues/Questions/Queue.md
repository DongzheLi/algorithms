# Queue

First-in, first-out. Like a line or queue at a ticket lane.

![](img/Queue.png)

Operations:

+ enqueue(item): Add an item to the end of the list.
+ dequeue(item): remove the first item in the list.
+ peek(): return the front of the queue.
+ isEmpty(): Return true iff the queue is empty.

```java
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;       // beginning of queue
    private Node<Item> last;       // end of queue
    private int n;                 // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    
    // Initializes an empty queue
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    // Returns true if this queue is empty.
    public boolean isEmpty() { return first == null;}
    // Returns the number of items in this queue.
    public int size() {return n;}

    // Returns the item least recently added to this queue.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    // Adds the item to this queue. (to the end)
    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        n++;
    }
    // Removes and returns the item on this queue. (from the front)
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");

        Item returnedItem = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;     // to avoid loitering
        return item;
    }
}
```