
public class HashCodeExample {

    public static void main(String[] args) {
        System.out.println("hash(\'Hello\')=" + generateHashCode("Hello"));
        System.out.println("hash(\'Goodbye\')=" + generateHashCode("Goodbye"));
    }

    public static int generateHashCode(String s) {
        int code = 0;
        
        for(char next_character: s.toCharArray()) {
            code += next_character;
        }
        
        return code;
    }
}
