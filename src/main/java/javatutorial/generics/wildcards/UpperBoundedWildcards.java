package javatutorial.generics.wildcards;

// why we need generics:  https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html
// https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html

import java.lang.reflect.Array;
import java.util.*;


public class UpperBoundedWildcards {
    public static double sumOfList(List<? extends Number> list) {
        double s = 0;
        for (Number l : list) {
            s += l.doubleValue();
        }
        return s;
    }

    public static double sumOfList2(List<Number> list) {
        double s = 0;
        for (Number l : list) {
            s += l.doubleValue();
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println("sum of integer: " + sumOfList(Arrays.<Integer>asList(1, 2, 3)));
        System.out.println("sum of float: " + sumOfList(Arrays.asList(1.1, 2.0, 3.3)));

        // below is not working. https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html
        // System.out.println("sum of integer: " + sumOfList2(Arrays.<Integer>asList(1, 2, 3)));
    }

}
