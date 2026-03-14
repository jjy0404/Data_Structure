import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import stores.*;

public class ArrayListTest {
    ArrayList<String> myArrayList = new ArrayList<>();

    @BeforeEach
    public void setupArrayList() {
        myArrayList = new ArrayList<>();
    }

    @Test
    void testAdd() {
        assertTrue(myArrayList.add("hello"));
    }

    @Test
    void testContainsDefault() {
        assertFalse(myArrayList.contains("hello"));
    }

    @Test
    void testContainsPos() {
        myArrayList.add("hello");
        assertTrue(myArrayList.contains("hello"));
    }

    @Test
    void testContainsNeg() {
        myArrayList.add("hello");
        assertFalse(myArrayList.contains("hello2"));
    }

    @Test
    void testClearViaIsEmpty() {
        myArrayList.add("hello");
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testClearViaSize() {
        myArrayList.add("hello");
        myArrayList.clear();
        assertTrue(myArrayList.size() == 0);
    }

    @Test
    void testClearViaToString() {
        myArrayList.add("hello");
        myArrayList.clear();
        assertTrue(myArrayList.toString().equals("[]"));
    }

    @Test
    void testIsEmptyDefault() {
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testIsEmptyAdd() {
        myArrayList.add("hello");
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    void testIsEmptyAddAndRemove() {
        myArrayList.add("hello");
        myArrayList.remove("hello");
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testIsEmptyAdd2AndRemove() {
        myArrayList.add("hello");
        myArrayList.add("world");
        myArrayList.remove("hello");
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    void testSizeDefault() {
        assertTrue(myArrayList.size() == 0);
    }

    @Test
    void testSizeAdd() {
        myArrayList.add("hello");
        assertTrue(myArrayList.size() == 1);
    }

    @Test
    void testSizeAddAndRemove() {
        myArrayList.add("hello");
        myArrayList.remove("hello");
        assertTrue(myArrayList.size() == 0);
    }

    @Test
    void testSizeAdd2AndRemove() {
        myArrayList.add("hello");
        myArrayList.add("world");
        myArrayList.remove("hello");
        assertTrue(myArrayList.size() == 1);
    }

    @Test
    void testGetDefault() {
        for (int i = 0; i < 100; i++) {
            assertTrue(myArrayList.get(i) == null);
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {myArrayList.get(100);});
    }

    @Test
    void testGetAfterAdd() {
        myArrayList.add("hello");
        assertTrue(myArrayList.get(0).equals("hello"));

        for (int i = 1; i < 100; i++) {
            assertTrue(myArrayList.get(i) == null);
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {myArrayList.get(100);});
    }

    @Test
    void testIndexOfDefault() {
        assertTrue(myArrayList.indexOf("hello") == -1);
    }

    @Test
    void testIndexOfPos() {
        myArrayList.add("hello");
        myArrayList.add("world");
        assertTrue(myArrayList.indexOf("hello") == 0);
        assertTrue(myArrayList.indexOf("world") == 1);
    }

    @Test
    void testIndexOfNeg() {
        myArrayList.add("hello");
        myArrayList.add("world");
        assertFalse(myArrayList.indexOf("world") != 0 & myArrayList.indexOf("world") > 1);
        assertFalse(myArrayList.indexOf("hello") > 0);
        assertTrue(myArrayList.indexOf("world2") == -1);
    }

    @Test
    void testRemoveDefault() {
        assertFalse(myArrayList.remove("hello"));
    }

    @Test
    void testRemovePos() {
        myArrayList.add("hello");
        assertTrue(myArrayList.remove("hello"));
    }

    @Test
    void testRemoveNeg(){
        myArrayList.add("hello");
        assertFalse(myArrayList.remove("world"));
    }

    @Test
    void testSetDefault() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {myArrayList.set(0, "hello");});
    }

    @Test
    void testSetPos() {
        myArrayList.add("hello");
        assertTrue(myArrayList.set(0, "world").equals("hello"));
        assertTrue(myArrayList.size() == 1);
        assertFalse(myArrayList.isEmpty());
        assertTrue(myArrayList.toString().equals("[world]"));
    }

    @Test
    void testSetNeg() {
        myArrayList.add("hello");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {myArrayList.set(1, "world");});
    }

    @Test
    void testToStringDefault() {
        assertTrue(myArrayList.toString().equals("[]"));
    }

    @Test
    void testToStringAfterAdd() {
        myArrayList.add("hello");
        assertTrue(myArrayList.toString().equals("[hello]"));
    }

    @Test
    void testToStringAfterAdd2() {
        myArrayList.add("hello");
        myArrayList.add("world");
        assertTrue(myArrayList.toString().equals("[hello, world]"));
    }

    @Test
    void testToStringAfterAddAndRemove() {
        myArrayList.add("hello");
        myArrayList.remove("hello");
        assertTrue(myArrayList.toString().equals("[]"));
    }

    @Test
    void testToStringAfterAdd2AndRemove() {
        myArrayList.add("hello");
        myArrayList.add("world");
        myArrayList.remove("hello");
        assertTrue(myArrayList.toString().equals("[world]"));
    }
}
