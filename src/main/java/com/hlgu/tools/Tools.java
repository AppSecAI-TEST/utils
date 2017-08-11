package com.hlgu.tools;

import com.google.common.collect.Sets;
import com.hlgu.constants.Constants;
import org.apache.commons.codec.binary.Base64;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import static com.hlgu.constants.Constants.SIMPLE_DATE_FORMAT;

public final class Tools {
    private Tools() {}

    public static String stampToDate(String ts) {
        return SIMPLE_DATE_FORMAT.format(string2Date(ts));
    }

    public static Calendar ts2Calendar(String ts) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(string2Date(ts));
        return calendar;
    }

    public static int stampToMinutesSection(String ts) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(string2Date(ts));

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return (int) (hour / 0.25 + minute / 15);
    }

    public static String removeLastCharacter(String s) {
        if (s.length() > 1) return s.substring(0, s.length() - 1);
        else return s;
    }

    public static String removeFirstCharacter(String s) {
        if (s.length() > 1) return s.substring(1, s.length());
        else return s;
    }

    public static long getTsFromSessionID(String sid) {
        byte[] bytes = Base64.decodeBase64(sid);
        long ts = 0L;
        for (int i = 4; i < 8; i++) ts = (ts << 8) + (bytes[11 - i] & 0xff);
        return ts;
    }

    public static <K> void add2Map(Map<K, Integer> map, K key, Integer value) {
        map.put(key, mapGetOrElse(map, key, 0) + value);
    }

    public static <K> void add2Map(Map<K, Double> map, K key, Double value) {
        map.put(key, mapGetOrElse(map, key, 0.0d) + value);
    }

    public static String MD5(String s) {
        String md5 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            BigInteger n = new BigInteger(1, messageDigest.digest(s.getBytes()));
            md5 = n.toString(16);
            while (md5.length() < 32) md5 = "0" + md5;
        } catch (NoSuchAlgorithmException ex) {
            md5 = null;
        }
        return md5;
    }

    public static <K, V> Map<K, V> join2Maps(Map<K, V> left, Map<K, V> right) {
        Class l = left.getClass();
        Class r = right.getClass();

        assert l.equals(r);

        Map<K, V> map = null;
        try {
            map = (Map<K, V>) l.newInstance();
        } catch (InstantiationException ie) {
            map = null;
            ie.printStackTrace();
        } catch (IllegalAccessException iea) {
            map = null;
            iea.printStackTrace();
        }

        map.putAll(left);
        map.putAll(right);

        return map;
    }

    public static <K, V> V mapGetOrElse(Map<K, V> map, K key, V value) {
        return map.containsKey(key) ? map.get(key) : value;
    }

    public static <K, V> void printMap(Map<K, V> map, PrintStream out) {
        Set<Map.Entry<K, V>> entries = map.entrySet();
        for (Map.Entry<K, V> entry : entries)
            out.println(entry.getKey() + Constants.COMMA + entry.getValue());
    }

    public static Set<String> unique(String s, String delimiter) {
        String[] records = s.split(delimiter);
        Set<String> set = Sets.newHashSet();
        for (String record : records)
            set.add(record);
        return set;
    }

    public static String uniqueString(String s, String delimiter) {
        Set<String> set = unique(s, delimiter);
        StringBuffer sb = new StringBuffer();
        for (String str : set)
            sb.append(str).append(delimiter);
        return removeLastCharacter(sb.toString());
    }

    public static Date string2Date(String s) {
        return new Date(new Long(s));
    }

    public static Date string2Date(String s, String format) {
        try {
            return new SimpleDateFormat(format).parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String date2String(Date date, String format) {
       return new SimpleDateFormat(format).format(date);
    }

    public static <K extends Comparable,V> Map.Entry<K,V> maxByKey(Map<K,V> map){
        Set<Map.Entry<K,V>> kvSet = map.entrySet();
        Map.Entry<K,V> max = null;
        for (Map.Entry<K,V> entry : kvSet) {
            if (max == null) {
                max = entry;
                continue;
            }

           if (entry.getKey().compareTo(max.getKey()) > 0)
               max = entry;
        }

        return max;
    }

    public static <K,V extends Comparable> Map.Entry<K,V> maxByValue(Map<K,V> map){
        Set<Map.Entry<K,V>> kvSet = map.entrySet();
        Map.Entry<K,V> max = null;
        for (Map.Entry<K,V> entry : kvSet) {
            if (max == null) {
                max = entry;
                continue;
            }

            if (entry.getValue().compareTo(max.getValue()) > 0)
                max = entry;
        }

        return max;
    }

    public static <K> void swap(K k1, K k2) {
        K tmp = k1;
        k1 = k2;
        k2 = tmp;
    }
}
