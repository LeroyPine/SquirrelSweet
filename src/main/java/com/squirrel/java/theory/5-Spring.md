### SpringBoot的启动过程？

- 首先会构建一个SpringApplication实例
- 然后会创建一个ApplicationContext,在创建ApplicationContext的过程中将一个ConfigurationClassPostProcessor的后置处理器注入到BeanFactory中
- 然后刷新线程上下文,在这过程中添加事件发布器以及事件监听者等,并通过刚刚的后置处理器将Bean都扫描出来并加入到BeanFactory中,
- 然后进行Bean的实例化
- 都完成之后,获取ApplicationRunner和CommandLineRunner的实现类,并执行相应逻辑。

### SpringBean的生命周期

- 实例化Bean
- 设置Bean的属性
- 设置BeanNameAware、BeanFactoryAware相关接口
- 调用Bean初始化完成之前的 BeanPostProcessor的方法
- 检查Bean是否实现了InitializingBean接口,如果实现了就调用了afterProperties方法
- 然后再检查Bean是否存在init-method方法
- 然后在调用Bean初始化之后的BeanPostProcessor
- 最终在看是否实现了销毁Bean的接口

### SpringIOC 循环依赖？

- Spring循环依赖通过三个缓存map来实现的。
- 一级缓存是存储的是一个完整的Bean。 singletonObjects
- 二级缓存存储的是一个提前暴露的Bean,Bean是不完整的,没有进行属性注入和执行init方法
- 三级缓存存储的是Bean工厂,主要是生产Bean,并存放到二级缓存中,为了解决代理的问题,如果不需要代理,该工厂直接返回原来的Bean,否则返回代理之后的Bean
- 创建一个Bean A,首先加入到三级缓存中,然后想要注入B,此时B还没有实例化,接着实例化B,实例化B的时候,又发现B需要A,从三级缓存中取出A,然后把A放入二级缓存,删除三级缓存的A,
  然后把A注入B,此时B实例化完成,然后A在进行实例化
- 因为循环依赖的话,如果有某个类有代理的话,我们需要把代理对象注入进去,所以就用了三级缓存。

### SpringAOP如何实现的？

- SpringAOP是在Bean创建的时候,判断当前Bean是否配置了切面,如果配置了就返回代理对象
- 默认是使用JDK代理,JDK代理的需要实现接口
- CGLIB是通过继承的方式,如果要被代理的类是final的就不能使用CGLIB了

### Spring中的设计模式有哪些？

- 模板模式:
  - 定义了一个操作中的行为,但是这些行为由子类去进行实现。
  - 例如Spring中的事务管理器的相关代码,存在一个抽象的事务管理器,然后 由 JDBC、RABBITMQ等实现对应的事务
    - startTrans
    - commit
    - rollBack
- 单例模式：
  - Spring中的Bean默认是单例的
- 工厂模式
  - 生产Bean
- 代理模式
  - AOP ---
- 观察者模式
  - 事件广播机制、

### Spring事务传播行为有哪些？

- 如果当前存在事务,就加入,不存在就新建一个事务。propagation_required
- 新建事务,如果当前存在事务,将当前事务挂起,独立提交事务,父级异常也不进行回滚 requires_new
- 当前存在事务,将会成为父级事务的一个子事务,方法结束后不会提交,父级事务结束后在进行提交,父级异常他会回滚 Nested
- support:如果当前存在就加入,没有以非事务方式运行
- Not_Support:以非事务方式进行
- MANDATORY： 如果当前存在事务，则运行在当前事务中，如果当前无事务，则抛出异常，也即父级方法必须有事务
- Never:非事务方式运行,如果存在事务就异常。

### Spring观察者模式

- Spring 通过 ApplicationEvent、ApplicationListener、ApplicationPublisher 完成的事件监听模式
- 发布容器事件,会根据事件和事件源类型在一个map中查找对应的监听器列表,然后遍历监听器列表执行事件,判断有没有异步。

- Spring容器启动的时候帮我们创建一个简单的事件发布器并交由容器管理。
- 然后将我们实现的监听者注入到事件发布器中。
- 发布事件的时候,通过事件的类型查询出泛型相匹配的监听者(还有他的父类),然后进行调用也就是我们自己实现的方法。

### Spring如何在运行时通知对象？

- 其实就是在调用目标方法的时候,前后会执行一些方法逻辑,Spring通过代理类封装了目标类,并拦截被通知的方法的调用,再将调用转发给真正的Bean
- 如果使用 ApplicationContext，在 ApplicationContext 从 BeanFactory 中加载所有 Bean 时，Spring 创建代理对象

### SpringMVC的执行流程？

- 客户端请求->DispatcherServlet
- DispatcherServlet收到请求后,调用HandlerMapping处理器映射器,请求获取handler
- 经过适配调用,具体处理器进行处理业务逻辑,然后返回ModelAndView
- 然后将ModelAndView返回给DispatchServlet
- 然后DispatcherServlet 将其传给 ViewResolver 视图解析器进行解析
- 解析后返回具体的View
- 然后对View进行渲染,然后返回给用户。