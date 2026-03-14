import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import stores.*;

public class BinaryTreeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orgOut = System.out;
    private BinaryTree<String> myBinaryTree = new BinaryTree<>();

    @BeforeEach
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void resetBinaryTree() {
        myBinaryTree = new BinaryTree<>();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(orgOut);
        System.out.println(outContent.toString());
    }

    @Test
    void testAddRoot() {
        myBinaryTree.add("hotel");
        assertTrue(outContent.toString().equals("" + 
            "Adding hotel to root.\n"
        ));
    }

    @Test
    void testAddLeft() {
        myBinaryTree.add("hotel");
        myBinaryTree.add("foxtrot");
        assertTrue(outContent.toString().equals("" + 
            "Adding hotel to root.\n" + 
            "Adding foxtrot to left sub-tree of hotel\n"
        ));
    }

    @Test
    void testAddRight() {
        myBinaryTree.add("hotel");
        myBinaryTree.add("tango");
        assertTrue(outContent.toString().equals("" + 
            "Adding hotel to root.\n" + 
            "Adding tango to right sub-tree of hotel\n"
        ));
    }

    @Test
    void testAddLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("foxtrot");
        currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("tango");
        currentOutput += "Adding tango to right sub-tree of hotel\n";
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("delta");
        currentOutput += "Adding delta to left sub-tree of hotel\n" +
            "Adding delta to left sub-tree of foxtrot\n";
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("golf");
        currentOutput += "Adding golf to left sub-tree of hotel\n" + 
            "Adding golf to right sub-tree of foxtrot\n";
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("lema");
        currentOutput += "Adding lema to right sub-tree of hotel\n" +
            "Adding lema to left sub-tree of tango\n";
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("xray");
        currentOutput += "Adding xray to right sub-tree of hotel\n" +
            "Adding xray to right sub-tree of tango\n";
        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderRoot() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.traversalInOrder();
        currentOutput += "Inorder traversal: \"hotel\" \n";
        
        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderLeft() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("foxtrot");
        currentOutput += "Adding foxtrot to left sub-tree of hotel\n";

        myBinaryTree.traversalInOrder();
        currentOutput += "Inorder traversal: \"foxtrot\" \"hotel\" \n";
        
        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderRight() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("tango");
        currentOutput += "Adding tango to right sub-tree of hotel\n";

        myBinaryTree.traversalInOrder();
        currentOutput += "Inorder traversal: \"hotel\" \"tango\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("foxtrot");
        currentOutput += "Adding foxtrot to left sub-tree of hotel\n";

        myBinaryTree.add("tango");
        currentOutput += "Adding tango to right sub-tree of hotel\n";

        myBinaryTree.add("delta");
        currentOutput += "Adding delta to left sub-tree of hotel\n" +
                "Adding delta to left sub-tree of foxtrot\n";

        myBinaryTree.add("golf");
        currentOutput += "Adding golf to left sub-tree of hotel\n" +
                "Adding golf to right sub-tree of foxtrot\n";

        myBinaryTree.add("lema");
        currentOutput += "Adding lema to right sub-tree of hotel\n" +
                "Adding lema to left sub-tree of tango\n";

        myBinaryTree.add("xray");
        currentOutput += "Adding xray to right sub-tree of hotel\n" +
                "Adding xray to right sub-tree of tango\n";

        myBinaryTree.traversalInOrder();
        currentOutput += "Inorder traversal: \"delta\" \"foxtrot\" \"golf\" \"hotel\" \"lema\" \"tango\" \"xray\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderRoot() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.traversalPreOrder();
        currentOutput += "Preorder traversal: \"hotel\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderLeft() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("foxtrot");
        currentOutput += "Adding foxtrot to left sub-tree of hotel\n";

        myBinaryTree.traversalPreOrder();
        currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderRight() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("tango");
        currentOutput += "Adding tango to right sub-tree of hotel\n";

        myBinaryTree.traversalPreOrder();
        currentOutput += "Preorder traversal: \"hotel\" \"tango\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("foxtrot");
        currentOutput += "Adding foxtrot to left sub-tree of hotel\n";

        myBinaryTree.add("tango");
        currentOutput += "Adding tango to right sub-tree of hotel\n";

        myBinaryTree.add("delta");
        currentOutput += "Adding delta to left sub-tree of hotel\n" +
                "Adding delta to left sub-tree of foxtrot\n";

        myBinaryTree.add("golf");
        currentOutput += "Adding golf to left sub-tree of hotel\n" +
                "Adding golf to right sub-tree of foxtrot\n";

        myBinaryTree.add("lema");
        currentOutput += "Adding lema to right sub-tree of hotel\n" +
                "Adding lema to left sub-tree of tango\n";

        myBinaryTree.add("xray");
        currentOutput += "Adding xray to right sub-tree of hotel\n" +
                "Adding xray to right sub-tree of tango\n";

        myBinaryTree.traversalPreOrder();
        currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \"delta\" \"golf\" \"tango\" \"lema\" \"xray\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderRoot() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.traversalPostOrder();
        currentOutput += "Postorder traversal: \"hotel\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderLeft() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("foxtrot");
        currentOutput += "Adding foxtrot to left sub-tree of hotel\n";

        myBinaryTree.traversalPostOrder();
        currentOutput += "Postorder traversal: \"foxtrot\" \"hotel\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderRight() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("tango");
        currentOutput += "Adding tango to right sub-tree of hotel\n";

        myBinaryTree.traversalPostOrder();
        currentOutput += "Postorder traversal: \"tango\" \"hotel\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
        currentOutput += "Adding hotel to root.\n";

        myBinaryTree.add("foxtrot");
        currentOutput += "Adding foxtrot to left sub-tree of hotel\n";

        myBinaryTree.add("tango");
        currentOutput += "Adding tango to right sub-tree of hotel\n";

        myBinaryTree.add("delta");
        currentOutput += "Adding delta to left sub-tree of hotel\n" +
                "Adding delta to left sub-tree of foxtrot\n";

        myBinaryTree.add("golf");
        currentOutput += "Adding golf to left sub-tree of hotel\n" +
                "Adding golf to right sub-tree of foxtrot\n";

        myBinaryTree.add("lema");
        currentOutput += "Adding lema to right sub-tree of hotel\n" +
                "Adding lema to left sub-tree of tango\n";

        myBinaryTree.add("xray");
        currentOutput += "Adding xray to right sub-tree of hotel\n" +
                "Adding xray to right sub-tree of tango\n";

        myBinaryTree.traversalPostOrder();
        currentOutput += "Postorder traversal: \"delta\" \"golf\" \"foxtrot\" \"lema\" \"xray\" \"tango\" \"hotel\" \n";

        assertTrue(outContent.toString().equals(currentOutput));
    }
}
