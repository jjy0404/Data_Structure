import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EsromTest {
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
    void testEsromDot() {
        String[] esromArgs = {"."};
        Esrom.main(esromArgs);
        assertTrue(outContent.toString().equals("e\n"));
    }

    @Test
    void testEsromDash() {
        String[] esromArgs = {"-"};
        Esrom.main(esromArgs);
        assertTrue(outContent.toString().equals("t\n"));
    }

    @Test
    void testEsromDotDot() {
        String[] esromArgs = {".."};
        Esrom.main(esromArgs);
        assertTrue(outContent.toString().equals("i\n"));
    }

    @Test
    void testEsromDotDash() {
        String[] esromArgs = {".-"};
        Esrom.main(esromArgs);
        assertTrue(outContent.toString().equals("a\n"));
    }

    @Test
    void testEsromDashDot() {
        String[] esromArgs = {"-."};
        Esrom.main(esromArgs);
        assertTrue(outContent.toString().equals("n\n"));
    }

    @Test
    void testEsromDashDash() {
        String[] esromArgs = {"--"};
        Esrom.main(esromArgs);
        assertTrue(outContent.toString().equals("m\n"));
    }

    @Test
    void testEsromMultiple() {
        String[] esromArgs = { ".", "-", ".-", "--", "..", "-."};
        Esrom.main(esromArgs);
        assertTrue(outContent.toString().equals("etamin\n"));
    }

    @Test
    void testEsromMilestone2() {
        int counter = 0;
        String[] esromArgs = new String[1];
        String[] allCases = {"-...", "-.-.", "-..", "..-.", "--.", "....", ".---", "-.-", ".-..", "---", ".--.", "--.-", ".-.", "...", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] answers = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "o", "p", "q", "r", "s", "u", "v", "w", "x", "y", "z"};



        assertTrue(allCases.length == answers.length);

        for (int i = 0; i < allCases.length; i++) {
            esromArgs[0] = allCases[i];
            
            ByteArrayOutputStream tmpContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(tmpContent));
            Esrom.main(esromArgs);
            if (tmpContent.toString().equals(answers[i]+"\n")) {
                counter++;
            }
            
            System.setOut(new PrintStream(outContent));
            System.out.print("Input: " + allCases[i] + "\tExpected: " + answers[i] + "\t Found: " + tmpContent);
            if (outContent.toString().charAt(outContent.toString().length()-1) != '\n') {
                System.out.println();
            }
        }

        System.out.println("\nCount correct: " + counter);

        assertTrue(counter > 4);
    }
}
