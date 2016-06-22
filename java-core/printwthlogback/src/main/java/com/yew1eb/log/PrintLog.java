package com.yew1eb.log;

import com.yew1eb.util.LogbackUtils;
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
        Logger logger = LoggerFactory.getLogger(PrintLog.class);
        if (!(logger instanceof ch.qos.logback.classic.Logger)) {
            return;
        }
        ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger) logger;

        int i = 0;
        int n = 1000;
        while (i++ < n) {
            LOG.debug("i = {}, logger-name = {}", i, LOG.getName());
            LOG.info("i = {}, logger-name = {}", i, LOG.getName());
            LOG.warn("i = {}, logger-name = {}", i, LOG.getName());
            LOG.error("i = {}, logger-name = {}\n\n", i, LOG.getName());

            ch.qos.logback.classic.Level level = ch.qos.logback.classic.Level.DEBUG;
            switch (i % 4) {
                case 0:
                    level = ch.qos.logback.classic.Level.DEBUG;
                    break;
                case 1:
                    level = ch.qos.logback.classic.Level.INFO;
                    break;
                case 2:
                    level = ch.qos.logback.classic.Level.WARN;
                    break;
                case 3:
                    level = ch.qos.logback.classic.Level.ERROR;
                    break;
            }
            //logbackLogger.setLevel(level);
            LogbackUtils.setLogLevel("com.yew1eb.log.PrintLog", level.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
