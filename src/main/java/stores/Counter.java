package stores;

import interfaces.ICounter;

/**
* A generic implementation of the ICounter iterface.
*/
public class Counter<E> implements ICounter<E> {

    MyArrayList<Count<E>> counts = new MyArrayList<>();
    
    // INCOMPLETE.
    public int getCount(E element) {
        // Returns the count of an item (the number of times it was added to the list).
	for (int i = 0; i < counts.size(); i++) {
	    if (counts.get(i).getObj() == element) {
		return counts.get(i).getCount();
	    }
	}
        return 0;
    }

    // INCOMPLETE.
    public boolean add(E element) {
        Count<E> count = find(element);
        if (count == null) {
            // If the element does not exist, add it as a new count object to counts.
	    Count<E> newObject = new Count<>(element, 1);  //change type
	    counts.add(newObject);  // add new element
	    
        } else {
            // If the element does exist, increment its count value.
	    count.incrementCount();
        }
        return true;
    }

    // INCOMPLETE.
    public int size() {
        // Returns the total count of all items in the list.
	int total_count = 0;
	if (counts.size() == 0) {
	    return 0;
	}
	for (int i = 0; i < counts.size(); i++) {
	    total_count = total_count + counts.get(i).getCount();
	}
	return total_count;
    }

    // Returns the count object related to element.
    // Returns null if the element does not exist.
    private Count<E> find(E element) {
        for (int i=0;i<counts.size();i++) {
            if (counts.get(i).getObj().equals(element)) {
                return counts.get(i);
            }
        }
        return null;
    }

    public void clear() {
        counts.clear();
    }

    public boolean contains(E element) {
        return find(element) != null;
    }

    public boolean isEmpty() {
        return counts.isEmpty();
    }

    public boolean remove(E element) {
        Count<E> count = find(element);
        if (count == null) return false;
        else return counts.remove(count);
    }

}
