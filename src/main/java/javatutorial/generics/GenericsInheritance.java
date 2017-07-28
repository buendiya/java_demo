package javatutorial.generics;

// https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html


public class GenericsInheritance {
    static void test1() {
        Box<Number> box = new Box<>();
        box.set(new Integer(1));
        box.set(1.2);
    }

    static void test2() {
        Box<Number> box = new Box<>();
        Box<Integer> box2 = new Box<>();
        // below not working either
        // because Box<Integer> and Box<Double> are not subtypes of Box<Number>.
        // box = box2;
    }

    static Number boxTest(Box<Number> box) {
        return box.get();
    }

    static Number boxTest2(Box<? extends Number> box) {
        return box.get();
    }

    public static void main(String[] args) {
        Box<Integer> b = new Box<>();
        // because Box<Integer> and Box<Double> are not subtypes of Box<Number>.
        // boxTest(b);

        // https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html
        boxTest2(b);

    }
}
