# dubbo-demo
## Dubbo是什么
dubbo是一个分布式服务框架，致力于提供高性能和透明化的RPC远程服务调用方案，以及SOA服务治理方案。

简单的说dubbo就是个服务框架，如果没有分布式的需求，其实是不需要用的，只有在分布式的时候，才有dubbo这样的分布式服务框架的需求，并且本质上就是个服务调用的，远程服务调用的分布式框架（告别webservice模式中的wsdl，以服务者与消费者的方式在dubbo上注册）

其核心部分包含：

- 1.远程通讯：提供对多种基于长连接的NIO框架抽象封装，包括多种线程模型，序列化，以及“请求-响应”模式的信息交换方式。
- 2.集群容错：提供基于接口方法的透明远程过程调用，包括多协议支持，以及软负载均衡，失败容错，地址路由，动态配置等集群支持。
- 3.自动发现：基于注册中心目录服务，使服务消费方能动态地查找服务提供方，使地址透明，使服务提供方可以平滑增加或减少机器。

## Dubbo能做什么
- 1.透明化的远程方法调用，就像调用本地方法一样调用远程方法，只需要简单配置，没有任何API侵入。
- 2.软负载均衡及容错机制，可在内网替代F5等硬件负载均衡器，降低成本，减少单点
- 3.服务自动注册与发现，不再需要写死服务提供方地址，注册中心基于接口名查询服务提供者的IP地址，并且能够平滑添加或删除服务提供者。

Dubbo采用全spring配置方式，透明化接入应用，对应用没有任何API侵入，只需要spring加载dubbo的配置即可，dubbo基于spring的schema扩展进行加载。如果不想使用spring配置，而希望通过API的方式进行调用。（不推荐）；

## Dubbo的使用方法

启动注册中心服务，zookeeper，需要把zoo_sample.cfg复制一份为zoo.cfg，并配置相关信息

采用spring配置方式：

服务提供方：
- 1.定义服务接口：（该接口需要单独打包，在服务提供方和消费方共享）
- 2.在服务提供方实现接口：（对服务消费方隐藏实现）
dubbo中的实体类必须实现Serializable接口
- 3.用spring配置声明暴露服务：
- 4.加载spring配置，启动服务：1.API加载，2.注解加载

服务消费者：
- 1.通过spring配置引用远程服务
- 2.加载spring配置，并调用远程服务
