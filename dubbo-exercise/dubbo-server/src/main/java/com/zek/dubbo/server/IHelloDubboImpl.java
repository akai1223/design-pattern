package com.zek.dubbo.server;

import com.zek.dubbo.api.IHelloDubbo;

/**
 * @author zhangkai
 */
public class IHelloDubboImpl implements IHelloDubbo {
    @Override
    public String sayHello(String msg) {
        return "hello:" + msg;
    }
}
