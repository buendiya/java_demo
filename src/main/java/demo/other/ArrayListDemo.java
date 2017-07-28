package demo.other;

import java.util.List;
import java.util.ArrayList;

class Box {
    int a = 0;
    Box(int a) {
        this.a = a;
    }
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}


public class ArrayListDemo {
    public static void main(String[] args) {

        List<Box> roster = new ArrayList<>();
        roster.add(new Box(1));
        roster.add(new Box(2));
        Box[] bArray = roster.toArray(new Box[2]);

        for(Box b: bArray) {
            System.out.println(b.a);
        }

        Integer[] i = new Integer[2];

        String s = "hello";
        System.out.println(s);
    }
}
