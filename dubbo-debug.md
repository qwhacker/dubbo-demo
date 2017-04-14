# dubbo服务调试
在开发dubbo服务时，可能是多个人同时开发，但是都公用一个zookeeper注册中心，这时就出现同一个服务会有多个提供者，这样调用的时候不一定是本机的提供者服务，就无法进行断点调试，为了能够调用自己的本机消费者服务，需要两步：

一、本机提供者服务不向zookeeper注册服务

```
!-- 使用zookeeper注册中心暴露服务地址 -->
<dubbo:registry protocol="zookeeper" address="${dubbo.registry.address}" register="false"/>
```

二、在消费者服务指定调用本地服务（直连调试）

```
<dubbo:reference interface="cn.com.open.openpaas.examinationservice.rpc.stub.IBatchService" id="batchService" timeout="6000000" url="dubbo://localhost:2088"/>
```

可以本地安装一个zookeeper，配置好端口号，在provider和consumer的配置文件中把zookeeper和dubbo配置成本地的
