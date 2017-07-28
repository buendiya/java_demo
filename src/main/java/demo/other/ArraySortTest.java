package demo.other;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class ArraySortTest {
    public static void main(String[] args) {

        // 下面这种不working，因为在排序时需要非primitive类型
//        int[] myIntArray = {2,1,3};
        Integer[] myIntArray = {2,1,3};
        Arrays.sort(myIntArray, (a, b) -> a - b);
        for (int i: myIntArray) {
            System.out.println(i);
        }


    }
}
