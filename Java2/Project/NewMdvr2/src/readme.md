#实现功能
##优先级
* 建立程序框架，使之跑通
* 配置数据库连接
* 实现一个hello world的Controller，能够响应页面
* 实现一个MyBatis的数据库操作，并进行单元测试
* 实现登录页：
    1. 默认页面和默认出错页面
    2. 使用thymeleaf实现登录页面
* 实现SpringSecurity的登录控制：
    1. 必须输入用户名，密码才能访问指定页面
    2. 密码加密存储
* 实现一个RestApi并且需要访问控制
* 实现分离的前端页面
* 实现日志记录
* 实现统一异常管理
* 实现Redis缓存gps信息
* 实现自动报表

##技术点验证
多线程
IO处理
消息队列
docker
时间的相关操作
ngnix配置

##疑问
Spring Data JPA与其它数据库引擎如MyBatis、Hibernate到底什么关系？JDBC与他们又是什么关系？

##采坑
* 由于login.html页面用户名和密码输入框没有写name属性，只写了id属性，造成
usernamePasswordAuthenticationFilter无法截获用户名和密码
