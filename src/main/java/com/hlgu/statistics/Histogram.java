package com.hlgu.statistics;

import com.google.common.collect.Maps;
import com.hlgu.tools.Tools;

import java.util.List;
import java.util.Map;

public final class Histogram {
    private Histogram() {}

    public static <K> Map<K, Integer> histo(List<K> list){
        Map<K, Integer> histogram = Maps.newHashMap();
        for (K record : list)
            Tools.add2Map(histogram, record, 1);
        return histogram;
    }
}
