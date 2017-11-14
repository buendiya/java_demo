package snippet.abstract_demo;


import java.lang.reflect.ParameterizedType;

abstract class Parent {
    public void fun1() {
        System.out.println("I am parent's fun1");
    }
}


class Child extends Parent {
    @Override
    public void fun1() {
        System.out.println("I am child's fun1");
    }
}

public class Demo {
    public static void main(String[] args) {
        Parent p = new Child();
        p.fun1();
    }
}
