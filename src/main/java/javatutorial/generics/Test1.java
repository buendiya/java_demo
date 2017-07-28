package javatutorial.generics;

// https://docs.oracle.com/javase/tutorial/java/generics/types.html


class Box<T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }

}

public class Test1 {

    public static void main(String[] args) {
        Box<Integer> b = new Box<>();
        b.set(1);
        // b.set("");
        System.out.println(b.get());

        // 如果不指定generics type的话，默认是Object. https://docs.oracle.com/javase/tutorial/java/generics/erasure.html
        Box rawBox = new Box();
        rawBox.set(1);
        rawBox.set("");
        System.out.println(rawBox.get() instanceof Integer);

        Box<String> stringBox = new Box<>();
        rawBox = stringBox;
        rawBox.set(8);  // warning: unchecked invocation to set(T)
        System.out.println(rawBox.get());
    }
}
