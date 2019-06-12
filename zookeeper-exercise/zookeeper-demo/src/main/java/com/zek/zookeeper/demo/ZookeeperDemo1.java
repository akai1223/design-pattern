package com.zek.zookeeper.demo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperDemo1 implements Watcher {

    private static final CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {

        String connectString = "192.168.1.6:2181,192.168.1.6:2182,192.168.1.6:2183";

        ZooKeeper zooKeeper = new ZooKeeper(connectString, 5000, new ZookeeperDemo1());
        System.out.println(zooKeeper.getState());
        connectedSemaphore.await();
        System.out.println("Zookeeper session established");

        long sessionId = zooKeeper.getSessionId();
        byte[] sessionPasswd = zooKeeper.getSessionPasswd();

        ZooKeeper zooKeeper1 = new ZooKeeper(connectString, 5000, new ZookeeperDemo1(),
                1L, "test".getBytes());

        ZooKeeper zooKeeper2 = new ZooKeeper(connectString, 5000, new ZookeeperDemo1(),
                sessionId, sessionPasswd);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            connectedSemaphore.countDown();
        }
    }
}
