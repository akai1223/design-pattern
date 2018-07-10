package com.zek.serial;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class XmlSerializer implements ISerialzer{

    private XStream xStream = new XStream(new Dom4JDriver());

    @Override
    public <T> byte[] serializer(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deSerializer(byte[] data, Class<T> clazz) {

        return (T)xStream.fromXML(new String(data));
    }
}
