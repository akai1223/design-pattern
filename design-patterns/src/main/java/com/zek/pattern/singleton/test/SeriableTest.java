package com.zek.pattern.singleton.test;

import com.zek.pattern.singleton.seriable.Seriable;
import pattern.singleton.seriable.Seriable;

import java.io.*;

public class SeriableTest {
    public static void main(String[] args) {
        Seriable seriable1 = null;
        Seriable seriable2 = Seriable.getInstance();

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("Seriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(seriable2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("Seriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            seriable1 = (Seriable) ois.readObject();
            ois.close();
            fis.close();

            System.out.println(seriable1);
            System.out.println(seriable2);
            System.out.println(seriable1 == seriable2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
