/* HashTableChained.java */

package dict;

import list.DList;
import list.DListNode;
import list.InvalidNodeException;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
  protected DList[] hashTable;
  protected int buckets;
  protected int size;


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
	buckets = sizeEstimate * 8 / 10;
	if (isPrime(buckets)) {
		buckets++;
	}
	hashTable = new DList[buckets];
	for (int i = 0; i < buckets; i++) {
		hashTable[i] = new DList();
	}
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
	hashTable = new DList[101];
	buckets = 101;
	for (int i = 0; i < buckets; i++) {
		hashTable[i] = new DList();
	}
  }
  
  private boolean isPrime(int n) {
      boolean[] prime = new boolean[n + 1];                  
      int i;
      for (i = 2; i <= n; i++) {
        prime[i] = true;
      }
      for (int divisor = 2; divisor * divisor <= n; divisor++) {
          if (prime[divisor]) {
            for (i = 2 * divisor; i <= n; i = i + divisor) {
              prime[i] = false;
            }
          }
        }
      return prime[n];
  }


  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
	
	int reminder = ((7*code+19) % 20996011) % buckets;
	if (reminder < 0) {
		reminder = reminder + buckets;
	}
	return reminder;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return size == 0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
	Entry result = new Entry();
	result.key = key;
	result.value = value;
	
	size++;
	int i = compFunction(key.hashCode());
	hashTable[i].insertFront(result);
	reSize();
	
    return result;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
	int i = compFunction(key.hashCode());
	DListNode current = (DListNode) hashTable[i].front();
	while (current.isValidNode()) {
		try {
			Entry e = (Entry) current.item();
			if (e.key().equals(key)) {
				return e;
			}
			current = (DListNode) current.next();
		} catch (InvalidNodeException e) {
		}
		
	}
	return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
		int i = compFunction(key.hashCode());
		DListNode current = (DListNode) hashTable[i].front();
		while (current.isValidNode()) {
			try {
				Entry e = (Entry) current.item();
				if (e.key().equals(key)) {
					current.remove();
					size--;
					return e;
				}
				current = (DListNode) current.next();
			} catch (InvalidNodeException e) {}
		}
		return null;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
	size = 0;
	for (int i = 0; i < buckets; i++) {
		hashTable[i] = new DList();
	}
  }
  
  /**
   * resize the hash table if the load factor is bigger than 1.
   * @return a new hash table with roughly two times the size of the old hash table.
   */
  public void reSize() {
	  if (size > buckets) {
		  int s = buckets*2;
		  while (!isPrime(s)) {
			  s++;
		  }
		  DList[] oldTable = hashTable;
		  buckets = s;
		  hashTable = new DList[buckets];
		  for (int i = 0; i < buckets; i++) {
			  hashTable[i] = new DList();
		  }
		  for (DList b : oldTable) {
			  DListNode cur = (DListNode) b.front();
			  while (cur.isValidNode()) {
				  try {
					  insert(((Entry) cur.item()).key, ((Entry) cur.item()).value);
					  cur = (DListNode) cur.next();
				  } catch (InvalidNodeException e) {
				  }
			  }
		  }
	  }
  }

}
