import stores.SortedArrayList;
public class Milestone1 {
    public static void main (String[] args) {
        /*INCOMPLETE: Write a program that:
         *   - inserts a few (3+) strings 
         *   - prints out them in alphabetical order
         *   - prints out the number of comparisons needed to find a single item using a **linear** search
         */
	SortedArrayList<String> list = new SortedArrayList<>();
	list.add("hello");
	list.add("my");
	list.add("name");
	list.add("is");
	System.out.println(list.toString());
	//System.out.println(list.findLinear("my"));

    }
}
