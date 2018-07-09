package com.zek.rmi;

import java.rmi.Naming;

public class RmiClient {
    public static void main(String[] args) throws Exception {
        IOperation iOperation = (IOperation) Naming.lookup("rmi://127.0.0.1:1099/Operation");
        System.out.println(iOperation.add(1, 2));
    }
}
