/**
 * A vector of Strings program
 */
import stores.*;

public class MyArrayListProgram {

    public static void main(String args[]) {
        // Initialization of ArrayList, holding String objects
        MyArrayList<String> words = new MyArrayList<>(); 

        words.add("I");
        words.add("am");
        words.add("the");
        words.add("eggman");

        System.out.println(words.toString());

        System.out.println("List has " + words.size() + " elements");

        System.out.println("List contains the element \"eggman\": " + words.contains("eggman") + "\t(expected true)");

        System.out.println("List contains the element \"strawberry\": " + words.contains("strawberry") + "\t(expected false)");
    }
}
