package com.zek.dubbo.server;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

public class DubboSpiTest {

    public static void main(String[] args) {
        /**
         * 获取自定义扩展的protocol
         */
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class)
                        .getExtension("myProtocol");
        System.out.println(protocol.getDefaultPort());

        /**
         * 获取dubbo默认的port 通过 @SPI("dubbo")
         */
        protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getDefaultExtension();
        System.out.println(protocol.getDefaultPort());

    }
}
