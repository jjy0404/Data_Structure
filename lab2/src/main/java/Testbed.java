import interfaces.*;
import stores.*;

public class Testbed {

    public static void main(String args[]) {
	MyLinkedList<Integer> num = new MyLinkedList<>();
	num.add(5); num.add(7); num.add(76);
	System.out.println(num.toString());

    }
}
