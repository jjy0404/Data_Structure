
/**
  Program to test out singly linked-list ADT
*/

import stores.*;

public class CS126Lab3 {
    public static void main(String[] args) {
        QueueProgram.main(null);

        StackProgram.main(null);

        try {
            Calculator.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
