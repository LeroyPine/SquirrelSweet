### Kafka

Kafka是一个开源的、分布式的、基于日志提交的发布订阅消息系统

Kafka各组件说明：

**Broker:** 

​	每个kafka server 称之为一个 Broker,多个broker 构成了 kafka cluster. 一个机器上可以部署一个或者多个Broker。

**Topic:**

​	Topic是一个**消息类**别名,一个topic通常放置一类消息。 每个topic 都有一个或者多个消费者  ｜ consumer

​    Producer 将消息推送到topic,由订阅topic 的consumer 拉取消息

**Topic 和 Broker 的联系:**

​	一个Broker上可以创建一个或者多个Topic, 同一个Topic可以在同一集群下的的多个Broker分布

**Partition log:**

kafka会为每个topic维护了多个分区（partition），每个分区会映射到一个逻辑日志 log 文件

1.每当一个message被发送到一个topic的一个 partition，broker 会将该message 追加到log文件的最后和一个segment上，这些segment会定期刷新到磁盘上，可以按照时间 也可以按照 message 数量。

2.每个partition都是一个有序的、不可变的结构化提交日志记录的序列。在每个partition中的每条日志都会被分配一个唯一序号 offset，offset在 partition 是唯一的

3.Broker集群将会保留已发布的message records ，不管这些消息是否已经被消费。保留时间依赖于一个可配的保留周期。

**Partition distribution:**

日志分区是分布式的存在于kafka集群的多个broker上。每个partition会被复制多份存在于不同的broker上,这样做是为了容灾。

**Producer**

producer作为消息的生产者,在生产完消息之后需要将消息投递到某个 partition 中, 可以根据指定选择的partition算法或者随机算法投递到指定的partition中。

**Consumer**

consumer group, 它是逻辑上讲一些consumer进行分组, 因为每个kafka consumer 是一个进程,consumers可能是在不同机器上的进程组成的。topic 中的消息可以被多个 consumer group 消费,但是每个consumer group中只能有一个consumer来消费该消息。每个consumer 可以订阅多个topic ｜ 每个consumer会保留它读取到某个partition 的offset。 而consumer是通过zookeeper来保留offset的。

**生产者与分区（多对多）分区策略:**

- 如果生产这指定了分区,那么消息将会投递到该分区中
- 如果没有指定分区,但是消息的key不为空,那么会根据key的hash 选择一个分区
- 如果没有指定分区,也没有消息的key,那么按照轮询的方式发送消息

**分区与消费者（多对一）**	

- 同一时刻,一条消息只能被组中的一个消费者实例消费
- 消费者订阅同一个主题，意味着主题下的所有分区都会被组中的消费者消费到，并且主题下每个分区只从属于组中的一个消费者,一定  **不可能存在一个组中 多个消费者消费同一个分区的消息。**
- 资源浪费:
  - 如果consumer的数量大于分区数量,那么会造成浪费,会有几个消费者永远处于空闲状态
  - 如果consumer的数量小于分区数量,那么会造成资源紧张,会有某个消费者消费多个分区的情况。

为什么每一个消费者可以消费多个分区,但是一个分区不能被多个消费者消费呢？

为了保证一个分区下的消息顺序性,如果两个消费者负责同一个分区, 由于消费者可以控制自己的offset，有可能 C1读到2，C1读到1，C1还没处理完，C1已经读到3了。

**所以说消息积压的时候，部署多台消费者实例是不能加快消费原有分区的消息的**,最多消费者增加到partition数量一样

**消费者**

 **分组**

      - 消费者从partition中获取数据, consumer 有group的概念,每个group可以消费完整的一份topic中的数据

 **消费者分区分配策略**

- range 策略。（默认的分配策略，基于主题的）
  - 将分区数字顺序进行排序，将消费者实例按照字典进行排序
  - 用分区总数除以消费者实例总数,如果能除开就平均分配,否则给前面的消费者多分配一个分区

**分区Rebalance（再均衡）场景**

- 有新的消费者加入消费者群组
- 已有的消费者推出消费者群组
- 订阅的主题分区发生变化

在Rebalance期间,整个消费组是不可以读取消息的,当分区重新分配给另一个消费者的时候,消费者当前的读取状态会丢失

如果要实现广播模式的话,必须要有多个消费组.







