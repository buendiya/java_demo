package snippet.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo {

    public static void fun1() {
        List<Integer> l = Arrays.asList(2, 1, 3);
        l.sort(null);
        System.out.println(l);

        l.sort((a, b) -> a - b);
        System.out.println(l);

        l.sort((a, b) -> b - a);
        System.out.println(l);

    }


    public static void main(String[] args) {
        fun1();
    }
}
