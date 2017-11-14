package snippet;



class A {
    public void draw() {
        System.out.println("1");
    }

    public void draw1() {
        System.out.println("2");
    }
}

class B extends A {
    public void draw() {
        System.out.println("3");
    }
    public void draw2() {
        System.out.println("4");
    }
}

public class Downcast {
    public static void main(String args[]) {
        A a = new B();
        a.draw();
        a.draw1();
        ((B) a).draw2();
    }
}
