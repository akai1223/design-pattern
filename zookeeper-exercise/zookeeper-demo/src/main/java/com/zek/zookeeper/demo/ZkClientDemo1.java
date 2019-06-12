package com.zek.zookeeper.demo;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class ZkClientDemo1 {

    public static void main(String[] args) throws Exception {

        String connectString = "192.168.1.6:2181,192.168.1.6:2182,192.168.1.6:2183";

        String path = "/zk-book";

        ZkClient zkClient = new ZkClient(connectString, 5000);
        System.out.println("Zookeeper session established");

        zkClient.createEphemeral("/zk-test-ephemeral-");

        zkClient.subscribeChildChanges(path, (String parentPath, List<String> currentChilds) ->
                System.out.println(parentPath + " 's child changed, currentChilds:" + currentChilds));

        zkClient.createPersistent(path, true);
        Thread.sleep(1000);
        System.out.println(zkClient.getChildren(path));
        Thread.sleep(1000);
        zkClient.createPersistent(path + "/c1");
        Thread.sleep(1000);
        zkClient.delete(path + "/c1");
        Thread.sleep(1000);
        zkClient.delete(path);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
