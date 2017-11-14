package snippet.reflection;

class C {
    String a;
    public C(String a) {
        this.a = a;
    }
    public void fun() {
        System.out.println("I am C's fun");
    }
}


class C1 extends C {
    public C1(String a) {
        super(a);
    }

    @Override
    public void fun() {
        System.out.println("I am C1's fun");
    }
}


class C2 extends C {
    public C2(String a) {
        super(a);
    }

    @Override
    public void fun() {
        System.out.println("I am C2's fun");
    }
}


public class Demo1 {
    public static void fun(Class c) throws Throwable{
        Object o = c.getDeclaredConstructor(C.class).newInstance("a");
        C co = (C) o;
        co.fun();
    }

    public static void main(String[] args) throws Throwable {
        fun(C.class);
        fun(C1.class);
        fun(C2.class);
    }
}
