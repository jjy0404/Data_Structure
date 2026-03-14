import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import stores.*;

public class ListElementTest {
    ListElement<String> myListElement = new ListElement<>("hello");

    @BeforeEach
    public void setupListElement() {
        myListElement = new ListElement<>("hello");
    }

    @Test
    void testGetValue() {
        assertTrue(myListElement.getValue().equals("hello"));
    }

    @Test
    void testGetNextDefault() {
        assertTrue(myListElement.getNext() == null);
    }

    @Test
    void testGetAndSetNext() {
        ListElement<String> tmpListElement = new ListElement<>("world");
        myListElement.setNext(tmpListElement);
        assertTrue(myListElement.getNext().getValue().equals(tmpListElement.getValue()));
    }

    @Test
    void testGetPrevDefault() {
        assertTrue(myListElement.getPrev() == null);
    }

    @Test
    void testGetAndSetPrev() {
        ListElement<String> tmpListElement = new ListElement<>("world");
        myListElement.setPrev(tmpListElement);
        assertTrue(myListElement.getPrev().getValue().equals(tmpListElement.getValue()));
    }

    @Test
    void testGetAndSetPrevAndNext() {
        ListElement<String> tmpListElement = new ListElement<>("world");
        myListElement.setPrev(tmpListElement);

        ListElement<String> tmpListElement2 = new ListElement<>("world2");
        myListElement.setNext(tmpListElement2);

        assertTrue(myListElement.getPrev().getValue().equals(tmpListElement.getValue()));
        assertTrue(myListElement.getNext().getValue().equals(tmpListElement2.getValue()));
    }
}
