import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CS126Lab2Test {
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
    void getMainOutputMilestone2() {
        String[] args = {"A. N. Other"};
        CS126Lab2.main(args);
        assertEquals("[]\n[A. N. Other]\n", outContent.toString());
    }

    @Test
    void getMainOutputMilestone3() {
        String[] args = {"A. N. Other", "J. Doe"};
        CS126Lab2.main(args);
        assertEquals("[]\n[A. N. Other]\n[A. N. Other, J. Doe]\n[J. Doe]\n", outContent.toString());
    }
}
