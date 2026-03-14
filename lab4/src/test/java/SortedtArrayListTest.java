import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

import stores.*;

public class SortedtArrayListTest {
    SortedArrayList<Integer> mySortedArrayList = new SortedArrayList<>();

    @BeforeEach
    public void setupMySortedArrayList() {
        mySortedArrayList = new SortedArrayList<>();
    }

    @Test
    void testAdd() {
        assertTrue(mySortedArrayList.add(4));
        assertTrue(mySortedArrayList.toString().equals("[4]"));
        assertTrue(mySortedArrayList.size() == 1);
        assertFalse(mySortedArrayList.isEmpty());
    } 

    @Test
    void testAdd2() {
        assertTrue(mySortedArrayList.add(4));
        assertTrue(mySortedArrayList.add(2));
        assertTrue(mySortedArrayList.toString().equals("[2, 4]"));
        assertTrue(mySortedArrayList.size() == 2);
        assertFalse(mySortedArrayList.isEmpty());
    }

    @Test
    void testAddMany() {
        //Generate a array of random integers
        final int numItems = 20;
        Integer[] items = new Integer[numItems];
        for (int i = 0; i < numItems; i++) {
            items[i] = ThreadLocalRandom.current().nextInt(0, (10*numItems));
        }

        //Insert into test SortedArrayList
        for (int i = 0; i < numItems; i++) {
            assertTrue(mySortedArrayList.add(items[i]));
        }

        //Do some size assertions
        assertTrue(mySortedArrayList.size() == numItems);
        assertFalse(mySortedArrayList.isEmpty());

        //Perform a bubble sort
        for (int i = 0; i < numItems; i++) {
            for (int j = 0; j < numItems-1; j++) {
                if (items[j] > items[j+1]) {
                    Integer tmp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = tmp;
                }
            }
        }

        //Generate comparative string
        String testString = "[";
        for (int i = 0; i < numItems; i++) {
            testString += items[i];
            if (i != (numItems-1)) {
                testString += ", ";
            } else {
                testString += "]";
            }
        }

        System.out.println("Expected: " + testString);
        System.out.println("Produced: " + mySortedArrayList.toString());

        assertTrue(mySortedArrayList.toString().equals(testString));
    }

    @Test
    void testFindLinearDefault() {
        assertTrue(mySortedArrayList.findLinear(0) == 0);
    }

    @Test
    void testFindLinearPos() {
        mySortedArrayList.add(4);
        assertTrue(mySortedArrayList.findLinear(4) == 1);
    }

    @Test
    void testFindLinearNeg() {
        mySortedArrayList.add(4);
        assertTrue(mySortedArrayList.findLinear(2) == 1);
    }

    @Test
    void testFindLinearMultiplePos() {
        mySortedArrayList.add(4);
        mySortedArrayList.add(2);
        mySortedArrayList.add(8);
        mySortedArrayList.add(3);
        mySortedArrayList.add(5);
        assertTrue(mySortedArrayList.findLinear(2) == 1);
        assertTrue(mySortedArrayList.findLinear(3) == 2);
        assertTrue(mySortedArrayList.findLinear(4) == 3);
        assertTrue(mySortedArrayList.findLinear(5) == 4);
        assertTrue(mySortedArrayList.findLinear(8) == 5);
    }

    @Test
    void testFindLinearMultipleNeg() {
        mySortedArrayList.add(4);
        mySortedArrayList.add(2);
        mySortedArrayList.add(8);
        mySortedArrayList.add(3);
        mySortedArrayList.add(5);
        assertTrue(mySortedArrayList.findLinear(1) == 1);
        assertTrue(mySortedArrayList.findLinear(6) == 5);
        assertTrue(mySortedArrayList.findLinear(9) == 5);
    }

    @Test
    void testFindBinaryDefault() {
        assertTrue(mySortedArrayList.findBinary(0) == 0);
    }

    @Test
    void testFindBinaryPos() {
        mySortedArrayList.add(4);
        assertTrue(mySortedArrayList.findBinary(4) == 1);
    }

    @Test
    void testFindBinaryNeg() {
        mySortedArrayList.add(4);
        assertTrue(mySortedArrayList.findBinary(2) == 2);
    }

    @Test
    void testFindBinaryMultiplePos() {
        mySortedArrayList.add(4);
        mySortedArrayList.add(2);
        mySortedArrayList.add(8);
        mySortedArrayList.add(3);
        mySortedArrayList.add(5);
        assertTrue(mySortedArrayList.findBinary(2) == 3);
        assertTrue(mySortedArrayList.findBinary(3) == 2);
        assertTrue(mySortedArrayList.findBinary(4) == 1);
        assertTrue(mySortedArrayList.findBinary(5) == 3);
        assertTrue(mySortedArrayList.findBinary(8) == 2);
    }

    @Test
    void testFindBinaryMultipleNeg() {
        mySortedArrayList.add(4);
        mySortedArrayList.add(2);
        mySortedArrayList.add(8);
        mySortedArrayList.add(3);
        mySortedArrayList.add(5);
        assertTrue(mySortedArrayList.findBinary(1) == 4);
        assertTrue(mySortedArrayList.findBinary(6) == 4);
        assertTrue(mySortedArrayList.findBinary(9) == 3);
    }
}
