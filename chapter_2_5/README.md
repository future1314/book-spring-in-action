本例演示了JavaConfig和XML两种配置方式如何混合使用的。具体来说：
    * JavaConfig引入其他JavaConfig配置，可以使用`@Import`注解，通过一个总的顶层JavaConfig配置类import其他所有配置类是个好办法，这样其他各个配置类之间互相无需再import；
    * JavaConfig引入XML配置，可以使用`@ImportResource("classpath:xxx.xml")`注解；
    * XML配置中引入其他XML配置，可以使用`<import resource="xxx.xml">`方式；
    * XML配置中引入JavaConfig配置，可以使用熟知的`<bean class="XxxConfig">`来引入。

其中，`SoundSystemJavaConfigTest`是JavaConfig配置类中引入其他JavaConfig配置和XML配置的单测；`SoundSystemXmlTest`是XML配置中引入其他XMl配置和JavaConfig配置的单测。
