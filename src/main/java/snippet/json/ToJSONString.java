package snippet.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;


public class ToJSONString {
    static void demo() {
        List<Map<String, Object>> longs = new ArrayList<Map<String, Object>>();
        Map<String, Object> m = new HashMap<>();
        m.put("hi", "a");

        Map<String, Object> m2 = new HashMap<>();
        m2.put("hi", "m2");
        Map<String, Object> m3 = new HashMap<>();
        m3.put("hi", m2);

        longs.add(m);
        longs.add(m3);

        String actual = JSON.toJSONString(longs);
        System.out.println(actual);
    }

    public static void main(String[] args) {
        demo();
    }
}
