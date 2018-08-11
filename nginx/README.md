#### nginx

* 负载均衡服务器
> lvs/apache/nginx/HAproxy

* 热备
> 2台nginx服务器，使用一台，挂掉，切换到另外一台

1. rewrite的使用
  * 支持URL重写，if判断，return
  * 只能用在server/location/if中；只能对域名后面的除去参数外的字符串起作用
  * if(条件){} =号或者~ ；
  * return指令
  `return code`
  ```
  if($reuqest_uri ~ *\.sh){
    return 403
  }
  ```