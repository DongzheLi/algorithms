# Top K frequent Elements

Given a non-empty array of integers, return the **k** most frequent elements.

Example :

```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Input: nums = [1], k = 1
Output: [1]
```

## Solution : Priority Queue : MaxHeap

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    // Frequency table : maps each number to its frequency
    Map<Integer, Integer> count = new HashMap<>();

    for (int num : nums) {
        count.put(num, count.getOrDefault(num, 0) + 1);
    }

    // Initialize Priority Queue
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
        @Override
        public int compare(int i, int j) {
            return count.get(i) - count.get(j);
        }
    });
    // Put all elements from frequency table to PQ, keep top K elements
    for (int n : count.keySet()) {
        maxHeap.add(n);
    }
    // Initialize result List
    List<Integer> result = new ArrayList<>();
    // Dump the first K elements from maxHeap into result list
    while (result.size() < k) {
        int top = maxHeap.poll();
        result.add(top);
    }
    return result;
}
```

PriorityQueue.offer(E e) : inserts the element into pq.

PriorityQueue.poll(E e) : retrives and removes the head of pq.


## Solution 2: Use MinHeap, more elegant

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    // Frequency table
    Map<Integer, Integer> map = new HashMap<>();
    for(int n: nums){
        map.put(n, map.getOrDefault(n,0)+1);
    }

    PriorityQueue<Integer>> minHeap =
        new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));

    for(int n: map.keySet()){
        minHeap.add(entry);
        if (minHeap.size() > k) minHeap.poll(); 
    }

    List<Integer> res = new ArrayList<>();
    while(res.size()<k){
        res.add(heap.poll());
    }
    return res;
}
```