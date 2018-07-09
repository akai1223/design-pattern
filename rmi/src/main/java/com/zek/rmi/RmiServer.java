package com.zek.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        IOperation iOperation = new OperationImpl();
        Naming.rebind("rmi://127.0.0.1:1099/Operation", iOperation);
        System.out.println("service running...");
    }
}
