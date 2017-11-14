package snippet;



class Parent {
    private String s;
    public void fun() {
        System.out.println("I am parent");
    }
    protected String getS() {
        return s;
    }

}

class Child extends Parent {
    public void fun() {
        fun2();
    }
    public void fun2() {
        System.out.println("I am child");
        System.out.println(super.getS());
    }

}

public class ExtendsDemo {

    public static void main(String[] args) {
        Parent p = new Child();
        p.fun();
        // p.fun2();
    }

}
