# SpringMVC项目搭建
1.根据“SpringMVC请求处理流程”，请求第一站是到`DispatcherServlet`，通常它是配置在web项目的`web.xml`中，servlet3之后，可以用JavaConfig的形式配置，搞一个扩展了`AbstractAnnotationConfigDispatcherServletInitializer`的类即可，这个类会被自动发现。

> * 本例中，是`SpittrWebAppInitializer`；
> * servlet 3.0的环境中，容器会在类路径中查找实现`javax.servlet.ServletContainerInitializer`接口的类，用来配置Servlet容器。Spring框架提供了这个接口的实现`SpringServletContainerInitializer`，这个类会去查找实现了`WebApplicationInitializer`的类，而`AbstractAnnotationConfigDispatcherServletInitializer`就是它的一个实现。
> * 在我们自己扩展的Initializer中，要指定`RootConfig`、`ServletConfig`和`ServletMapping`。其中，
>   * `ServletMapping`定义了`DispatcherServlet`接管的url pattern，"/"表示所有请求均接管；
>   * 另外两个Config是两个`@Configuration`注解的配置类，配置类中定义了web应用中的bean，如何区分呢？spring的ApplicationContext提供加载多层上下文的能力，允许每个上下文只关注特定层，例如一个应用的web层或者中间层服务.其中一个经典的是使用分层ApplicationContext的例子就是，当我们有多个DispatchServlet在一个应用和我们想要共享其中的普通bean例如datasource。这时候我们可以定义一个根上下文即root ApplicationContext，这个根上下文包含了普通的bean和从根上下文继承了普通bean的多个WebApplicationContext。 在web mvc框架中，每个DispatchServlet都有自己独自的WebApplicationContext，这个WebApplicationContexti继承了所有已经在 root WebApplicationContext定义了的bean。这些被继承的bean可以被特定的复写，而且对于一个给定的servlet实例你能够在本地定义新的指定范围的bean。如下图：
>   
>   ![](images/context-hierarchy.png)

2.在`ServletConfig`（本例中是`WebConfig`）中使用`@EnableWebMVC`启用SpringMVC，类似于XML配置方式的`<mvn:annotation-driven/>`，从而自动装配注解的bean。

3.在`ServletConfig`（本例中是`WebConfig`）中配置视图解析器、静态资源的处理。

4.编写`Controller`：
  * 使用`@RequestMapping`定义url处理映射，可限制要处理的Http method（GET、POST等）；
  * 如果响应中需要反馈数据，可以在处理方法上增加`Model`参数，这个`Model`实际上就是一个`Map`（key-value组合），因此也可以用`Map`类型的变量作为参数；
    * 使用`addAttribute`方法增加反馈数据信息，如果不指定key，Spring会自行推断，比如`List<Spittle>`，会推断为`spittleList`，不过最好明确指定；
  * Controller handler 处理方法通常返回类型是String，这个String会被视图解析器解析为具体的视图（如JSP）；如果返回类型不是String，那么return的内容会作为`Model`返回，自行推断key和视图名称（取自`RequestMapping`指定的路径的去掉"/"的字符串）；
  * Controller可以接收来自请求中的输入：
    * Query Parameter： 处理形如`user?username=zhangsan&password=123456`这样的请求，在处理方法的参数列表中将查询参数名称用`@RequestParam`进行注解；
    * Path Parameter： 处理形如`user/1`这样的请求，其中`1`是一个位于路径中的变量，通常RESTful风格的URL这么表示，在控制器中，路径变量用占位符`user/{id}`表示，然后在方法参数列表中用`@PathVariable`进行注解；
    * Form Parameter： 使用`POST`方法，表单数据通过Entity的对象作为参数传入，无需相关注解。若要对表单进行校验：
      * 在被校验的Entity的具体属性上通过注解（如`@notNull`、`@Size`、`@Pattern`等）进行约束；
      * 对于控制器中具体的处理方法，用`@Valid`注解标注该Entity参数，后跟`Errors`参数，并在方法中判断`Errors`对象是否`hasErrors`。

具体见代码。