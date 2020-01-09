# Merge K Sorted Lists

Merge K sorted linked lists and return it as one sorted list.

```
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

## Solution 1 : A priority queue solution

```java
public ListNode mergeKLists(List<ListNode> lists) {
    if (lists == null || lists.size() == 0) return null;

    PriorityQueue<ListNode> minPQ = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    })

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    for (ListNode node : lists) {
        if (node != null) minPQ.add(node);
    }

    while (!minPQ.isEmpty()) {
        tail.next = minPQ.roll(); // tail.next is the smallest element in minPQ
        tail = tail.next;

        if (tail.next != null) queue.add(tail.next);
    }
    return dummy.next;
}
```

## Solution 2 : Merge two Linked Lists

```java
/** Merge Two Lists */
public ListNode mergeLists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail      = dummyHead;

    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next
        }
        tail = tail.next;
    }
    // only one of them would have some left
    if (l1 != null) tail.next = l1;
    if (l2 != null) tail.next = l2;

    return dummyHead.next;
}

public ListNode mergeKLists(List<ListNode> lists) {
    if (lists.isEmpty())   return null;
    if (lists.length == 1) return lists[0];

    ListNode head = mergeTwoLists(lists[0], lists[1]);

    for (int i = 2; i < lists.length; i++) {
        head = mergeTwoLists(head, lists[i]);
    }
    
    return head;
}
```