package javatutorial.generics;

// https://docs.oracle.com/javase/tutorial/java/generics/bounded.html

class Box2<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

}

public class BoundedTypeParameters {
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)  // compiler error
                ++count;
        return count;
    }

    public static void main(String[] args) {
        Box2<Integer> integerBox = new Box2<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect(10);
        // integerBox.inspect("some text"); // error: this is still String!
    }
}
