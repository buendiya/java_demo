package snippet;

import java.util.*;


public class CollectionsDemo {
    public static void mapDemo() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("a", "2");
        m.put("a", "3");
        System.out.println(m);
        m.remove("a");
        m.remove("not exist");
        System.out.println(m);
    }


    public static void listDemo() {
        List l = new ArrayList<String>();
        System.out.println(String.join(",", l));
        l.add("a");
        l.add(null);
        l.remove("b");
        System.out.println(String.join(",", l));
        System.out.println(l.size());

        // Arrays.asList返回的ArrayList和java.util.ArrayList不是同一个类
        // List<String> al = Arrays.asList("a", "b");
        // al.add("a");
    }

    public static void setDemo() {
        String str = "a,b,c,a";
        List l = new ArrayList<String>(Arrays.asList(str.split(",")));
        Set s = new HashSet<String>(Arrays.asList(str.split(",")));

        System.out.println(s);
        s.remove("b");
        s.remove("not exist");
        s.add("d");
        System.out.println(s);
        System.out.println(String.join(",", s));
    }

    public static void main(String[] args) {
        mapDemo();
    }
}
