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

### SpringAOP如何实现的？

### Spring中的设计模式有哪些？

### Spring事务传播行为有哪些？

### Spring如何在运行时通知对象？

### SpringMVC的执行流程？