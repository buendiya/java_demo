/**
 * Created by jingsz on 2/7/17.
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.util.Bytes;



public class Main {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("a", "1");
        List<String>  l = Arrays.asList("a");
        System.out.println(m.toString());
        System.out.println(l.toString());
        System.out.println(m);
        System.out.println(l);
        System.out.println(String.format("%s", m));
        System.out.println(String.format("%s", l));

    }
}
