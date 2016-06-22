package com.yew1eb.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;


public final class LogbackUtils {
    public  static final String LOGBACK_CLASSIC        = "ch.qos.logback.classic";
    public  static final String LOGBACK_CLASSIC_LOGGER = "ch.qos.logback.classic.Logger";
    public  static final String LOGBACK_CLASSIC_LEVEL  = "ch.qos.logback.classic.Level";
    private static final Logger logger                 = LoggerFactory.getLogger(LogbackUtils.class);


    public static boolean setLogLevel(String loggerName, String logLevel)
    {
        String logLevelUpper = (logLevel == null) ? "OFF" : logLevel.toUpperCase();

        try
        {
            Package logbackPackage = Package.getPackage(LOGBACK_CLASSIC);
            if (logbackPackage == null)
            {
                logger.info("Logback is not in the classpath!");
                return false;
            }

            if ((loggerName == null) || loggerName.trim() == "")
            {
                loggerName = (String) getFieldVaulue(LOGBACK_CLASSIC_LOGGER, "ROOT_LOGGER_NAME");
            }

            Logger loggerObtained = LoggerFactory.getLogger(loggerName);
            if (loggerObtained == null)
            {
                logger.warn("No logger for the name: {}", loggerName);
                return false;
            }

            Object logLevelObj = getFieldVaulue(LOGBACK_CLASSIC_LEVEL, logLevelUpper);
            if (logLevelObj == null)
            {
                logger.warn("No such log level: {}", logLevelUpper);
                return false;
            }

            Class<?>[] paramTypes =  { logLevelObj.getClass() };
            Object[]   params     =  { logLevelObj };

            Class<?> clz    = Class.forName(LOGBACK_CLASSIC_LOGGER);
            Method   method = clz.getMethod("setLevel", paramTypes);
            method.invoke(loggerObtained, params);

            //logger.debug("Log level set to {} for the logger '{}'", logLevelUpper, loggerName);
            return true;
        }
        catch (Exception e)
        {
            logger.warn("Couldn't set log level to {} for the logger '{}'", logLevelUpper, loggerName, e);
            return false;
        }
    }

    private static Object getFieldVaulue(String fullClassName, String fieldName)
    {
        Class<?> clazz = null;
        Field field = null;
        try {
            clazz = Class.forName(fullClassName);
            field = clazz.getField(fieldName);
            return field.get(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}