package snippet.generics;


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

class CC<T extends C> {
    public void fun() {
        // T t = new T("a");
        // System.out.println("I am C2's fun");
    }
}

public class Demo2 {
    public static void main(String[] args) throws Throwable {

    }
}

