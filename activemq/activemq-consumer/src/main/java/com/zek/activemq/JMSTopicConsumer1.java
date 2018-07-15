package com.zek.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSTopicConsumer1 {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.1.10:61616");

        Connection connnect = null;
        try {
            // 创建连接
            connnect = connectionFactory.createConnection();
            //启动连接
            connnect.start();
            //创建会话
            Session session = connnect.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建目的地
            Destination destination = session.createTopic("myTopic");
            //创建消费者
            MessageConsumer messageConsumer = session.createConsumer(destination);

            MessageListener messageListener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(((TextMessage)message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            };

            while (true) {

                messageConsumer.setMessageListener(messageListener);
                session.commit();
            }


            //接收消息
            //TextMessage textMessage = (TextMessage) messageConsumer.receive();

            //System.out.println(textMessage.getText());

            //session.commit();

            //session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
