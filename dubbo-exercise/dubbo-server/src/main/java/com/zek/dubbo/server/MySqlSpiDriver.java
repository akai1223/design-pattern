package com.zek.dubbo.server;

import com.zek.spi.BaseDriver;

/**
 * java spi 实现
 */
public class MySqlSpiDriver implements BaseDriver {
    @Override
    public String connect(String host, Integer port) {
        return "MySql Driver " + host + ":" + port;
    }
}
