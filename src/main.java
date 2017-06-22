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
            "appName",
            "partnerId",
            "platformId",
            "plat",
            "vName",
            "pcId",
            "vApp",
            "logTime",
            "ip",
            "sessionId",
            "abId",
            "userId",
            "devId",
            "unique_id",
            "mac",
            "imei",
            "udid",
            "idfa",
            "pName",
            "vOs",
            "model",
            "brand",
            "facturer",
            "resolution",
            "density",
            "dpi",
            "cpu",
            "net",
            "carrier"};

    static void test2() {
        for (String f: primary_fields) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        test2();
    }
}
