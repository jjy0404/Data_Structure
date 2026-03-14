
public class CompareToTest {

    public static void main(String[] args) {
        String less = "less";
        String middle = "middle";
        String more = null;
        
        System.out.println("Compare middle to less = " + middle.compareTo(less));
        System.out.println("Compare middle to middle = " + middle.compareTo(middle));
        System.out.println("Compare middle to more = " + middle.compareTo(more));

    }

}
