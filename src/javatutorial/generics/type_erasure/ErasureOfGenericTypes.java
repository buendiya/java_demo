package javatutorial.generics.type_erasure;

/*
https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html
 */

class Node {

    private Comparable data;
    private Node next;

    public Node(Comparable data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data; }
    // ...
}


public class ErasureOfGenericTypes {
}
