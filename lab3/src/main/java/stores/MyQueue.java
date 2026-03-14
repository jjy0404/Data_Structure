package stores;

import interfaces.IQueue;

public class MyQueue<E> implements IQueue<E> {

    private ListElement<E> head;
    private ListElement<E> tail;

    public MyQueue() {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        ListElement<E> tmp = head;
        head = tmp.getNext();

        if (head == null) {
            tail = null;
        }

        return tmp.getValue();
    }

    public void enqueue(E value) {
        ListElement<E> tmp = new ListElement<>(value);

        if (isEmpty()) {
            tail = head = tmp;
        } else {
            tail.setNext(tmp);
            tail = tmp;
        }
    }

    //INCOMPLETE
    public E modifyHead(E value) {
        //TODO: modifies the head of the queue, and returns the previous value
	ListElement<E> old = head;
	if (head == null) {
	    enqueue(value);
	    return null;
	}
	else {
	    ListElement<E> tmp = new ListElement<>(value);
	    tmp.setNext(head.getNext());
	    head = tmp;
	    if (head.getNext() == null) {
		tail = head;
	    }
	}
	return old.getValue();
    }

    //INCOMPLETE
    public String toString() {
        //TODO: produces a String of the contents of the queue
	if (head == null) {
	    return "[]";
	}
	StringBuilder sb = new StringBuilder("[");

	ListElement<E> ptr = head;
	while (ptr != null) {
	    sb.append(ptr.getValue());

	    if (ptr.getNext() != null) {
		sb.append(", ");
	    }
	    else {
		sb.append("]");
	    }

	    ptr =  ptr.getNext();
	}
	    
        return sb.toString();
    }
}
