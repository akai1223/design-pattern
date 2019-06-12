package com.zek.zookeeper.demo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo1 {

    static final String path = "/zk-boot";

    public static void main(String[] args) throws Exception {

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        String connectString = "192.168.1.6:2181,192.168.1.6:2182,192.168.1.6:2183";

        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .build();

        curatorFramework.start();
        curatorFramework.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath(path, "init".getBytes());

        Stat stat = new Stat();
        System.out.println(new String(curatorFramework.getData().storingStatIn(stat).forPath(path)));
        curatorFramework.delete()
                .deletingChildrenIfNeeded()
                .withVersion(stat.getVersion())
                .forPath(path);
    }
}
