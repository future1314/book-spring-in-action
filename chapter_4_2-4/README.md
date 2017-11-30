本例展示了注解和XML配置AOP的两种方式：

`com.getset.bsia.aop.annotation`下的例子是注解方式
  * `Audience`是切面类，在`Performance.perform()`前后均定义了要织入的方法；
  * `Light`是引入的接口，通过在`StageLightOperator`中使用`@DeclareParents`注解实现，该注解由三部分构成：
    * value属性指定了哪种类型的bean要引入该接口。在本例中，也就是所有实现Performance的类型（标记符后面的加号表示是Performance的所有子类型，而不是Performance本身）。
    * defaultImpl属性指定了为引入功能提供实现的类。在这里，我们指定的是DefaultEncoreable提供实现。
    * @DeclareParents注解所标注的静态属性指明了要引入了接口。在这里，我们所引入的是Encoreable接口。
  * `AppConfig`是配置类，使用`@EnableAspectAutoProxy`开启注解驱动的切面。
  * `AspectAnnotationTest`是测试类。

`com.getset.bsia.aop.xml`下的例子是XML方式
  * 所有的类均去掉了注解，具体配置位于`app.xml`；
    * 配置方式跟注解方式基本类似，唯一有出入的地方在于传递参数时的切点配置，其中的`execution(***) && args(**)`中的`&&`改成`and`，因为XML中`&`会被解析为实体的开始。
  * `AspectXmlTest`是测试类。