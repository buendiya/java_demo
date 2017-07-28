/**
 * Created by jingsz on 2/7/17.
 */
import java.util.*;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmojiEraser{

    private static final String EMOJI_RANGE_REGEX =
            "(?:[\uD83C\uDF00-\uD83D\uDDFF]|[\uD83E\uDD00-\uD83E\uDDFF]|[\uD83D\uDE00-\uD83D\uDE4F]|" +
                    "[\uD83D\uDE80-\uD83D\uDEFF]|[\u2600-\u26FF]\uFE0F?|" +
                    "[\u2700-\u27BF]\uFE0F?|\u24C2\uFE0F?|[\uD83C\uDDE6-\uD83C\uDDFF]{1,2}|" +
                    "[\uD83C\uDD70\uD83C\uDD71\uD83C\uDD7E\uD83C\uDD7F\uD83C\uDD8E\uD83C\uDD91-\uD83C\uDD9A]\uFE0F?|" +
                    "[\u0023\u002A\u0030-\u0039]\uFE0F?\u20E3|[\u2194-\u2199\u21A9-\u21AA]\uFE0F?|" +
                    "[\u2B05-\u2B07\u2B1B\u2B1C\u2B50\u2B55]\uFE0F?|[\u2934\u2935]\uFE0F?|[\u3030\u303D]\uFE0F?|" +
                    "[\u3297\u3299]\uFE0F?|" +
                    "[\uD83C\uDE01\uD83C\uDE02\uD83C\uDE1A\uD83C\uDE2F\uD83C\uDE32-\uD83C\uDE3A\uD83C\uDE50\uD83C\uDE51]" +
                    "\uFE0F?|[\u203C\u2049]\uFE0F?|[\u25AA\u25AB\u25B6\u25C0\u25FB-\u25FE]\uFE0F?|[\u00A9\u00AE]\uFE0F?|" +
                    "[\u2122\u2139]\uFE0F?|\uD83C\uDC04\uFE0F?|\uD83C\uDCCF\uFE0F?|" +
                    "[\u231A\u231B\u2328\u23CF\u23E9-\u23F3\u23F8-\u23FA]|" +
                    "[\uFE0F]\uFE0F?)";
    // "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
    private static final Pattern PATTERN = Pattern.compile(EMOJI_RANGE_REGEX);

    /**
     * Finds and removes emojies from @param input
     *
     * @param input the input string potentially containing emojis (comes as unicode stringfied)
     * @return input string with emojis replaced
     */
    public String eraseEmojis(String input) {
        if (input == null || input == "") {
            return input;
        }
        Matcher matcher = PATTERN.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}


public class Main {

    static String filterEmoji(String str) {
        return "hello";
    }

    public static void main(String[] args) {
        String s = "爱护青蛙的好猫咪...我们吸猫，猫吸蛤蟆\uD83D\uDC31\uD83D\uDEA8";
        String s2 = "【月月独家定制】 ‼️4月7日晚八点‼️ 视频介绍2⃣️ 转发评论️ 评论里选三个真爱送新品";
        System.out.println(s);
        System.out.println(s2);
        System.out.println(new EmojiEraser().eraseEmojis(s));
        System.out.println(new EmojiEraser().eraseEmojis(s2));
    }
}
