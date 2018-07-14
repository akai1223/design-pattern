package com.zek.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

public class QiTianDaSheng extends Monkey implements Serializable, Cloneable {
    public JingGuBang jingGuBang;

    public QiTianDaSheng() {
        this.birthday = new Date();
        this.jingGuBang = new JingGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            QiTianDaSheng qiTianDaSheng = (QiTianDaSheng) ois.readObject();

            return qiTianDaSheng;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
