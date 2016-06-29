package com.yew1eb.log;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 * @author zhouhai
 * @createTime 16/6/22
 * @description
 */
public class PrintwthLog4j {
    private final static Logger LOG = LoggerFactory.getLogger(PrintwthLog4j.class);
    public static final String SLF4J_LOG4J_LOGGER_ADAPTER = "org.slf4j.impl.Log4jLoggerAdapter";

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(com.yew1eb.log.PrintwthLog4j.class);
        System.out.println(logger.getClass().getName());



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
            org.apache.log4j.Logger.getLogger(PrintwthLog4j.class).setLevel(level);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
