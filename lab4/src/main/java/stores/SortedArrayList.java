package stores;

public class SortedArrayList<E extends Comparable<E>> extends ArrayList<E> {
    
    public SortedArrayList() {
        super();
    }
    
    // INCOMPLETE.
    public boolean add(E element) {
        // Method to add element to the list, inserted in the correct place for the ordering of E.
	if (super.isEmpty()) {
	    super.add(element);
	    return true;
	}
	for (int i = 0; i < super.size(); i++) {

	    if (element.compareTo(super.get(super.size() - 1)) > 0) {
		super.add(element);
		return true;
		
	    }
	    else if ((element.compareTo(super.get(i)) > 0) && (element.compareTo(super.get(i + 1)) < 0)) {
		super.add(super.get(super.size() - 1));
		for (int j = super.size() - 2; j > i; j--) {
			super.set(j+1, super.get(j));
		}
	        super.set(i+1, element);
		return true;
	    }
            else if (element.compareTo(super.get(0)) < 0) {
		super.add(super.get(super.size() - 1));
		for (int j = super.size() - 2; j > -1; j--) {
		    super.set(j+1, super.get(j));
		}
		super.set(i, element);
		return true;
	    }
	    else if (element.compareTo(super.get(i)) == 0) {
		super.add(super.get(super.size() - 1));
	        for (int j = super.size() - 2; j > i - 1; j--) {
			super.set(j + 1, super.get(j));
	        }
		super.set(i, element);
		return true;
	    }
        }
        return true; // This will mean elements are stored in the order that they were added
    }

    // INCOMPLETE.
    public int findLinear(E element) {
        //returns the number of comparisons required to find element using Linear Search.
	int count = 0;
	for (int i = 0; i < super.size(); i++) {
	    if (element.compareTo(super.get(i)) == 0) {
		count++;
		return count;
	    }
	    else if (element.compareTo(super.get(0)) < 0) {
		count++;
		return count;
	    }
	    else if (element.compareTo(super.get(i)) > 0) {
		count++;
	    }
	    else if (element.compareTo(super.get(i)) < 0) {
		count++;
		return count;
	    }
	}
	    
        return count;
    }
    
    // INCOMPLETE.
    public int findBinary(E element) {
        //returns the number of comparisons required to find element using Binary Search.
	int count = 0;
	int l = 0;
	int r = super.size() - 1;
	int mid = (r + l + 1)/2;
	if (super.isEmpty()) {
	    return 0;
	}
	while (!(r < l)) {
	    if (super.get(mid).compareTo(element) < 0) {
		l = mid + 1;
		mid = (l + r +1) / 2;
		count++;
	    }
	    else if (super.get(mid).compareTo(element) > 0) {
		 r = mid - 1;
	         mid = (l + r +1) / 2;
		 count++;
		}
	    else {
		count++;
		return count;
	    }
	}
	count++;
        return count;
    }
    
    
}
