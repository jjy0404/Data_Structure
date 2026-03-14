import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import stores.*;

public class HashMapTest {
    HashMap<Integer, String> myHashMap = new HashMap<>();

    @BeforeEach
    public void setupHashMap() {
        myHashMap = new HashMap<>();
    }

    @Test
    void testFindDefault() {
        assertTrue(myHashMap.find(0004) == 0);
    }

    @Test
    void testFindAfterAdd() {
        myHashMap.add(0004, "charmander");
        assertTrue(myHashMap.find(0004) == 1);
    }

    @Test
    void testFindAfterAdd2() {
        myHashMap.add(0004, "charmander");
        myHashMap.add(0007, "squirtle");
        assertTrue(myHashMap.find(0004) == 1);
    }

    @Test
    void testFindWithConflict() {
        myHashMap = new HashMap<>(11);
        myHashMap.add(0004, "charmander");
        myHashMap.add(0017, "pidgeotto");
        assertTrue(myHashMap.find(0004) == 2);
        assertTrue(myHashMap.find(0017) == 1);
    }

    @Test
    void testAddViaGet() {
        myHashMap.add(0004, "charmander");
        assertTrue(myHashMap.get(0004).equals("charmander"));
    }

    @Test
    void testGetDefault() {
        try {
            myHashMap.get(0004);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(myHashMap.get(0004) == null);
    }

    @Test
    void testGetAfterAdd2() {
        myHashMap.add(0004, "charmander");
        myHashMap.add(0007, "squirtle");
        assertTrue(myHashMap.get(0004).equals("charmander"));
        assertTrue(myHashMap.get(0007).equals("squirtle"));
    }

    @Test
    void testGetWithConflict() {
        myHashMap = new HashMap<>(11);
        myHashMap.add(0004, "charmander");
        myHashMap.add(0017, "pidgeotto");
        assertTrue(myHashMap.get(0004).equals("charmander"));
        assertTrue(myHashMap.get(0017).equals("pidgeotto"));
    }
}
