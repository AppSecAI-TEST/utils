package com.hlgu.statistics;

import com.google.common.collect.Maps;
import static com.hlgu.tools.Tools.*;

import java.util.List;
import java.util.Map;

public final class Histogram {
    private Histogram() {}

    public static <K> Map<K, Integer> histo(List<K> list){
        Map<K, Integer> histogram = Maps.newHashMap();
        for (K record : list)
            add2Map(histogram, record, 1);
        return histogram;
    }

    public static Map<String, Double> percentageHisto(String in, String delimiter){
        Map<String, Double> map = Maps.newHashMap();
        String[] records = in.split(delimiter);
        Map<String, Integer> histogram = Maps.newHashMap();
        double sum = 0.0d;
        for (String record : records) {
            add2Map(histogram, record, 1);
            sum += 1;
        }

        for (String record : records)
            map.put(record, mapGetOrElse(histogram, record, 0) / sum);
        return map;
    }
}
