### SpringBoot的启动过程？

- 首先会构建一个SpringApplication实例
- 然后会创建一个ApplicationContext,在创建ApplicationContext的过程中将一个ConfigurationClassPostProcessor的后置处理器注入到BeanFactory中
- 然后刷新线程上下文,通过刚刚的后置处理器将Bean都扫描出来并加入到BeanFactory中
- 然后进行Bean的实例化
- 都完成之后,获取ApplicationRunner和CommandLineRunner的实现类,并执行

### SpringBean的生命周期

- 实例化Bean
- 设置Bean的属性
- 设置BeanNameAware
- 调用BeanPostProcessor-Bean初始化完成之前的
- 检查Bean是否实现了InitializingBean接口
- 然后再检查是否存在init-method方法
- 然后在调用BeanPostProcessor-Bean初始化之后的
- 最终在看是否实现了销毁Bean的接口

### SpringIOC 循环依赖？

- Spring循环依赖通过三个缓存map来实现的。
- 一级缓存是存储的是一个完整的Bean。 singletonObjects
- 二级缓存存储的是一个提前暴露的Bean,Bean是不完整的,没有进行属性注入和执行init方法
- 三级缓存存储的是Bean工厂,主要是生产Bean,并存放到二级缓存中,为了解决代理的问题,如果不需要代理,该工厂直接返回原来的Bean,否则返回代理之后的Bean
- 创建一个Bean A,首先加入到三级缓存中,然后想要注入B,此时B还没有实例化,接着实例化B,实例化B的时候,又发先B需要A,从三级缓存中取出A,然后把A放入二级缓存,删除三级缓存的A,
  然后把A注入B,此时B实例化完成,然后A在进行实例化

### SpringAOP如何实现的？

- SpringAOP是在Bean创建的时候,判断当前Bean是否配置了切面,如果配置了就返回代理对象
- 默认是使用JDK代理,JDK代理的需要实现接口
- CGLIB是通过继承的方式,如果要被代理的类是final的就不能使用CGLIB了

### Spring中的设计模式有哪些？

- 模板模式
- 单例模式
- 工厂模式
- 代理模式
- 观察者模式

### Spring事务传播行为有哪些？

- 如果当前存在事务,就加入,不存在就新建一个事务。propagation_required
- 新建事务,如果当前存在事务,将当前事务挂起,独立提交事务,父级异常也不进行回滚 requires_new
- 当前存在事务,将会成为父级事务的一个子事务,方法结束后不会提交,父级事务结束后在进行提交,父级异常他会回滚 Nested
- support:如果当前存在就加入,没有以非事务方式运行
- Not_Support:以非事务方式进行
- MANDATORY： 如果当前存在事务，则运行在当前事务中，如果当前无事务，则抛出异常，也即父级方法必须有事务
- Never:非事务方式运行,如果存在事务就异常。

### Spring如何在运行时通知对象？

- AOP代理

### SpringMVC的执行流程？

- 客户端请求->DispatcherServlet
- DispatcherServlet收到请求后,调用HandlerMapping处理器映射器,请求获取handler
- 经过适配调用,具体处理器进行处理业务逻辑,然后返回ModelAndView
- 然后将ModelAndView返回给DispatchServlet
- 然后DispatcherServlet 将其传给 ViewResolver 视图解析器进行解析
- 解析后返回具体的View
- 然后对View进行渲染,然后返回给用户。