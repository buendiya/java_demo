
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64.Decoder;
import java.nio.charset.StandardCharsets;
import java.util.*;


import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

class GZIPCompression {

    public static byte[] compress(final String str) throws IOException {
        if ((str == null) || (str.length() == 0)) {
            return null;
        }
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(str.getBytes("UTF-8"));
        gzip.close();
        return obj.toByteArray();
    }

    public static String decompress(final byte[] compressed) throws IOException {
        String outStr = "";
        if ((compressed == null) || (compressed.length == 0)) {
            return "";
        }
        if (isCompressed(compressed)) {
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outStr += line;
            }
        } else {
            outStr = new String(compressed);
        }
        return outStr;
    }

    public static boolean isCompressed(final byte[] compressed) {
        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
    }
}


class MpLogParse {
    String record;
    public MpLogParse(String record) {
        this.record = record;
    }

    Boolean isJson(String data) {
        try {
            JSON.parseObject(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    String parse_user_id(String userId) {
        return userId;
    }

    String parse_video_id(String videoId) {
        return videoId;
    }

    List<String> parse() throws ClassCastException, UnsupportedEncodingException, IOException{
        ArrayList<Object[]> result = new ArrayList<Object[]>();

        List<String> results = new ArrayList<String>();
        String[] parts = this.record.split("&");
        String data = parts[0].split("=")[1];
        String client_ip = parts[1].split("=")[1];
        String ngx_time = parts[2].split("=")[1];

        String url_decoded_data = java.net.URLDecoder.decode(data, "UTF-8");
        JSONObject data_json;
        if (isJson(url_decoded_data)) {
            data_json = JSON.parseObject(url_decoded_data);
        } else {
            byte[] decoded_url_decoded_data  = Base64.getDecoder().decode(url_decoded_data);
            String decompressed_url_decoded_data  = GZIPCompression.decompress(decoded_url_decoded_data);
            data_json = JSON.parseObject(decompressed_url_decoded_data);
        }

        data_json.put("client_ip", client_ip);
        data_json.put("ngx_time", ngx_time);

        String userId = data_json.getString("userId");
        if (userId != null) {
            data_json.put("userId", parse_user_id(userId));
        }

        if (data_json.containsKey("event")) {
            for (Object eventFields: data_json.getJSONArray("event")) {
                JSONObject eventFieldsJSON = (JSONObject) eventFields;
                String videoId = eventFieldsJSON.getString("videoId");
                if (videoId != null) {
                    eventFieldsJSON.put("videoId", parse_video_id(videoId));
                }

                List<String> eventFieldsList = new ArrayList<String>();
                for (Map.Entry<String, Object> entry : eventFieldsJSON.entrySet())
                {
                    eventFieldsList.add(entry.getKey() + ":" + entry.getValue());
                }
                
                Map outputMap = new HashMap<String, Object>(data_json);
                outputMap.put("eventId", eventFieldsJSON.getString("eventId"));
                outputMap.put("logTime", eventFieldsJSON.getString("logTime"));
                outputMap.put("event", String.join(",", eventFieldsList));
            }
        }


        results.add(client_ip);
        results.add(ngx_time);
        System.out.println(data_json.toString());
        // results.add(decoded.toString());
        return results;
    }

}


class Simple {
    public static void main(String[] args) throws IOException{
        String record = "data=%7B%22dpi%22%3A%22480%22%2C%22userId%22%3Anull%2C%22carrier%22%3A%22%E6%9C%AA%E7%9F%A5%22%2C%22idfa%22%3Anull%2C%22plat%22%3A%22android%22%2C%22cpu%22%3A%22AArch64%22%2C%22facturer%22%3A%22samsung%22%2C%22imei%22%3A%22355905071238449%22%2C%22udid%22%3A%22579E45DAF60092E3770EBF02AC7126FE%22%2C%22pName%22%3A%22com.yixia.videoeditor%22%2C%22vOs%22%3A%227.0%22%2C%22vName%22%3A%226.6.7%22%2C%22vApp%22%3A%2258222%22%2C%22platformId%22%3A%221%22%2C%22mac%22%3A%2202%3A00%3A00%3A00%3A00%3A00%22%2C%22sessionId%22%3A%22e7247c8fd820794f00598642ac9ddf78%22%2C%22net%22%3A%221%22%2C%22appName%22%3A%22%E7%A7%92%E6%8B%8D%22%2C%22density%22%3A%223.0%22%2C%22abId%22%3A%225-1%22%2C%22brand%22%3A%22samsung%22%2C%22unique_id%22%3A%223f877d74-2d04-3f10-b2fc-440ba80fb54a%22%2C%22ip%22%3A%22192.168.99.133%22%2C%22resolution%22%3A%221080x1920%22%2C%22pcId%22%3A%22yixia%22%2C%22devId%22%3A%22F905C794757FD23CB6A43B489BFDCF4E%22%2C%22partnerId%22%3A%221%22%2C%22model%22%3A%22SM-G9300%22%2C%22event%22%3A%5B%7B%22logTime%22%3A1495382376804%2C%22eventId%22%3A%22exit%22%2C%22exitAt%22%3A1495382376804%2C%22exitType%22%3A2%2C%22exitTime%22%3A106374%7D%5D%7D&clientIp=124.65.195.2&ngxTime=1495382401000";
        String record2 = "data=%7B%22dpi%22%3A%22640%22%2C%22userId%22%3Anull%2C%22carrier%22%3A%22%E6%9C%AA%E7%9F%A5%22%2C%22idfa%22%3Anull%2C%22plat%22%3A%22android%22%2C%22cpu%22%3A%22AArch64%22%2C%22facturer%22%3A%22samsung%22%2C%22imei%22%3A%22359596061477372%22%2C%22udid%22%3A%22DCD823589AB011A62C37D5E61527BD1E%22%2C%22vOs%22%3A%226.0.1%22%2C%22pName%22%3A%22com.yixia.videoeditor%22%2C%22vName%22%3A%226.6.7%22%2C%22vApp%22%3A%2258222%22%2C%22platformId%22%3A%221%22%2C%22mac%22%3A%2202%3A00%3A00%3A00%3A00%3A00%22%2C%22sessionId%22%3A%2222e64b3eb9d9d88566c19ee413a7770c%22%2C%22net%22%3A%221%22%2C%22density%22%3A%224.0%22%2C%22appName%22%3A%22%E7%A7%92%E6%8B%8D%22%2C%22abId%22%3A%225-1%22%2C%22brand%22%3A%22samsung%22%2C%22unique_id%22%3A%22c5f34f8a-512d-317c-a1c8-5084b639982c%22%2C%22ip%22%3A%2210.30.3.210%22%2C%22resolution%22%3A%221440x2560%22%2C%22pcId%22%3A%22yixia%22%2C%22devId%22%3A%22463F4E41A10D05CBFDAB7909EA915318%22%2C%22model%22%3A%22SM-G9250%22%2C%22partnerId%22%3A%221%22%2C%22event%22%3A%5B%7B%22startType%22%3A2%2C%22logTime%22%3A1495507235424%2C%22eventId%22%3A%22start%22%2C%22startAt%22%3A1495507235422%7D%5D%7D&clientIp=111.202.106.229&ngxTime=1495507233000";
        MpLogParse mpLogParse = new MpLogParse(record2);
        System.out.println(String.join("\n", mpLogParse.parse()));
    }
}
