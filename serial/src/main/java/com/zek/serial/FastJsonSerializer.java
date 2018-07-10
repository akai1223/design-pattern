package com.zek.serial;

import com.alibaba.fastjson.JSON;

public class FastJsonSerializer implements ISerialzer {
    @Override
    public <T> byte[] serializer(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public <T> T deSerializer(byte[] data, Class<T> clazz) {

        return (T)JSON.parseObject(new String(data), clazz);
    }
}
