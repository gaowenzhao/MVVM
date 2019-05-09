package com.zhao.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
  public static String transferLongToDate(String dateFormat, long millSec) {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    Date date = new Date(millSec);
    return sdf.format(date);
  }
}
