import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import stores.*;

public class KeyValuePairTest {
    KeyValuePair<String, String> myKeyValuePair = new KeyValuePair<String,String>("0004", "charmander");

    @BeforeEach
    public void setupKeyValuePair() {
        myKeyValuePair = new KeyValuePair<String,String>("0004", "charmander");
    }

    @Test
    void testGetKey() {
        assertTrue(myKeyValuePair.getKey().equals("0004"));
    }

    @Test
    void testGetValue() {
        assertTrue(myKeyValuePair.getValue().equals("charmander"));
    }

    @Test
    void testCompareToLess() {
        KeyValuePair<String, String> tmpKeyValuePair = new KeyValuePair<String,String>("0001", "bulbasaur");
        assertTrue(myKeyValuePair.compareTo(tmpKeyValuePair) < 0);
    }

    @Test
    void testCompareToEquals() {
        KeyValuePair<String, String> tmpKeyValuePair = new KeyValuePair<String,String>("0004", "charmander");
        assertTrue(myKeyValuePair.compareTo(tmpKeyValuePair) == 0);
    }

    @Test
    void testCompareToGreater() {
        KeyValuePair<String, String> tmpKeyValuePair = new KeyValuePair<String,String>("0007", "sqirtle");
        assertTrue(myKeyValuePair.compareTo(tmpKeyValuePair) > 0);
    }
}
