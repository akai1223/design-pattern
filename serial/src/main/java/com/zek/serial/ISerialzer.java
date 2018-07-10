package com.zek.serial;

public interface ISerialzer {

    <T> byte[] serializer(T obj);

    <T> T deSerializer(byte[] data, Class<T> clazz);
}
