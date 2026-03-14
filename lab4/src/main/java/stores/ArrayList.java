package stores;

import java.util.Arrays;
import interfaces.IList;

/**
* A generic implementation of the IList iterface.
*/
public class ArrayList<E> implements IList<E> {

    private Object[] array;
    private int size;
    private int capacity;
    
    public ArrayList() {
        this.capacity = 100;
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    public boolean add(E element) {
        if (size == this.array.length) {
            resize(size*2);
        }
        this.array[size++] = element;
        return true;
    }

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    public void clear() {
        this.capacity = 100;
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public int size() {
        return size;
    }
    
    // This line allows us to cast our object to type (E) without any warnings.
    // For further detais, please see: http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/SuppressWarnings.html
    @SuppressWarnings("unchecked") 
    public E get(int index) {
        return (E) this.array[index];
    }
    
    public int indexOf(E element) {
        for (int i=0;i<this.size();i++) {
            if (element.equals(this.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(E element) {
        int index = this.indexOf(element);
        if (index >= 0) {
            E removed = this.get(index);
            for (int i=index+1;i<this.size();i++) {
                this.set(i-1, this.get(i));
            }
            this.array[size-1] = null;
            size--;
            return true;
        }
        return false;
    }

    public E set(int index, E element) {
        if (index >= this.size()) {
            throw new ArrayIndexOutOfBoundsException("index > size: "+index+" >= "+size);
        }
        E replaced = this.get(index);
        this.array[index] = element;
        return replaced;
    }
    
    
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        StringBuilder ret = new StringBuilder("[");
        for (int i=0;i<size;i++) {
            ret.append(this.get(i)).append(", ");
        }
        ret.deleteCharAt(ret.length()-1);
        ret.setCharAt(ret.length()-1, ']');
        return ret.toString();
    }
    
    private void resize(int newsize) {
        this.array = Arrays.copyOf(this.array, newsize);
    }
    
}
