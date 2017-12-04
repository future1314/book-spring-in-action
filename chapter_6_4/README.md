本示例仅介绍了Thymeleaf与Spring集成的配置方法，主要配置位于`ServletConfig`中：
  * `ThymeleafViewResolver`：将逻辑视图名称解析为Thymeleaf模板视图；
  * `SringTemplateEngine`：处理模板并渲染结果；
  * `SpringResourceTemplateResolver`：加载Thymeleaf模板。