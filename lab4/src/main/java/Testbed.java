import interfaces.*;
import stores.*;

public class Testbed {

    public static void main(String args[]) {
        //Add your own code here!
	SortedArrayList<Integer> list = new SortedArrayList<>();
	list.add(4);
	System.out.println(list.toString());
	list.add(5);
	list.add(7);
	list.add(3);
	System.out.println(list.toString());
	list.add(6);
	System.out.println(list.toString());
    }
}
