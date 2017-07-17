/**
 * Created by jingsz on 2/7/17.
 */
import java.util.*;

import org.apache.log4j.Logger;
import org.apache.hadoop.io.Text;

public class main {
    static void test(String i) {
        System.out.println(i);
    }
    static  String toBinary( byte[] bytes )
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? "0" : "1");
        return sb.toString();
    }

    static String[] primary_fields = {
            "eventId",
            "carrier"};

    static void test2() {
        ArrayList<Object[]> result = new ArrayList<Object[]>();

        ArrayList<String> infos =
                new ArrayList<String>(Arrays.asList(primary_fields));
        infos.add(0, "test");

        result.add(infos.toArray(new String[0]));

        for (String f: primary_fields) {
            System.out.println(f);
        }
    }

    static void test3() {
        List<String> list = new ArrayList<String>();
        //add some stuff
        list.add("android");
        list.add("apple");
        String[] stringArray = list.toArray(new String[0]);

        for (String f: stringArray) {
            System.out.println(f);
        }

        stringArray[0] = "hello";

        for (String f: stringArray) {
            System.out.println(f);
        }
    }

    static void test4() {
        Integer i = null;
        if (i != null) {
            String s = i.toString();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        test4();
    }
}
