package com.yew1eb.util;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * @author zhouhai
 * @createTime 16/6/22
 * @description
 */

public final class LogbackUtilsTest
{
    @Test
    public void testSetLogLevel() throws Throwable
    {
        assertEquals(true,  LogbackUtils.setLogLevel(null,   null));
        assertEquals(true,  LogbackUtils.setLogLevel(null,   "TRACE"));
        assertEquals(true,  LogbackUtils.setLogLevel(".",    "DEBUG"));
        assertEquals(true,  LogbackUtils.setLogLevel(null,   "INFO"));
        assertEquals(true,  LogbackUtils.setLogLevel(null,   "WARN"));
        assertEquals(false, LogbackUtils.setLogLevel(null,   "WARNING"));
        assertEquals(false, LogbackUtils.setLogLevel(null,   ""));
        assertEquals(false, LogbackUtils.setLogLevel(null,   "-"));
        assertEquals(true,  LogbackUtils.setLogLevel("org.", "DEBUG"));
    }
}