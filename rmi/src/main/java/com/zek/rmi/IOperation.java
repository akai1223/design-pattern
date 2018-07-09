package com.zek.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperation extends Remote {
    int add(int a, int b) throws RemoteException;
}
