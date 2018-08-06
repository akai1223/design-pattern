## redis cache

#### 存储结构
1. 字符类型
2. 散列类型
3. 列表类型
4. 集合类型
5. 有序集合

#### 功能
1. 可以为每个key设置超时时间
2. 可以通过列表类型来实现分布式队列的操作
3. 支持发布订阅的消息模式

#### redis 应用场景
1. 数据缓存（商品数据、新闻、热点数据）
2. 单点登录
3. 秒杀、抢购
4. 网站访问排名
5. 应用模块开发
6. 分布式锁

#### 安装
* `make`命令编译安装
* `make install PREFIX=/path` path路径
* `cp redis.conf ../redis/redis.conf`拷贝一个配置文件到redis目录

#### redis 命令说明

* 启动停止redis
```linux command
./redis-server ../redis.conf
./redis-cli shutdown
```
* 后台启动修改配置文件redis.conf中的`daemonize no` 改成 `daemonize yes`

* redis-server 启动服务
* redis-chi 访问到redis控制台
* redis-benchmark 性能测试工具
* redis-check-aof aof文件进行检查的工具
* redis-check-dump rdb文件检查工具
* redis-sentinel sentinel服务器配置
* 连接远程redis`./redis-cli -h 127.0.0.1 -p 6379`


#### 多数据支持
* 默认支持16个数据库，可以理解为一个命名空间，每个数据库可以设置相同的key不会覆盖
* 跟关系型数据库不一样的点
  1. redis不支持自定义数据库名
  2. 每个数据库不能单独设置授权
  3. 每个数据库之前不是完全隔离，可以通过flushall命令清空redis实例里面的所有数据库中的数据。
  4. 通过select dbid去选择不同的数据库命名空间，dbid的取值范围默认是0~15
  ```command
  select dbid
  ```
 #### 数据操作
 ##### 字符类型
 * `set key value`
 * `get key`
 * `append key value` 追加字符
 * `mget key key ...` 获得多个key对应的值
 * `mset key value key value ...` 批量设置
 * `strlen key` 获得key对应的值的字符长度 
 * `setnx`
 > * `incr key` 原子递增
 > * `decr key` 原子递减
 ##### 列表类型
 * `lpush/rpush`:从左边或者右边push数据
   > `lpush/rpush key value value ...`
 * `lpop/rpop` 移除数据返回移除的值  
 * 可以实现分布式队列
 * `llen num` 获得列表的长度
 * `lrange key start stop` 获取列表索引范围的数据，索引可以是负数，-1表示最右边的第一个元素
 * `lrem num 1 16` 删除列表num中的1个元素16
 * `lset num 2 99` 设置列表num中索引2的值99
 
##### 散列类型
* `hset key field value`
* `hget key field`
* `hmset key field value field value` 一次设置多个值
* `hmget key field field ...` 一次获取多个值
* `hgetall key` 获取hash所有数据
* `hexists key field` 是否存在，存在返回1，不存在返回0
* `hincryby`
* `hsetnx`
* `hdel key field field ...` 删除多个值
##### 集合类型
> set 和 hash 不同的是不能存在重复的数据，而且是无序的
* `sadd key member member ...` 增加数据，如果重复，则忽略存在的值，返回成功加入的元素的数量
* `srem key member` 删除元素
* `smembers key` 获得所有数据
* `sdiff key  key ...` 取集合的差集
* `sunion key key` 对多个集合执行并集操作，同时存在两个集合里的所有值
##### 有序集合
* `zadd key score member` score 决定顺序
* `zrange key start stop [withscores]` 去获得元素，withscores是可以获得的元素的分数
* 如果两个元素的score相同，那么根据（0 < 9 < A < Z < a < z）方式从小到大
##### redis 事务
```cfml
multi
...
exec
```
* 可能出现不能回滚的情况，执行中报错
##### 过期时间
* `expire key seconds` 设置过期时间
* `ttl key` 获得过期时间

##### 外网访问
* 默认不能被外网访问 修改配置 `bind 127.0.0.1` 
* `protected yes` 修改为 `protected no`

##### 发布订阅
```cfml
publish channel message
subscribe channel [...]
```
##### redis 实现分布式锁
* 实现方式
  * 数据库可以做
  * 缓存redis setnx
  * zookeeper 创建临时节点，成功获得锁

* `setnx`