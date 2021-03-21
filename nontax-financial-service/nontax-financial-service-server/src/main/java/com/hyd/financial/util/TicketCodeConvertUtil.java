package com.hyd.financial.util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;
/**
 * @author yanduohuang
 * @date 2021/3/21 21:31
 */
public class TicketCodeConvertUtil {
    public static final Long MIN = 0L;
    public static final Long MAX = 9999999999L;
    public static String longConvertString(Long code) {

        if (code >= MIN && code <= MAX) {
            StringBuilder stringBuilder = new StringBuilder("0000000000");
            String s = Long.toString(code);
            stringBuilder.replace(stringBuilder.length()-s.length(),stringBuilder.length(),s);
            return stringBuilder.toString();
        }
        return null;
    }
    public static Long stringConvertLong(String code) {
        if (code !=null) {
            final Pattern compile = compile("([0-9]{10})");
            Matcher matcher = compile.matcher(code);
            if (matcher.find()&&matcher.groupCount()==1) {
                while (code.charAt(0) == '0' && code.length() > 1) {
                    code = code.substring(1);
                }
                return Long.valueOf(code);
            }
        }

        return null;
    }
    private TicketCodeConvertUtil(){}

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now.format(DateTimeFormatter.ISO_DATE);
        System.out.println(now);
        System.out.println(longConvertString(1123L));
        System.out.println(stringConvertLong("0000000000"));
    }
}
