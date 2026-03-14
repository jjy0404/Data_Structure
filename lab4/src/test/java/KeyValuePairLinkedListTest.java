import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import stores.*;

public class KeyValuePairLinkedListTest {
    KeyValuePairLinkedList<String, String> myKeyValuePairLinkedList = new KeyValuePairLinkedList<>();

    @BeforeEach
    public void setupKeyValuePairLinkedList() {
        myKeyValuePairLinkedList = new KeyValuePairLinkedList<>();
    }

    @Test
    void testAddSeperateViaSize() {
        myKeyValuePairLinkedList.add("0004", "charmander");
        assertTrue(myKeyValuePairLinkedList.size() == 1);
    }

    @Test
    void testAddSeperateViaGetHead() {
        myKeyValuePairLinkedList.add("0004", "charmander");
        ListElement<KeyValuePair<String, String>> result = myKeyValuePairLinkedList.getHead();
        assertTrue(result.getValue().getKey().equals("0004"));
        assertTrue(result.getValue().getValue().equals("charmander"));
    }

    @Test
    void testAddSeperateViaGet() {
        myKeyValuePairLinkedList.add("0004", "charmander");
        KeyValuePair<String, String> result = myKeyValuePairLinkedList.get("0004");
        assertTrue(result.getKey().equals("0004"));
        assertTrue(result.getValue().equals("charmander"));
    }

    @Test
    void testAddPairViaSize() {
        KeyValuePair<String, String> tmp = new KeyValuePair<>("0004", "charmander");
        myKeyValuePairLinkedList.add(tmp);
        assertTrue(myKeyValuePairLinkedList.size() == 1);
    }

    @Test
    void testAddPairViaGetHead() {
        KeyValuePair<String, String> tmp = new KeyValuePair<>("0004", "charmander");
        myKeyValuePairLinkedList.add(tmp);
        ListElement<KeyValuePair<String, String>> result = myKeyValuePairLinkedList.getHead();
        assertTrue(result.getValue().compareTo(tmp) == 0);
        assertTrue(result.getValue().getKey().equals(tmp.getKey()));
        assertTrue(result.getValue().getValue().equals(tmp.getValue()));
    }

    @Test
    void testAddPairViaGet() {
        KeyValuePair<String, String> tmp = new KeyValuePair<>("0004", "charmander");
        myKeyValuePairLinkedList.add(tmp);
        KeyValuePair<String, String> result = myKeyValuePairLinkedList.get("0004");
        assertTrue(result.compareTo(tmp) == 0);
        assertTrue(result.getKey().equals(tmp.getKey()));
        assertTrue(result.getValue().equals(tmp.getValue()));
    }

    @Test
    void testSizeDefault() {
        assertTrue(myKeyValuePairLinkedList.size() == 0);
    }

    @Test
    void testSizeAfterAdd2() {
        myKeyValuePairLinkedList.add("0004", "charmander");
        myKeyValuePairLinkedList.add("0001", "bulbasaur");
        assertTrue(myKeyValuePairLinkedList.size() == 2);
    }

    @Test
    void testGetHeadDefault() {
        assertTrue(myKeyValuePairLinkedList.getHead() == null);
    }

    @Test
    void testGetHeadAfterAdd2() {
        myKeyValuePairLinkedList.add("0004", "charmander");
        myKeyValuePairLinkedList.add("0001", "bulbasaur");

        ListElement<KeyValuePair<String, String>> result = myKeyValuePairLinkedList.getHead();
        assertTrue(result.getValue().getKey().equals("0001"));
        assertTrue(result.getValue().getValue().equals("bulbasaur"));
    }

    @Test
    void testGetDefault() {
        assertTrue(myKeyValuePairLinkedList.get("0004") == null);
    }

    @Test
    void testGetAfterAdd2() {
        myKeyValuePairLinkedList.add("0004", "charmander");
        myKeyValuePairLinkedList.add("0001", "bulbasaur");

        KeyValuePair<String, String> result = myKeyValuePairLinkedList.get("0004");
        KeyValuePair<String, String> result2 = myKeyValuePairLinkedList.get("0001");

        assertTrue(result.getKey().equals("0004"));
        assertTrue(result.getValue().equals("charmander"));
        assertTrue(result2.getKey().equals("0001"));
        assertTrue(result2.getValue().equals("bulbasaur"));
    }
}
