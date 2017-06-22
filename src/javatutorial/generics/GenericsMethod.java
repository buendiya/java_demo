package javatutorial.generics;

// https://docs.oracle.com/javase/tutorial/java/generics/methods.html


class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}


class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}


class Test {
    public static <T> void test(T k) {
        System.out.println(k.getClass().getName());
        if (k instanceof String) {
            System.out.println("input is a String");
        }
    }
}

public class GenericsMethod{
    public static void main(String[] args) {
    }
}
