本例介绍了值注入的方法：
  * 使用properties文件注入值
    * 对于JavaConfig方式来说，可以在配置类上增加`@PropertiesSource`注解指定properties文件，然后使用Autowire的`Environment`实例的`getProperty()`方法获取属性值，该方法可指定默认值，以及转换值类型，示例见`AppConfig`；
    * 对于自动装配的方式来说，可以在`Component`类的构造方法上使用`@Value`注解注入，使用了解析占位符，见`BlankDisk3`；
    * 对于XML的方式来说，也可以使用解析占位符来注入属性值，见`app.xml`，注意使用`<context:property-placeholder>`来指定properties文件位置。
    * 具体的测试分别见`AppTest`、`AutoTest`和`XmlTest`。

  * 使用SpEL表达式注入值：
    * 字面值
      * `#{3.14}`、`#{12E3}`、`#{'hello'}`、`#{false}`
    * 引用bean、属性和方法
      * `#{beanID}`
      * `#{beanID.property}`
      * `#{beanID.method()}`
      * `#{beanID.method()?.anothorMethod()}`，`?.`可确保对非null对象执行方法
    * 使用类型
      * `#{T(java.lang.Math).PI}`
      * `#{T(System).currentTimeMillis()}`
    * SpEL运算符
      * 算术运算（+、-、x、/、%、^）：如`#{2 * T(Math).PI * circle.radius}`、`#{disc.title + 'by' + disc.artist}`
      * 比较运算（>、<、>=、<=、==、gt、lt、ge、le、eq）：如`#{counter.total == 100}`
      * 逻辑运算（and、or、not、|）
      * 条件运算（?:）：如`#{scoreBoard.score >= 100 ? 'winner': 'loser'}`
      * 正则运算（matches）：如`#{admin.email matches '[a-zA-Z._]+@[a-zA-Z]+\\.com'}`
    * 计算集合
      * `#{class2.students[2].name}`
      * `#{'This is a test'[3]}`，表示字符串的第3个字符，也就是`s`
      * `#{class2.students.?[age > 12]}`，`.?[]`可以进行过滤，如找到所有年龄大于12的学生（students），此外`.^[]`和`.$[]`用于查找第一个或最后一个符合条件的目标
      * `#{class2.students.?[age > 12].![name]}`，`![]`是投影运算符，如将所有年龄大于12的学生的姓名（name）投影到新的集合中