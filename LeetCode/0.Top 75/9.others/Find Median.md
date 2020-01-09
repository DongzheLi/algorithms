# Find Median from Data Stream

Example :

```
[2,3,4]
Median = 3,

[1,2,3,4]
Median = (2+3)/2 = 2.5
```


Example:

```
addNum(1)
addNum(2)
findMedian() => 1.5
addNum(3)
findMedian() => 2
```

```java
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {
    // holds the larger half of the elements, and when largerHalf.pop() called, it returns the least element in it.
    Private Queue<Long> largerHalf = new PriorityQueue<>();
    // holds the smaller half of the elements, and when smallerHalf.pop() called, it returns the largest element in it.
    Private Queue<Long> smallerHalf = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        smallerHalf.offer(num);
        largerHalf.offer(smallerHalf.poll());
        if (smallerHalf.size() < largerHalf.size()) smallerHalf.offer(largerHalf.pop());    
    }
    
    public double findMedian() {
        if (smallerHalf.size() == largerHalf.size()) return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        return smallerHalf.peek();
    }
}
```

