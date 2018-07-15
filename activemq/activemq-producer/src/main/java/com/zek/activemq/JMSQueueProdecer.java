package com.zek.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSQueueProdecer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.1.10:61616");

        Connection connnect = null;
        try {
            //创建连接
            connnect = connectionFactory.createConnection();
            //开始连接
            connnect.start();
            //创建会话
            Session session = connnect.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建消息发送目的地
            Destination destination = session.createQueue("myQueue");
            //创建消息发送者
            MessageProducer messageProducer = session.createProducer(destination);
            //创建文本消息
            TextMessage textMessage = session.createTextMessage("hello activemq");
            //发送消息
            messageProducer.send(textMessage);

            session.commit();

            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
