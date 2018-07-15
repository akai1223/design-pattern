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
  在支持事务的session中，producer发送message时在message中带有transactionID。
  broker收到message后判断是否有transactionID，
  如果有就把message保存在transaction store中，等待commit或者rollback消息。
  
  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
  第一个参数:是否支持事务，如果为true，则会忽略第二个参数，
  自动被jms服务器设置为SESSION_TRANSACTED
 
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
 消息生产者使用持久（persistent）传递模式发送消息的时候，Producer.send() 方法会被阻塞，
 直到 broker 发送一个确认消息给生产者(ProducerAck)，
 这个确认消息暗示broker已经成功接收到消息并把消息保存到二级存储中。这个过程通常称为同步发送。
 
 如果应用程序能够容忍一些消息的丢失，那么可以使用异步发送。
 异步发送不会在受到 broker 的确认之前一直阻塞 Producer.send 方法。
 
 但有一个例外，当发送方法在一个事务上下文中时，被阻塞的是 commit 方法而不是 send 方法。
 commit 方法成功返回意味着所有的持久消息都以被写到二级存储中。
 
 if (onComplete==null 
  && sendTimeout <= 0 
  && !msg.isResponseRequired()
  && !connection.isAlwaysSyncSend() 
  && (!msg.isPersistent() || connection.isUseAsyncSend() || txid != null))
 
 想要使用异步，在brokerURL中增加 jms.alwaysSyncSend=false&jms.useAsyncSend=true
 如果设置了alwaysSyncSend=true系统将会忽略useAsyncSend设置的值都采用同步
 默认：(alwaysSyncSend=false,useAsyncSend=false)
 1、默认情况，非持久化、事务内的消息均采用异步发送，持久化消息，同步发送，开启事务，都是异步发送
 2、alwaysSyncSend=false，如果指定了useAsyncSend=true，异步发送
 
 
 在重试6次后，ActiveMQ认为这条消息是“有毒”的，将会把消息丢到死信队列里。
 如果你的消息不见了，去ActiveMQ.DLQ里找找，说不定就躺在那里。
 
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
 就是在发送者将消息发送出去后，消息中心首先将消息存储到本地数据文件、内存数据库或者远程数据库等，
 然后试图将消息发送给接收者，发送成功则将消息从存储中删除，失败则继续尝试。
 消息中心启动以后首先要检查指定的存储位置，如果有未发送成功的消息，则需要把消息发送出去。
 
 1、kahadb （默认机制）消息持久化解决机制
 <persistenceAdapter>
    <kahaDB directory="${activemq.data}/kahadb"/>
 </persistenceAdapter>
 
 kahadb文件
 db-1.log（递增方式消息内容）  db.data（索引 B-tree）  db.redo（消息恢复）  lock
 
 2.jdbc存储
 <beans> 
     <broker brokerName="test-broker" persistent="true" xmlns="http://activemq.apache.org/schema/core"> 
         <persistenceAdapter> 
             <jdbcPersistenceAdapter dataSource="#mysql-ds" createTablesOnStartup="false"/> 
         </persistenceAdapter> 
     </broker> 
     <bean id="mysql-ds" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close"> 
         <property name="driverClassName" value="com.mysql.jdbc.Driver"/> 
         <property name="url" value="jdbc:mysql://localhost/activemq?relaxAutoCommit=true"/> 
         <property name="username" value="activemq"/> 
         <property name="password" value="activemq"/> 
         <property name="maxActive" value="200"/> 
         <property name="poolPreparedStatements" value="true"/> 
     </bean> 
 </beans> 
 dataSource指定持久化数据库的bean，createTablesOnStartup是否在启动的时候创建数据表，
 默认值是true，这样每次启动都会去创建数据表了，一般是第一次启动的时候设置为true，之后改成false。
 
 配置数据源，
 依赖jar包放到 activemq下的lib里面
 重新启动，创建3张表
 activemq-acks 用于存储订阅关系。如果是持久化Topic，订阅者和服务器的订阅关系在这个表保存
 activemq-msgs 消息类容，消费之后删除，用于存储消息，Queue和Topic都存储在这个表中
 activemq-lock 竞争锁
 在集群环境中才有用，只有一个Broker可以获得消息，称为Master Broker，
 其他的只能作为备份等待Master Broker不可用，才可能成为下一个Master Broker。
 这个表用于记录哪个Broker是当前的Master Broker。
 
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