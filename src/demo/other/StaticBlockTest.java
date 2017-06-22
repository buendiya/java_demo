package demo.other;

/**
 * Created by jingsz on 3/21/17.
 */
public class StaticBlockTest {
    static{
        System.out.println("static block is invoked before main");
    }

    public static void main(String[] args) {
        System.out.println("I am main");
    }
}
