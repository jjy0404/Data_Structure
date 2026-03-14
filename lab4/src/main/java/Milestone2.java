import stores.SortedArrayList;
public class Milestone2 {
    public static void main (String[] args) {
        /*INCOMPLETE: Write a program that:
         *   - inserts a few (3+) strings 
         *   - prints out them in alphabetical order
         *   - prints out the number of comparisons needed to find a single item using a **binary** search
         */
	SortedArrayList<String> mySortedArrayList = new SortedArrayList<>();
	mySortedArrayList.add("hi");
        mySortedArrayList.add("bye");
        mySortedArrayList.add("is");
        mySortedArrayList.add("he");
	//System.out.print(mySortedArrayList.findBinary("hi"));
	System.out.print(mySortedArrayList.toString());
	     
    }
}
