Chapter -18 Hashing and heaps
Runtime of add, contains, and remove: O(1) !!
•	abstract data type (ADT): A specification of a collection of data and the operations that can be performed on it.
•	
•	set: A collection of unique values (no duplicates allowed)
	that can perform the following operations efficiently:
•	add, remove, search (contains)

•	public interface IntSet {
•		    void add(int value);
•		    boolean contains(int value);
•		    void clear();
•		    boolean isEmpty();
•		    void remove(int value);
•		    int size();
•		}
•	hash: To map a large domain of values to a smaller fixed domain.
•	Typically, mapping a set of elements to integer indexes in an array.
•	Idea: Store any given element value in a particular predictable index.
•	That way, adding / removing / looking for it are constant-time (O(1)).

•	hash table: An array that stores elements via hashing.
    hash function: An algorithm that maps values to indexes.
•	hash code: The output of a hash function for a given value.
•	
    "hash function" was:  hash(i) - i
•	Potentially requires a large array  (a.length > i).

•	Doesn't work for negative numbers.'
•	Array could be very sparse, mostly empty  (memory waste).
•	To deal with negative numbers: 	hash(i) - abs(i)
•	To deal with large numbers:	hash(i) - abs(i) % length

private int hash(int i) {
		    return Math.abs(i) % elements.length;
}
public class HashIntSet implements IntSet {
	    private int[] elements;
	    ...
	    public void add(int value) {
	        elements[hash(value)] = value;
	    }
	    public boolean contains(int value) {
	        return elements[hash(value)] == value;
	    }
	    public void remove(int value) {
	        elements[hash(value)] = 0;
	    }
	}
–	Runtime of add, contains, and remove: O(1) !!

collision: When hash function maps 2 values to same index

Method to solve the collision: 
1.	probing: Resolving a collision by moving to another index.
a.	linear probing: Moves to the next available index  (wraps if needed).

public class HashIntSet implements IntSet {
    private int[] elements;
    private int size;
    // constructs new empty set
    public HashIntSet() {
        elements = new int[10];
        size = 0;
    }
    // hash function maps values to indexes
    private int hash(int value) {
        return Math.abs(value) % elements.length;
    }
    ...
Implement Add function : 

public void add(int value) {
	    int h = hash(value);
	    while (elements[h] != 0 &&  elements[h] != value && elements[h] != REMOVED) {      // linear probing
	        h = (h + 1) % elements.length;  // for empty slot
	    }
	    if (elements[h] != value) {         // avoid duplicates
	        elements[h] = value;
	        size++;
	    }
	}
Implement Contains: 
public boolean contains(int value) {
	    int h = hash(value);
	    while (elements[h] != 0) {
	        if (elements[h] == value) {     // linear probing
	            return true;                // to search
	        }
	        h = (h + 1) % elements.length;
	    }
	    return false;                       // not found
	}
Implement remove function: 
public void remove(int value) {
	    int h = hash(value);
	    while (elements[h] != 0 && elements[h] != value) {
	         h = (h + 1) % elements.length;
	    }
	    if (elements[h] == value) {
	        elements[h] = -999;   // "removed" flag value
	        size--;
	    }
	}

Method 2: 
rehash: Growing to a larger array when the table is too full.
–	Cannot simply copy the old array to a new one.  (Why not?)
load factor: ratio of (num of elements ) / (hash table length )
–	many collections rehash when load factor ≅ .75

    private void rehash() {
        int[] old = elements;
        elements = new int[2 * old.length];
        size = 0;
        for (int value : old) {
            if (value != 0 && value != REMOVED) {
                add(value);
            }
        }
    }
    public void add(int value) {
        if ((double) size / elements.length >= 0.75) {
            rehash();
        }
        ...
    }

Method 3: 
separate chaining: Solving collisions by storing a list at each index.

 -add/contains/remove must traverse lists, but the lists are short
 -impossible to "run out" of indexes, unlike with probing

public class HashIntSet implements IntSet {
    // array of linked lists;
    // elements[i] = front of list #i (null if empty)
    private Node[] elements;
    private int size;
    // constructs new empty set
    public HashIntSet() {
        elements = new Node[10];
        size = 0;
    }
    // hash function maps values to indexes
    private int hash(int value) {
        return Math.abs(value) % elements.length;
    }
    ...

