import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinSortTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orgOut = System.out;

    @BeforeEach
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(orgOut);
        System.out.println(outContent.toString());
    }
    
    @Test
    void testBinSort() {
        BinSort.main(null);
        assertTrue(outContent.toString().equals("" + 
            "Adding 2 to root.\n" + 
            "Adding 4 to right sub-tree of 2\n" + 
            "Adding 1 to left sub-tree of 2\n" + 
            "Adding 5 to right sub-tree of 2\n" + 
            "Adding 5 to right sub-tree of 4\n" + 
            "Adding 3 to right sub-tree of 2\n" + 
            "Adding 3 to left sub-tree of 4\n" + 
            "----- In Order -----\n" +
            "Inorder traversal: \"1\" \"2\" \"3\" \"4\" \"5\" \n" +
            "\n----- Pre Order -----\n" +
            "Preorder traversal: \"2\" \"1\" \"4\" \"3\" \"5\" \n"+
            "\n----- Post Order -----\n" + 
            "Postorder traversal: \"1\" \"3\" \"5\" \"4\" \"2\" \n"
        ));
    }
}
