package demo.other;

/**
 * Created by jingsz on 3/21/17.
 */
public class InheritanceTest {
    static class A {
        void fun() {
            System.out.println("I am a function defined in A");
        }
    }
    static class B extends A {
        void fun2() {
            System.out.println("I am a function defined in B");
        }
    }
    public static void main(String[] args) {
        A a = new B();
        a.fun();

        // below cannot be called
        // a.fun2();

        System.out.println("I am main");
    }
}
