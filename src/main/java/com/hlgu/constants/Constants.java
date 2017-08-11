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

    public static final String REGEX_GENERAL = "*";
    public static final String EMPTY_STRING = "";
    public static final String COMMA = ",";
    public static final String UNDERLINE = "_";

    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final Character NEW_LINE = '\n';

    public static final int ONE_DAY_SECONDS = 3600 * 24;

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT2 = new SimpleDateFormat(DATE_FORMAT2);

}