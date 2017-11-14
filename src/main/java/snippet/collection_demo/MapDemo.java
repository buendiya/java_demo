package snippet.collection_demo;

import java.util.HashMap;
import java.util.Map;


public class MapDemo {
    public static void demo1() {
        Map<String, Object> m = new HashMap<>();
        m.put("k1", "a");
        m.put("k2", 1);
        m.put("k3", true);

        System.out.println(m.get("k1"));
        System.out.println(m.get("k2"));
        System.out.println(m.get("k3"));

        System.out.println(m.get("k1").getClass());
        System.out.println(m.get("k2").getClass());
        System.out.println(m.get("k3").getClass());

        String v1 = (String) m.get("k1");
        System.out.println(v1);
        Integer v2 = (Integer) m.get("k2");
        System.out.println(v2);
    }

    public static void demo2() {
        Map<String, String> m = new HashMap<>();
        m.put("k1", "a");
        System.out.println(m.get("k1").equals("a"));
        System.out.println(m.get("k2").equals("true"));
    }

    public static void main(String[] args) {
        demo2();

    }
}
