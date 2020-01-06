public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size;                   // # of (key, value) pair in this map
    private int bucketsSize;            // HashMap size = buckets.length
    private int threshold;              // the bucketsSize = threshold, reszie
    private Bucket<K, V>[] buckets;     // array of buckets.

    private class Bucket<K, V> {        // Each bucket : hashCode, (key, value), next->bucket
        private int hashCode;
        private K key;                  
        private V value;
        private Bucket<K, V> next;      // next pointer : points to another bucket that has the same hashcode.
        
        /** Constructor for a bucket. */
        public Bucket(int hc, K k, V v, Bucket<K, V> n) {
            hashCode = hc;
            key = k;
            value = v;
            next = n;
        }

        /** Getters and Setters for hashcode, key, value, next */
        public int getHashcode() {return hashcode;}
        public void setHashcode(int hc) {hashcode = hc;}
        public K getKey() {return key;}
        public void setKey(K k) {key = k;}
        public V getValue() {return value;}
        public void setValue(V v) {value = v;}
        public Bucket<K, V> getNext() {return next;}
        public void setNext(Bucket<K, V> b) {next = b;}
    }

    /** Constructor with no parameter, initialize buckets with default INITIAL_CAPACITY */
    public MyHashMap() {
        buckets = new Bucket[INITIAL_CAPACITY];             // [bucket1, bucket2, bucket3,....,bucket16]
        threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR); // default threshold = 12;
        size = 0;                                           // Initially, size = 0
        bucketsSize = INITIAL_CAPACITY;
    }

    /** Constructor with specified new Size. */
    public MyHashMap(int newSize) {
        buckets = new Bucket[newSize];
        threshold = (int) (newSize * LOAD_FACTOR);
        size = 0;
        bucketsSize = newSize;
    }

    /** Constructor with specified initialSize, and loadFactor */
    public MyHashMap(int initialSize, double loadFactor) {
        buckets = new Bucket[initialSize];
        threshold = (int) (initialSize * loadFactor);
        size = 0;
        bucketsSize = initialSize;
    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        buckets = new Bucket[bucketsSize];                  // new Bucket[] with same size as before
        size = 0;
    }

    /** Validate key */
    private void validate(K key) {
        if (key == null) throw new IllegalArgumentException();
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        validate(key);
        return get(key) != null;
    }

    /** Rewrite the hashCode for K key */
    private int hash(K key, int length) {
        validate(key);
        // 0x7fffffff = 0|111|1111|...|1111, use a "&" operator, we make sure the sign bit is 0,
        // the hashcode is positive, so we won't have -1 % 5 = -1 type of problem in java.
        return (key.hashCode() & 0x7fffffff) % length;
    }

    /** 
     * Returns the value to which the specified key is mapped,
     * null if the map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        validate(key);

        int hashCode = hash(key, bucketsSize);           // get the hashCode wrt bucketsSize.
        Bucket<K, V> b = get(hashCode, key);           // Private helper method: get the bucket with given (hashcode and key)
        return b == null ? null : b.getValue();
    }
    /** Returns the bucket that have the same hashcode and key. */
    private Bucket<K, V> get(int hashCode, K key) {
        Bucket<K, V> b = buckets[hashcode];                 // for every key, its hashcode will be 0,1,...,buckets.length-1
        while (b != null) {
            // need to match both hashcode and key
            if (b.getHashcode() == hashcode && b.getKey().equals(key)) return b;
            // otherwise, just go to horizontal next bucket
            b = b.getNext();
        }
        return null;
    }

    /** Returns the number of (key, value) mappings in this map. */
    @Override
    public int size() {return size;}

    /** 
     * Puts (key, value) in this map.
     * If the map already contains a value for this key, replace its value. 
     */
    @Override
    public void put(K key, V value) {
        int hashcode = hash(key, bucketsSize);  // hashcode derived from given key
        Bucket<K, V> b = buckets[hashcode];     // bucket that has index = given hashcode
        while (b != null) {
            if (b.getHashcode() == hashcode && b.getKey().equals(key)) {
                b.setValue(value);
                return;
            }
            b = b.getNext();
        }
        // we have arrived at the end of that chain of buckets
        // create a new bucket with (hashcode, key ,value)
        put(hashcode, key, value);
    }
    /** Helper for creating a new bucket with given (hashcode, key, value) at given hashcode bucket. */
    private void put(int hashcode, K key, V value) {
        Bucket<K, V> nb = new Bucket<>(hashcode, key, value, buckets[hashcode]);        // nb.next = original first bucket at this hashcode position
        buckets[hashcode] = nb;                   // put the new bucket into buckets hashcode index
        size += 1;
        if (size > threshold) resize(bucketsSize * 2);
    }

    /** Helper method: Resize buckets, when number_of_(key,value) paris > threshold */
    private void resize(int capacity) {
        Bucket<K, V>[] newBuckets = new Bucket[capacity];       // new buckets array with given capacity
        for (int i = 0; i < bucketsSize; i++) {                 // iterate old buckets
            Bucket<K, V> b = buckets[i];                        // go to each starting bucket at each index
            while (b != null) {
                Bucket<K, V> oldNext = b.getNext();             // oldNext = b.next
                int newHashcode = hash(b.getKey(), capacity);   // calculate the new hashcode
                b.setNext(newBuckets[newHashcode]);             // link b.next to newBuckets[newHashcode]
                b.setHashcode(newHashcode);                     // change b's hashcode
                newBuckets[newHashcode] = b;                    // put b at newBuckets[newHashcode]
                b = oldNext;                                    // repeat with b.next
            }
        }
        buckets = newBuckets;
        bucketsSize = capacity;
        threshold = (int) (bucketSize * LOAD_FACTOR);
    }

    /** Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < buckets.length; i += 1) {
            Bucket<K, V> b = buckets[i];
            while (b != null) {
                keys.add(b.getKey());
                b = b.getNext();
            }
        };
        return keys;
    };
    
    @Override
    public Iterator<K> iterator() {
        return keySet.iterator();
    }

    @Override
    public V remove(K key) {
        validate(IllegalArgumentException);

        int hc = hash(key, bucketsSize);
        return remove(hc, key);
    }

    private V remove(int hashcode, K key) {
        Bucket<K, V> b = buckets[hashcode];         // find chain of buckets at buckets[hashcode]
        Bucket<K, V> nextB = b.getNext();

        if (b.getKey().equals(key)) {               // we found the right basket, matches hashcodde and key
            V toRemove = b.getValue();
            buckets[hashcode] = nextB;              // put nextB into buckets[hashcode]
            size -= 1;
            return toRemove;
        } else {                                    // the first bucket at buckets[hashcode] is not what we are looking for.
            while (!nextB.getKey().equals(key)) {   // keep doing b.next.next, until we found a match with given key.
                b = b.getNext();
                nextB = nextB.getNext();
            }
            V toRemove = nextB.getValue();          // delete one link between linkedlists chain
            b.setNext(nextB.getNext());
            size -= 1;
            return toRemove;
        }
    }
}