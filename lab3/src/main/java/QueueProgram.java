import stores.MyQueue;

public class QueueProgram {

    public static void main(String[] args) {
        //INCOMPLETE
	MyQueue<Integer> queue = new MyQueue<>();
	queue.enqueue(4);
	queue.enqueue(7);
	queue.enqueue(2);
	System.out.print(queue.toString());
    }
    
}
