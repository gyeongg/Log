package com.log;

import java.io.IOException;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class log {
 
  static Logger logger = Logger.getLogger(log.class);
 
  public static void main(String[] args) {
    String pattern = "[%d{yyyy-MM-dd HH:mm:ss}] %-5p [%l] - %m%n";
    PatternLayout layout = new PatternLayout(pattern);
   
    // 처음 생성될 로그 파일의 이름
    String filename = "SystemLog.log";
   
    // 날짜 패턴에 따라 추가될 파일 이름
    String datePattern = ".yyyy-MM-dd";
   
    DailyRollingFileAppender appender = null;
    try {
      appender = new DailyRollingFileAppender(layout, filename, datePattern);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
   
    logger.addAppender(appender);
   
    logger.debug("Hello log4j.");
  }
}