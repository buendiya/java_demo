package snippet;

class C {
    public C() throws Exception {
    }
}

class SomeClassImpl {
    static C c;
    static {
        // C tmp = null;
        try {
            c = new C();
        } catch (Exception uhe) {
            // Handle exception.
        }
        // c = tmp;
    }

}



public class StaticDemo {
    public static void main(String[] args) {
        SomeClassImpl s = new SomeClassImpl();
        System.out.println(s.c);

    }
}
