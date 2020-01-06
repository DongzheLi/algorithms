import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {
    // Priority queue stores the Nodes from 0 to N.
    private ArrayList<Node> pq;
    // Items HashMap stores (item, its-index-in-array) (key, value) pair.
    private HashMap<T, Integer> items;

    private class Node { // Node as (item, priority) pair
        private T item;
        private double priority;

        // Constructor for Node
        public Node(T i, double p) {
            item = i;
            priority = p;
        }

        // Some getters and setters
        public T getItem() {
            return item;
        }

        public double getPriority() {
            return priority;
        }

        public void setPriority(double newP) {
            priority = newP;
        }
    }

    /** Initialize empty ArrayHeapMinPQ */
    public ArrayHeapMinPQ() {
        pq = new ArrayList<>();
        items = new HashMap<>();
    }

    /** Some helper methods, find parent, child */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Swap nodes at index i and index j Useful for swim up and sink down we swap
     * i,j in pq, and we set them in items.
     */
    private void swap(int i, int j) {
        Node temp = pq.get(i);
        pq.set(i, pq.get(j));
        pq.set(j, temp);

        items.put(pq.get(i).getItem(), i); // Associate (item, index) in HashMap items
        items.put(pq.get(j).getItem(), j);
    }

    /**
     * Return true if i.priority is less than j.priority.
     */
    private boolean lessThan(int i, int j) {
        return pq.get(i).getPriority() < pq.get(j).getPriority();
    }

    /** Swim up when node is too low in current position */
    private void swim(int i) {
        if (i > 0 && lessThan(i, parent(i))) {
            swap(i, parent(i));
            swim(parent(i));
        }
    }

    /** Sink down when node is too high in current position */
    private void sink(int i) {
        if (rightChild(i) < pq.size() && lessThan(rightChild(i), i)) {
            swap(i, rightChild(i));
            sink(rightChild(i));
        }

        if (leftChild(i) < pq.size() && lessThan(leftChild(i), i)) {
            swap(i, leftChild(i));
            sink(leftChild);
        }
    }

    /** All the public methods that implements ExtrinsicMinPQ */

    /**
     * Adds an item with the given priority value. Throws an
     * IllegalArgumentException if item is already present. You may assume that item
     * is nver null.
     */
    @Override
    public void add(T item, double priority) {
        if (contains(item))
            throw new IllegalArgumentException("Item already present.");
        Node n = new Node(item, priority);
        pq.add(n); // add the new node into priority queue.
        // To add a new item, we put it at the most right leave position, then swim it
        // up.
        items.put(item, size() - 1);
        swim(size() - 1);
    };

    /** Returns true if the PQ contains the given item. */
    @Override
    public boolean contains(T item) {
        return items.containsKey(item); // there is no natural fast way to do contains faster than O(N), so we keep a
                                        // HashMap
    };

    /**
     * Returns the minimum item. Throws NoSuchElementException if the PQ is empty.
     */
    @Overide
    public T getSmallest() {
        if (pq.isEmpty())
            throw new NoSuchElementException("PQ is empty.");
        return pq.get(0).item;
    };

    /**
     * Removes and returns the minimum item. Throws NoSuchElementException if the PQ
     * is empty.
     */
    @Override
    public T removeSmallest() {
        if (pq.isEmpty())
            throw new NoSuchElementException("PQ is empty.");
        T minimalItem = pq.get(0).getItem();
        // To remove smallest, i.e. root, we swap root with the last element, then
        // delete it.
        swap(0, size() - 1);
        pq.remove(size() - 1);
        items.remove(minimalItem);
        sink(0);

        return minimalItem;
    };

    /** Returns the number of items in the PQ. */
    @Override
    public int size() {
        return pq.size();
    };

    /**
     * Change the priority(ordering comparrison) of the given item. Throws
     * NoSuchElementException if the item doesn't exist.
     */
    @Override
    public void changePriority(T item, double priority) {
        if (!contains(item))
            throw new NoSuchElementException();

        int i = items.get(item); // get item's index
        Node n = pq.get(i); // get the corresponding node

        double oldPriority = n.getPriority();
        n.setPriority(priority);

        if (oldPriority < priority)
            sink(i);
        else
            swim(i);
    };

}