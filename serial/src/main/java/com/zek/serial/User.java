package com.zek.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Administrator
 */
public class User extends SuperClass {
    private static final long serialVersionUID = 6792846319109638939L;
    private String name;
    private int age;
    public static int num = 5;
    private transient String body;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        User.num = num;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", body='" + body + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
            out.writeObject(body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*ObjectOutputStream.PutField putFields = null;
        try {
            putFields = out.putFields();
            System.out.println("原密码:" + password);
            password = "encryption";//模拟加密
            putFields.put("password", password);
            System.out.println("加密后的密码" + password);
            out.writeFields();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void readObject(ObjectInputStream in) {

        try {
            in.defaultReadObject();
            body = (String) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*try {
            ObjectInputStream.GetField readFields = in.readFields();
            Object object = readFields.get("password", "");
            System.out.println("要解密的字符串:" + object.toString());
            password = "pass";//模拟解密,需要获得本地的密钥
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
