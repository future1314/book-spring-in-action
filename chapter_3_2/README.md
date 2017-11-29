本例演示了条件注解`@Conditional`以及`@Qualifier`限定符的使用。

条件注解`@Conditional`中比较给出实现了`Condition`的类作为参数，后者需要实现`matches()`方法，并根据该方法的返回结果判断是否装配该bean。
  * `matches()`方法会传进来两个参数，`ConditionContext`可以获得：
    * 借助getRegistry()返回的BeanDefinitionRegistry检查bean定义；
    * 借助getBeanFactory()返回的ConfigurableListableBeanFactory检查bean是否存在， 甚至探查bean的属性；
    * 借助getEnvironment()返回的Environment检查环境变量是否存在以及它的值是什么；
    * 读取并探查getResourceLoader()返回的ResourceLoader所加载的资源；
    * 借助getClassLoader()返回的ClassLoader加载并检查类是否存在。
  * `AnnotatedTypeMetadata`则能够让我们检查带有@Bean注解的方法上还有什么其他的注解。

限定符注解`@Qualifier`通过给出确定的bean名称，避免存在多个可类型匹配的bean在装配时出现异常。
  * 默认bean名称为`@Bean`处定义的方法名，限定符可在`@bean`处和`@Autowire`处同时定义，成组出现进行自定义匹配。