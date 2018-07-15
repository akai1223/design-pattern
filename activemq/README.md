# activemq

解耦、流量削峰、异步化

# 消息传递域 （point to point p2p 点对点 / （pub/sub）发布订阅）
 
 1.p2p 每个消息只有一个消费者，离线的消息，激活后可以再收到，时间无关的
 2.pub/sub发布订阅模式 topic多个消费者，有时间相关性（离线的消息收不到）
 
 消息头、消息体、消息属性
 
 消息头:
 message去设置
 
 消息体消息类型：
 byte map text stream object
 
 消息的属性：message.setStringProperties();
 
 3.pub/sub 离线的消息收不到（必须收到消息设置持久化）
 
 首先注册，再发送消息，才能持久化
 发送端要设置为持久化消息
 producer.setDeliveryMode(DeliveryMode.PERSISTENT);
 
 # 确认机制（保证消息可靠性）事务会话，非事务会话
 
 connect.createSession(Boolean.TRUE, AUTO_ACKNOWLEDGE);
 事务会话：
 对于producer:
 session.commit(); 消息确认发送，到broker
 session.rollback(); 消息不发送到broker
 
 对于consumer：
 session.commit(); 确认被处理
 session.rollback(); 可以重新处理，重复处理（由broker重发）
 
 
 非事务会话：
 对于producer:
 不用session.commit(),自动提交到broker
 
 对于consumer：
 connect.createSession(Boolean.FALSE, AUTO_ACKNOWLEDGE);
 自动确认
 
 connect.createSession(Boolean.FALSE, CLIENT_ACKNOWLEDGE);
 CLIENT_ACKNOWLEDGE只在消费端设置
 手动确认，调用message.acknowledge();不手动确认，可以重复消费消息
 调用message.acknowledge()，会提交在此之前的所有消息。
 
 connect.createSession(Boolean.FALSE, DUPS_OK_ACKNOWLEDGE);
 延迟确认。
 
 # 消息持久化机制
 （保证消息可靠性）
 producer.setDeliveryMode(DeliveryMode.PERSISTENT);
 
 # 消息同步发送、异步发送
 同步发送、异步发送都是针对broker
 1、默认情况，非持久化消息是异步发送
 2、非持久化消息并且非事务模式，同步发送
 开启事务，都是异步发送
 
 消息发送过程：
 1.producer.send(),
 2.判断是否有空间（producerWindowSize），待确认消息大小（允许积压消息的大小）
 3.没有空间会block
 4.判断异步发送，
 5.异步发送会增加producerWindowSize空间，到transport，send到broker
 6.同步发送，-》transport -》broker
 
  <memoryUsage percentOfJvmHeap="70" />
      </memoryUsage>
          <storeUsage>
              <storeUsage limit="100 gb"/>
              <tempUsage limit="50 gb"/>
          </tempUsage>
      </systemUsage>
  </systemUsage>
  达到消息的memoryUsage内存限制，非持久化的消息，持久化存储到临时空间，之后会删除
 
 #持久化到哪里
 1、kahadb （默认机制）消息持久化解决机制
 <persistenceAdapter>
    <kahaDB directory="${activemq.data}/kahadb"/>
 </persistenceAdapter>
 
 kahadb文件
 db-1.log（递增方式消息内容）  db.data（索引 B-tree）  db.redo（消息恢复）  lock
 
 2.jdbc存储
 <persistenceAdapter>
    <jdbcPersistenceAdapter dataSource="#MySQL-DS" createTableOnStartup="true" >
 </persistenceAdapter>
 配置数据源，
 依赖jar包放到 activemq下的lib里面
 重新启动，创建3张表
 activemq-acks 确认
 activemq-msgs 消息类容，消费之后删除
 activemq-lock 竞争锁
 
 3.内存 
 配置<broker persisence="false" >
 
 4.LevelDB
 
 
 5.JDBC WITH ActiveMQ journal
 消息消费速度快，只会持久化没有消费完的，批量到数据库
 
 # 消费流程
 receive，messageListener
 同一个session，两者不能同时工作
 
 1.prefetchsize，unconsumermessage
 
 2.pull消息
 
 3.transport
 
 4.broker push 消息 通过transport到 unconsumermessage队列
 
 5.获取消息，添加到deliveredMessage队列