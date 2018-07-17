package com.zek.dubbo.server;

import com.zek.spi.BaseDriver;

import java.util.ServiceLoader;

public class SpiDriverConnect {

    public static void main(String[] args) {
        ServiceLoader<BaseDriver> serviceLoader =
                ServiceLoader.load(BaseDriver.class);

        for (BaseDriver baseDriver : serviceLoader) {
            System.out.println(baseDriver.connect("127.0.0.1", 3066));
        }
    }
}
