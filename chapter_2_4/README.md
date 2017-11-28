本例介绍了基本的`<bean>`配置，详见`test/resources/xmls/soundsystem.xml`。
测试类仍然是`CDPlayerTest`，可以调整xml配置文件中的注释感受一下。

在XML的配置中，`<bean>`元素类似于`@Bean`注解，用于声明一个bean。具体来说：
  * 若不指定`id`，则默认使用类的权限定类名（包路径+类名那种）后跟一个`#n`来作为ID，n从0开始自增，比如“com.getset.bsia.CDPlayer#0”；
  * 借助构造器注入初始化bean有两种方式：
    * 一种是使用`<constructor-arg>元素；
    * 一种是使用Spring3.0引入的`c`命名空间，`c`命名空间可以用参数名或参数index给参数注入值；但是这种方式不能用于装配集合（如`<list>`）；
  * 为bean设置属性有两种方式：
    * 一种是使用`<property>`，实际上是由Spring调用setter来实现的；
    * 一种是使用Spring3.0引入的`p`命名空间，这种方式同样不能用于装配集合。
