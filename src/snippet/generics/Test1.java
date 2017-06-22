package snippet.generics;



class Box<T> {

    private T t;

    // method 的范型 和 Box类的范型 的名字都是T， java是如何处理的？
    public <T> void get(T a) {
        System.out.println(a);
    }

    public void get2(T a) {
        System.out.println(a);
    }
}


public class Test1 {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box();

        integerBox.get(2);
        integerBox.get("s");    // T变为了String类型，说明method的范型类型会将类的范型类型覆盖掉

        integerBox.get2(2);
        // integerBox.get2("s");    // compile error. incompatible types: java.lang.String cannot be converted to java.lang.Integer
    }
}

