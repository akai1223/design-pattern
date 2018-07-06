package com.zek.pattern.prototype.deep;

public class Test {
    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        try {
            // 深度拷贝，引用类型，对象是不同的，不仅仅拷贝引用，创建了新的对象
            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
            System.out.println(qiTianDaSheng.jingGuBang == clone.jingGuBang);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
