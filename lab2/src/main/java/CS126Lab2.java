/**
  Program to test out singly linked-list ADT
*/

import stores.*;

public class CS126Lab2
{
    public static void main(String[] args)
    {
        String name = "";
        String name2 = "";

	MyLinkedList<String> list = new MyLinkedList<>();
	
        if (args == null | args.length < 1) {
          name = "My first name here!";
          name2 = "My second name here!";

	  System.out.println("List before adding: " + list);
	  list.add(name);
	  System.out.println("List after adding: " + list);
	      
        } else if (args.length > 1) {
          name = args[0];
          name2 = args[1];
          /*
           * INCOMPLETE (Milestone 3)
           * - Perform Milestone 2 (Print the list before and after adding "name" to the list)
           * - Add name2 using addToTail()
           * - Print out the linked list
           * - Remove an element from the head
           * - Print out the linked list
           */
	  System.out.println("Initial list: " +list);
	  list.add(name);
	  System.out.println("After adding " + name + " to head " + list);

	  list.addToTail(name2);
	  System.out.println("After adding " + name2 + " to tail: " + list);

	  list.removeFromHead();
	  System.out.println("After removing from head: " + list);
        } else {
          name = args[0];
          name2 = "My name here!";

          // INCOMPLETE (Milestone 2) - Print the list before and after adding "name" to the list
	  System.out.println("List BEFORE adding: " + list);
	  list.add(name);
	  System.out.println("List AFTER adding: " + list);
        }

    }
}
