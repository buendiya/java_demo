package snippet;


public class StringCompare {
    public static void demo1() {
        Object o = new String("hello");
        String s = new String("hello");
        String s2 = new String("hello");

        System.out.println(System.identityHashCode(o));
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s2));

        System.out.println(o.equals(s2));
        System.out.println(o == s2);
        System.out.println(s.equals(s2));
        System.out.println(s == s2);

    }

    public static void demo2() {
        System.out.println("\n");
        Object o = "hello";
        String s = "hello";
        String s2 = "hello";

        System.out.println(System.identityHashCode(o));
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s2));

        System.out.println(o.equals(s2));
        System.out.println(o == s2);
        System.out.println(s.equals(s2));
        System.out.println(s == s2);

    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }
}
