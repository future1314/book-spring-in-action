《Spring实战》笔记。

## 第一章 Spring之旅
### 1.1 简化Java开发

为了降低Java开发的复杂性，Spring采取了一下4中关键策略：

  * 基于POJO的轻量级和最小侵入性编程；
  * 基于依赖注入和面向接口实现松耦合；
  * 基于切面和惯例实现声明式编程；
  * 通过切面和模板减少样板式代码。

### 1.2 容纳你的Bean
#### 1.2.1 应用上下文（ApplicationContext）

可能遇到的有：

  * AnnotationConfigApplicationContext： 从一个或多个基于Java的配置类中加载Spring应用上下文。
  * AnnotationConfigWebApplicationContext： 从一个或多个基于Java的配置类中加载Spring Web应用上下文。
  * ClassPathXmlApplicationContext： 从类路径下的一个或多个XML配置文件中加载上下文定义， 把应用上下文的定义文件作为类资源。
  * FileSystemXmlapplicationcontext： 从文件系统下的一个或多个XML配置文件中加载上下文定义。
  * XmlWebApplicationContext： 从Web应用下的一个或多个XML配置文件中加载上下文定义。

#### 1.2.2 bean的生命周期

bean的生命周期如下：

![bean的生命周期](docs/images/bean-lifecycle.png)

1. Spring对bean进行实例化；
2. Spring将值和bean的引用注入到bean对应的属性中；
3. 如果bean实现了BeanNameAware接口， Spring将bean的ID传递给setBean-Name()方法；
4. 如果bean实现了BeanFactoryAware接口， Spring将调用setBeanFactory()方法， 将BeanFactory容器实例传入；
5. 如果bean实现了ApplicationContextAware接口， Spring将调用setApplicationContext()方法， 将bean所在的应用上下文的引用传入进来；
6. 如果bean实现了BeanPostProcessor接口， Spring将调用它们的postProcessBeforeInitialization()方法；
7. 如果bean实现了InitializingBean接口， Spring将调用它们的after-PropertiesSet()方法。 类似地， 如果bean使用init-method声明了初始化方法， 该方法也会被调用；
8． 如果bean实现了BeanPostProcessor接口， Spring将调用它们的postProcessAfterInitialization()方法；
9． 此时， bean已经准备就绪， 可以被应用程序使用了， 它们将一直驻留在应用上下文中，直到该应用上下文被销毁；
10． 如果bean实现了DisposableBean接口， Spring将调用它的destroy()接口方法。 同样， 如果bean使用destroy-method声明了销毁方法， 该方法也会被调用。

### 1.3 俯瞰Spring风景线
#### 1.3.1 Spring-framework模块

![Spring的模块](docs/images/spring-modules.png)

#### 1.3.2 Spring Portfolio

本书会介绍到的除了Spring Framework外，还有Spring Web Flow、Spring Security、Spring Data、Spring Boot。

### 1.4 Spring的新特性
略

## 第二章 装配Bean
### 2.1 Spring配置的可选方案

尽可能地使用自动配置的机制。 显式配置越少越好。 当你必须要显式配置bean的时候（ 比如， 有些源码不是由你来维护的， 而当你需要为这些代码配置bean的时候） ， 我推荐使用类型安全并且比XML更加强大的JavaConfig。 最后， 只有当你想要使用便利的XML命名空间， 并且在JavaConfig中没有同样的实现时， 才应该使用XML。

### 2.2 自动化装配bean

Spring从两个角度来实现自动化装配：
  * 组件扫描（component scanning）： Spring会自动发现应用上下文中所创建的bean。
  * 自动装配（autowiring）： Spring自动满足bean之间的依赖。

具体示例，请见[chapter_2_2](chapter_2_2)

### 2.3 通过Java代码装配bean

有些时候无法完全做到自动化装配，比如要将第三方的库装配到自己的应用的时候。这时候需要用到显示装配。

JavaConfig的方式相对XML来说更加推荐，因为它类型安全、对重构友好。

具体示例，请见[chapter_2_3](chapter_2_3)

### 2.4 通过XML装配bean

使用XML来装配bean的方式相对比较“古老”，新的项目中不建议使用。

具体示例，请见[chapter_2_4](chapter_2_4)

### 2.5 多种配置方式混合

Spring允许自动化装配、JavaConfig、XML配置多种配置方式混合使用，并提供了import机制。

具体示例，请见[chapter_2_5](chapter_2_5)

