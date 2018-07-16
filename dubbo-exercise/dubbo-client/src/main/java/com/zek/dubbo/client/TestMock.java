package com.zek.dubbo.client;

import com.zek.dubbo.api.IHelloDubbo;

public class TestMock implements IHelloDubbo {
    @Override
    public String sayHello(String msg) {
        return "服务繁忙" + msg;
    }
}