    public void add(int value) {
        if (!contains(value)) {
            int h = hash(value);             // add to front
            Node newNode = new Node(value);  // of list #h
            newNode.next = elements[h];
            elements[h] = newNode;
            size++;
        }
    }

public boolean contains(int value) {
    Node current = elements[hash(value)];
    while (current != null) {
        if (current.data == value) {
            return true;
        }
        current = current.next;
    }
    return false;
}

public void remove(int value) {
    int h = hash(value);
    if (elements[h] != null && elements[h].data == value) {
        elements[h] = elements[h].next;  // front case
        size--;
    } else {
        Node current = elements[h];      // non-front case
        while (current != null && current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }
}

•	All Java objects contain the following method:
public int hashCode()
	Returns an integer hash code for this object.

•	You can write your own hashCode methods in classes you write.
–	All classes come with a default version based on memory address.
–	Your overridden version should somehow "add up" the object's state.
•	Often you scale/multiply parts of the result to distribute the results.
•	A hash map is like a set where the nodes store key/value pairs:
	public class HashMap<K, V> implements Map<K, V> {
	    ...
	}
public interface Map<K, V> {
	    void clear();
	    boolean containsKey(K key);
	    V get(K key);
	    boolean isEmpty();
	    void put(K key, V value);
	    void remove(int value);
	    int size();
	}




Hash map vs. hash set
–	The hashing is always done on the keys, not the values.
–	The contains method is now containsKey; there and in remove, you search for a node whose key matches a given key.
–	The add method is now put; if the given key is already there, you must replace its old value with the new one.

PQ:
•	priority queue: A collection of ordered elements that provides fast access to the minimum (or maximum) element.
–	add	adds in order
–	peek 	returns minimum or "highest priority" value
–	remove 	removes/returns minimum value
–	isEmpty, clear, size, iterator	O1

•	heap: A complete binary tree with vertical ordering.
–	complete tree: Every level is full except possibly the lowest level, which must be filled from left to right
•	(i.e., a node may not have any children until all possible siblings exist)
•	heap ordering: If P ≤ X  for every element X with parent P.
–	Parents' values are always smaller than those of their children.
–	Implies that minimum element is always the root (a "min-heap").
•	Variation: "max-heap" stores largest element at root, reverses ordering
•	The height of a complete tree is always log N.
•	Because of this, if we implement a priority queue using a heap, we can provide the following runtime guarantees:
–	add:	O(log N)
–	peek:	O1
-   remove:O(log N)

•	When an element is added to a heap, it should be initially placed as the rightmost leaf (to maintain the completeness property).
•	bubble up: To restore heap ordering, the newly added element is shifted ("bubbled") up the tree until it reaches its proper place.
•	A peek on a min-heap is trivial to perform.
•	because of heap properties, minimum element is always the root
•	O1 runtime
•	When the root is removed from a heap, it should be initially replaced by the rightmost leaf (to maintain completeness).
•	bubble down: To restore heap ordering, the new improper root is shifted ("bubbled") down the tree until it reaches its proper place.



•Though a heap is conceptually a binary tree,
since it is a complete tree, when implementing it
we actually can "cheat" and just use an array!
–	index of root = 1  (leave 0 empty to simplify the math)
–	for any node n at index i :
•	index of n.left   = 2i
index of n.right = 2i + 1

•	Since we will treat the array as a complete tree/heap, and walk up/down between parents/children, these methods are helpful:
// helpers for navigating indexes up/down the tree
private int parent(int index)        { return index/2; }
private int leftChild(int index)     { return index*2; }
private int rightChild(int index)    { return index*2 + 1; }
private boolean hasParent(int index) { return index > 1; }
private boolean hasLeftChild(int index) {
    return leftChild(index) <= size;
}
private boolean hasRightChild(int index) {
    return rightChild(index) <= size;
}
private void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
}

public void add(int value) {
    elements[size + 1] = value;  // add as rightmost leaf
    // "bubble up" as necessary to fix ordering
    int index = size + 1;
    boolean found = false;
    while (!found && hasParent(index)) {
        int parent = parent(index);
        if (elements[index] < elements[parent]) {
            swap(elements, index, parent(index));
            index = parent(index);
        } else {
            found = true;  // found proper location; stop
        }
    }
    size++;
}

public void add(int value) {
    // resize to enlarge the heap if necessary
    if (size == elements.length - 1) {
        elements = Arrays.copyOf(elements,
                                 2 * elements.length);
    }
    ...
}

Implement peek;
public int peek() {
    return elements[1];
}

Remove 
public int remove() {   // precondition: queue is not empty
    int result = elements[1];      // last leaf -> root
    elements[1] = elements[size];
    size--;
    int index = 1;    // "bubble down" to fix ordering
    boolean found = false;
    while (!found && hasLeftChild(index)) {
        int left = leftChild(index);
        int right = rightChild(index);
        int child = left;
        if (hasRightChild(index) &&
                elements[right] < elements[left]) {
            child = right;
        }
        if (elements[index] > elements[child]) {
            swap(elements, index, child);
            index = child;
        } else {
            found = true;  // found proper location; stop
        }
    }
    return result;
}

public interface PriorityQueue<E> {
	    void add(Element value);
	    void clear();
	    boolean isEmpty();
	    Element peek();        // return min element
	    Element remove();      // remove/return min element
	    int size();
	}

public void add(E value) {
    ...
    int index = size + 1;
    boolean found = false;
    while (!found && hasParent(index)) {
        int parent = parent(index);
        if (elements[index] < elements[parent]) {   // error
            swap(elements, index, parent(index));
            index = parent(index);
        } else {
            found = true;  // found proper location; stop
        }
    }
}

•	natural ordering: Rules governing the relative placement of all values of a given type.
–	Implies a notion of equality (like equals) but also < and > .
–	total ordering: All elements can be arranged in A ≤ B ≤ C ≤ ... order.
–	The Comparable interface provides a natural ordering.

Class HashSet<E>: 
HashSet<Integer> hs=new HashSet<>();
Set<Integer> hs = new HashSet<>();

Map<Integer, Integer> map = new HashMap<Integer, Integer>();

HashSet method: 
Constant time for basic operations(add,remove,contains,and size)

Constructor: 
HashSet();
HashSet(Collection<? extends E> c)
HashSet(int initialCapacity):default load factor;
HashSet(int initialCapacity, float loadFactor)

method: 
boolean  add(E e): adds the specified element to this set if it is not already present 
true if this set did not already contain the specified element;
void clear(): removes all of the elements from this set;

Object clone(): returns a shallow copy of this HashSet instance;

boolean contains(Object o): returns true if this set contains the specified element;

boolean isEmpty(): returns true if this set contains no elements;

Iterator<E> iterator: returns an iterator over the elements in this set 

boolean remove(Object o ): removes the specified element from this set if it is present;
true if the set contained the specified element;
int size() : returns the number of elements in this set;


Map<Integer, Integer> map = new HashMap<Integer, Integer>();

Class HashMap<K,V>
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
K:the type of keys maintained by this map;
V:the type of mapped values;

provides constant time performance for the basic operations for get and set; 
Constructor:
HashMap();
HashMap(int initialCapacity)
HashMap(int initialCapacity,floatFactor)
HashMap(Map<? extends K, ? extends V> m)

void clear() : removes all of the mappings from this map;
Object clone(): returns a shallow copy of this HashMap instance:the keys and values themselves are not cloned;

boolean containsKey(Object key): return true if this map contains a mapping for the specified key;

boolean containsValue(Object value):return true if this map maps one or more keys to the specified value;

Set<Map.Entry<K,V>> entrySet(): Returns a Set view of the mappings contained in this map.

Value get(Object key): returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

Value getOrDefault(Object key, V defaultValue):
returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

boolean isEmpty():
returns true if this map contains no key-value mappings;

Set<K> keySet()
returns a Set view of the keys contained in this map.

Value put(K key, V value): associates the specified value with the specified key in this map.

Value remove(Object key):removes the mapping for the specified key from this map if present.

boolean remove(Object key, Object value):removes the entry for the specified key only if it is currently mapped to the specified value.

Value replace(K key, V value):Replaces the entry for the specified key only if it is currently mapped to some value.

boolean replace(K key, V oldValue, V newValue) :Replaces the entry for the specified key only if currently mapped to the specified value.

int size(): returns the number of key-value mappings in this map

Collection<V> values: returns a collection view of the values contained in this map;


Priority Queue: 
priorityQueue:
The head of this queue is the least element with respect to the specified ordering;
The queue retrieval operations poll, remove, peek, and element access the element at the head of the queue;

A priority queue is unbounded, but has an internal capacity governing the size of an array used to store the elements on the queue;

ordered traversal: 
Arrays.sort(pq.toArray());

Constructor:
PriorityQueue(): creates a PriorityQueue with the default initial capacity(11) that orders its elements according to their natural ordering;

PriorityQueue(int initialCapacity, Comparator<? super E> comparator):
Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
Comparator: the comparator that will be used to order this priority queue. 
If null, the natural ordering of the elements will be used;

PriorityQueue(PriorityQueue<? extends E> c):
Creates a PriorityQueue containing the elements in the specified priority queue.


Method: 

boolean add(E e) inserts the specified element into this priority queue;
Return true;
void clear(): Removes all of the elements from this priority queue;

Comparator<? super E> comparator() :Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements
returns the comparator used to order this queue,or null if this queue is sorted according to the natural ordering of its elements;

boolean contains(Object o): returns true if this queue contains the specified element;
true if this queue contains the specified element;

boolean offer(E e) ： Insert the specified element into this priority queue;
return true; 

E peek():Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
return the head of this queue, or null if this queue is empty;

E poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
return the head of this queue,or null if this queue is empty;

boolean remove(Object o): Removes a single instance of the specified element from this queue, if it is present.
true if this queue changed as a result of the call;

int size():Returns the number of elements in this collection.

Object[] toArray(): Returns an array containing all of the elements in this queue.
return an array containing all of the elements in this queue;



