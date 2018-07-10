package com.zek.serial;

import java.io.Serializable;

public class SuperClass implements Serializable {
    private static final long serialVersionUID = 3186055416080981867L;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
