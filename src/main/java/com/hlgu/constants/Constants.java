package com.hlgu.constants;

import java.text.SimpleDateFormat;

public final class Constants {
    private Constants(){}

    public static final String DASH = "-";
    public static final String DOUBLE_DASH = "--";
    public static final String TAB = "\t";
    public static final String SLASH = "/";
    public static final String CTRL_A = "\u0001";
    public static final String CTRL_B = "\u0002";
    public static final String CTRL_C = "\u0003";

    public static final String MALE = "M";
    public static final String FEMALE = "F";

    public static final int ONE  = 1;
    public static final int ZERO = 0;

    public static final int POSITIVE = 1;
    public static final int NEGATIVE = 0;

    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT2 = "yyyy-MM-dd";

    public static final String MD5 = "MD5";

    public static final String IWT_IMEI_PREFIX = "imei__";
    public static final String IWT_IDFA_PREFIX = "idfa__";

    public static final String ACT = "act";
    public static final String CLK = "clk";
    public static final String IMP = "imp";

    public static final String IWT_ID = "iwt_id";
    public static final String MUID = "muid";
    public static final String MEDIA = "media";
    public static final String CHANNEL = "channel";
    public static final String CHANNEL_ID = "channel_id";
    public static final String ALBUM = "album";
    public static final String ALBUM_ID = "album_id";
    public static final String IP = "ip";
    public static final String VID = "vid";
    public static final String TS = "ts";

    public static final String REGEX_GENERAL = "*";
    public static final String AGE_PREFIX = "A";
    public static final String EMPTY_STRING = "";
    public static final String COMMA = ",";
    public static final String UNDERLINE = "_";

    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final Character NEW_LINE = '\n';

    public static final String DATES = "dates";
    public static final String CTR_DATA_ROOT = "/home/hdfs/hfa-saas/output/unity_export/";

    public static final int ONE_DAY_SECONDS = 3600 * 24;

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT2 = new SimpleDateFormat(DATE_FORMAT2);

}