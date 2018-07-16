package com.zek.dubbo.server;

import com.zek.dubbo.api.IHelloDubbo;

public class IHelloDubboImpl2 implements IHelloDubbo {
    @Override
    public String sayHello(String msg) {
        return "hello dubbo version 2" + msg;
    }
}
