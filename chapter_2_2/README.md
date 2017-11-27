本示例中，`CDPlayerConfig`为配置类，采用了`@ComponentScan`注解，这一注解有几点：
  * 默认扫描配置类所在的包及其子包内；
  * 可以通过`@ComponentScan(basePackages)`参数指定具体扫描包，通常用于配置类位于单独的package下时；
  * 为了类型安全，可以使用`@ComponentScan(basePackageClasses)`参数制定要扫描的包及其子包内的一个类，这个类可以是专门用来标记扫描范围的类。

`SgtPappers`类通过注解`@Component`标记为bean，则Spring会负责实例化改bean。`@Component`可以用`@Named`注解替换。

对于存在依赖关系的类，比如`CDPlayer`需要`CompactDisk`才能播放音乐，那么可以通过`@Autowire`注解配置依赖或注入，这一注解有几点：
  * 该注解可配置于构造方法或setter上；事实上，`@Autowire`可用于任何方法上，它会贴心的为所注解方法的传入参数匹配合适的实例；
  * 该注解可以用`@Inject`注解替换。
  
测试情况见`CDPlayerTest`。