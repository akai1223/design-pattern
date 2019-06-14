package com.zek.zookeeper.demo;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


public class ZookeeperDemo2 implements Watcher {

    private static final CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        String connectString = "192.168.1.6:2181,192.168.1.6:2182,192.168.1.6:2183";

        ZooKeeper zooKeeper = new ZooKeeper(connectString, 5000, new ZookeeperDemo2());
        System.out.println(zooKeeper.getState());
        connectedSemaphore.await();
        System.out.println("Zookeeper session established");

        String path1 = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode: " + path1);

        String path2 = zooKeeper.create("/zk-test-ephemeral-", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("Success create znode: " + path2);


    }


    /**
     * 功能描述:
     *
     * @author zhangkai
     * @date 2019-06-13
     * @param watchedEvent
     * @return void
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event: " + watchedEvent);
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            connectedSemaphore.countDown();
        }
    }
}
