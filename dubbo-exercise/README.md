# dubbo

## 1 dubbo 版本支持
* producer 提供服务端 配置version
``` 
 <dubbo:service interface="com.zek.dubbo.api.IHelloDubbo" ref="iHelloDubboImpl" version="1.0.1"/>
 <dubbo:service interface="com.zek.dubbo.api.IHelloDubbo" ref="iHelloDubboImpl2" version="1.0.2"/>

 <bean id="iHelloDubboImpl" class="com.zek.dubbo.server.IHelloDubboImpl"/>
 <bean id="iHelloDubboImpl2" class="com.zek.dubbo.server.IHelloDubboImpl2"/>
```

* consumer 客户端配置version
```
 <dubbo:reference id="iHelloDubbo" interface="com.zek.dubbo.api.IHelloDubbo" version="1.0.2"/>
```
* zookeeper上的注册的发布服务信息
```
ls /dubbo/com.zek.dubbo.api.IHelloDubbo/providers
[
 dubbo%3A%2F%2F192.168.43.1%3A20880%2Fcom.zek.dubbo.api.IHelloDubbo2%3Fanyhost%3Dtrue%26application%3Ddubbo-server%26dubbo%3D2.6.2%26generic%3Dfalse%26interface%3Dcom.zek.dubbo.api.IHelloDubbo%26methods%3DsayHello%26owner%3Dzek%26pid%3D5700%26revision%3D1.0.2%26side%3Dprovider%26timestamp%3D1531747867474%26version%3D1.0.2,
 dubbo%3A%2F%2F192.168.43.1%3A20880%2Fcom.zek.dubbo.api.IHelloDubbo%3Fanyhost%3Dtrue%26application%3Ddubbo-server%26dubbo%3D2.6.2%26generic%3Dfalse%26interface%3Dcom.zek.dubbo.api.IHelloDubbo%26methods%3DsayHello%26owner%3Dzek%26pid%3D5700%26revision%3D1.0.1%26side%3Dprovider%26timestamp%3D1531747866442%26version%3D1.0.1
]
```

## 2 主机绑定

 > 配置文件获取，本地网卡 等
 
 * dubbo 20880
 * rmi 1099
 * http 80
 * hessian 80
 * webservice 80

## 3 集群容错
 * failsafe 失败安全，可以认为把错误吞掉，记录日志
 * failover(默认)重试其他服务器，retries（2） 2次重试，不包含第一次
 * failfast 快速失败，失败以后立刻报错
 * failback 失败后自动恢复
 * forking forks：设置并行数目
 * broadcast 广播，任意一台报错，则执行方法报错
 ```
<dubbo:reference id="iHelloDubbo" interface="com.zek.dubbo.api.IHelloDubbo" version="1.0.2" cluster="failsafe" timeout="50"/>
```
 > 配置cluster
    
 ## 4 服务降级
 > 降级的目的是为了保证核心服务可用
  * 故障降级(兜底数据)、限流降级，流程降级(去掉无关流程)
  * mock (实现要降级的接口),在客户端配置mock
  ```
<dubbo:reference id="iHelloDubbo" interface="com.zek.dubbo.api.IHelloDubbo" version="1.0.1" cluster="broadcast" timeout="1"
    mock="com.zek.dubbo.client.TestMock"/>
 ```
 > `cluster=failsafe` 不报错，不能进去mock
 
 ## 5 配置优先级
 * 配置优先级别
  > 客户端配置优先服务器
  1. 方法级别优先，然后是接口，最后是全局配置
  2. 如果级别是一样的，客户端优先
     > retires、 LoadBanlance、 cluster(客户端)、 timeout(服务端)
     
 ## 6 DUBBO SPI 扩展
 * JAVA SPI
 1. META-INF/services/接口全路径文件
    > 里面写实现类全类名
    
 * dubbo的SPI规范
     1. META-INF/dubbo/; META-INF/intelnal; META-INF/services
     2. 文件（接口全路径），key value