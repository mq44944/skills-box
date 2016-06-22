package com.yew1eb.log;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;


/**
 * @author zhouhai
 * @createTime 16/6/22
 * @description
 */
public class PrintLog {
    private final static Logger LOG = LoggerFactory.getLogger(PrintLog.class);

    public static void main(String[] args) {
        System.out.println(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());

        int i = 0;
        int n = 1000;
        while (i++ < n) {
            LOG.debug("i = {}, logger-name = {}", i, LOG.getName());
            LOG.info("i = {}, logger-name = {}", i, LOG.getName());
            LOG.warn("i = {}, logger-name = {}", i, LOG.getName());
            LOG.error("i = {}, logger-name = {}\n\n", i, LOG.getName());

            org.apache.log4j.Level level = org.apache.log4j.Level.DEBUG;
            switch (i % 4) {
                case 0:
                    level = org.apache.log4j.Level.DEBUG;
                    break;
                case 1:
                    level = org.apache.log4j.Level.INFO;
                    break;
                case 2:
                    level = org.apache.log4j.Level.WARN;
                    break;
                case 3:
                    level = org.apache.log4j.Level.ERROR;
                    break;
            }
            LogManager.getLogger(PrintLog.class).setLevel(level);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
日志记录器（Logger）的行为是分等级的：
分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者您定义的级别。Log4j建议只使用四个级别，优先级从高到低分别是 ERROR、WARN、INFO、DEBUG。通过在这里定义的
级别，您可以控制到应用程序中相应级别的日志信息的开关。比如在这里定义了INFO级别， 则应用程序中所有DEBUG级别的日志信息将不被打印出来。
*/