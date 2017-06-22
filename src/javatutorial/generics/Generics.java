package javatutorial.generics;

// https://docs.oracle.com/javase/tutorial/java/generics/why.html

import java.util.*;


public class Generics {
    public void test1() {
        List list = new ArrayList();
        list.add("hello");
        // 必须要加(String) 做强制转换
        String s = (String) list.get(0);

        List<String> list2 = new ArrayList<>();
        list2.add("hello");
        String s2 = list2.get(0);   // no cast

    }


    public static void main(String[] args) {
        Generics gt = new Generics();
    }
}
