package com.zek.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/2 下午1:31
 */
public class NIOServer {

    private int port = 8088;

    private Charset charset = Charset.forName("UTF-8");

    private Selector selector = null;

    public NIOServer(int port) throws IOException {
        this.port = port;

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(this.port));
        serverSocketChannel.configureBlocking(false);

        selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务已经启动， 监听端口是：" + this.port);

    }


    public void listener() throws IOException {

        while (true) {

            int wait = selector.select();

            if (wait == 0) continue;

            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                iterator.remove();

                process(selectionKey);
            }


        }
    }


    public void process(SelectionKey selectionKey) throws IOException {

        if (selectionKey.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();

            SocketChannel chient = serverSocketChannel.accept();

            chient.configureBlocking(false);

            chient.register(selector, SelectionKey.OP_READ);

            selectionKey.interestOps(SelectionKey.OP_ACCEPT);

            chient.write(charset.encode("请输入"));

        }

        if (selectionKey.isReadable()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();

            ByteBuffer buff = ByteBuffer.allocate(1024);
            StringBuilder content = new StringBuilder();

            try {
                while (client.read(buff) > 0) {
                    buff.flip();
                    content.append(charset.decode(buff));
                }

                selectionKey.interestOps(SelectionKey.OP_READ);
            } catch (Exception e) {
                selectionKey.cancel();
                if (selectionKey.channel() != null)
                    selectionKey.channel().close();
            }

            if (content != null && content.length() > 0) {

            }
        }
    }


}
