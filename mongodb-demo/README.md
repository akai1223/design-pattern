### 安装
解压文件

### 命令启动
`./mongod --dbpath=/home/zhangkai/dev/monogodb/data/ --port=27017 --fork`

选项`--fork` 后台启动

### 配置文件启动
```properties
sudo vi mongodb.conf
```
```properties
dbpath=/home/zhangkai/dev/mongodb/data/ #数据文件存放目录
logpath=/home/zhangkai/dev/mongodb/log/mongodb.log #日志文件存放目录
logappend=true
port=27017  #默认端口27017
fork=true  #以守护程序的方式启用，即在后台运行
nohttpinterface = true
bind_ip=0.0.0.0
```
yaml文件配置
```yaml
systemLog:
  destination: file
  path: "/home/zhangkai/dev/mongodb/log/mongodb.log"
  logAppend: true
storage:
  dbPath: "/home/zhangkai/dev/mongodb/data/"
  journal:
    enabled: true
processManagement:
  fork: true
net:
  bindIp: 127.0.0.1
  port: 27017
setParameter:
  enableLocalhostAuthBypass: false
...
```

```properties
./mongod -f mongodb.conf
```

**bind_ip=0.0.0.0** 
> bind_ip标识允许连接的客户端IP地址，此处设为0.0.0.0，表示允许所有机器连接。也可设置特定机器的IP。

### 关闭
```properties
use admin
db.runCommand("shutdown")
```

```properties
sudo ./mongod --shutdown -f mongodb.conf
```
