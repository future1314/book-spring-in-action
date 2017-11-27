# 《Spring实战》笔记

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