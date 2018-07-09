package com.zek.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperationImpl extends UnicastRemoteObject implements IOperation {

    public OperationImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException{
        return a + b;
    }
}
