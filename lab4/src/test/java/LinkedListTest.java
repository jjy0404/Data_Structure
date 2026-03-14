import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import stores.*;

public class LinkedListTest {
    LinkedList<String> myLinkedList = new LinkedList<>();

    @BeforeEach
    public void setupLinkedList() {
        myLinkedList = new LinkedList<>();
    }

    @Test
    void testGetDefault() {
        assertTrue(myLinkedList.get(0) == null);
    }

    @Test
    void testGetAfterAdd() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.get(0).equals("hello"));
    }

    @Test
    void testGetAfterAdd2() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.get(1).equals("hello"));
        assertTrue(myLinkedList.get(0).equals("world"));
        assertTrue(myLinkedList.get(2) == null);
    }

    @Test
    void testGetNeg() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.get(1) == null);
    }

    @Test
    void testIndexOfDefault() {
        assertTrue(myLinkedList.indexOf("hello") == -1);
    }

    @Test
    void testIndexOfAfterAdd() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.indexOf("hello") == 0);
    }

    @Test
    void testIndexOfAfterAdd2() {
        myLinkedList.add("hello");
        myLinkedList.add("world");

        assertTrue(myLinkedList.indexOf("hello") == 1);
        assertTrue(myLinkedList.indexOf("world") == 0);
    }

    @Test
    void testSetDefault() {
        assertTrue(myLinkedList.set(0, "hello") == null);
    }

    @Test
    void testSetAfterAddViaGet() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.set(0, "hello2").equals("hello"));
        assertTrue(myLinkedList.get(0).equals("hello2"));
    }

    @Test
    void testSetAfterAdd2ViaGet() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.set(1, "hello2").equals("hello"));
        assertTrue(myLinkedList.get(1).equals("hello2"));
    }

    @Test
    void testSetAfterAdd2ViaGet2() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.set(0, "world2").equals("world"));
        assertTrue(myLinkedList.get(0).equals("world2"));
    }

    @Test
    void testSetAfterAddViaToString() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.set(0, "hello2").equals("hello"));
        assertTrue(myLinkedList.toString().equals("[hello2]"));
    }

    @Test
    void testSetAfterAdd2ViaToString() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.set(1, "hello2").equals("hello"));
        assertTrue(myLinkedList.toString().equals("[world, hello2]"));
    }

    @Test
    void testSetAfterAdd2ViaToString2() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.set(0, "world2").equals("world"));
        assertTrue(myLinkedList.toString().equals("[world2, hello]"));
    }

    @Test
    void testAdd() {
        assertTrue(myLinkedList.add("hello"));
    }

    @Test
    void testAddViaIsEmpty() {
        myLinkedList.add("hello");
        assertFalse(myLinkedList.isEmpty());
    }

    @Test
    void testAddViaSize() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.size() == 1);
    }

    @Test
    void testAddViaToString() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.toString().equals("[hello]"));
    }

    @Test
    void testAdd2ViaIsEmpty() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertFalse(myLinkedList.isEmpty());
    }

    @Test
    void testAdd2ViaSize() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.size() == 2);
    }

    @Test
    void testAdd2ViaToString() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.toString().equals("[world, hello]"));
    }

    @Test
    void testClearViaIsEmpty() {
        myLinkedList.add("hello");
        myLinkedList.clear();
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    void testClearViaSize() {
        myLinkedList.add("hello");
        myLinkedList.clear();
        assertTrue(myLinkedList.size() == 0);
    }

    @Test
    void testClearViaToString() {
        myLinkedList.add("hello");
        myLinkedList.clear();
        assertTrue(myLinkedList.toString().equals("[]"));
    }

    @Test
    void testContainsDefault() {
        assertFalse(myLinkedList.contains("hello"));
    }

    @Test
    void testContainsPos() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.contains("hello"));
    }

    @Test
    void testContainsNeg() {
        myLinkedList.add("hello");
        assertFalse(myLinkedList.contains("world"));
    }

    @Test
    void testIsEmptyDefault() {
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    void testRemoveDefault() {
        assertFalse(myLinkedList.remove("hello"));
    }

    @Test
    void testRemovePos() {
        myLinkedList.add("hello");
        assertTrue(myLinkedList.remove("hello"));
        assertTrue(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 0);
        assertTrue(myLinkedList.toString().equals("[]"));
    }

    @Test
    void testRemoveNeg() {
        myLinkedList.add("hello");
        assertFalse(myLinkedList.remove("hello2"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 1);
        assertTrue(myLinkedList.toString().equals("[hello]"));
    }

    @Test
    void testRemovePos2() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.remove("hello"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 1);
        assertTrue(myLinkedList.toString().equals("[world]"));
    }

    @Test
    void testRemovePos3() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertTrue(myLinkedList.remove("world"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 1);
        assertTrue(myLinkedList.toString().equals("[hello]"));
    }

    @Test
    void testRemoveNeg2() {
        myLinkedList.add("hello");
        myLinkedList.add("world");
        assertFalse(myLinkedList.remove("hello2"));
        assertFalse(myLinkedList.isEmpty());
        assertTrue(myLinkedList.size() == 2);
        assertTrue(myLinkedList.toString().equals("[world, hello]"));
    }

    @Test
    void testSizeDefault() {
        assertTrue(myLinkedList.size() == 0);
    }

    @Test
    void testToStringDefault() {
        assertTrue(myLinkedList.toString().equals("[]"));
    }
}
