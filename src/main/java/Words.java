import java.io.IOException;

import utils.WordReader;

import stores.Set;

/**
 * Test out WordReader class.
 */

public class Words {

    public static void main(String args[]) {
	Set<String> wordset = new Set<>();
        
        try {
            
            //Create a WordReader object to read words from a file.
            WordReader in = new WordReader(args[0]);
            String str = null;

            // Keep reading words while next word is not-null.
            while ((str = in.readWord()) != null) {
                System.out.println(str);
		wordset.add(str);
            }

            in.close(); // Close the file.
            
        } catch (IOException ex) {
            System.out.println("Error :" + ex);
            System.exit(1);
        }
        
    }
}
