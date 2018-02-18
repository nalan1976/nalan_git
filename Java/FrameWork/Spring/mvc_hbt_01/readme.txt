目前存在的问题：
1）结束时会报：16-Sep-2017 15:11:29.331 警告 [localhost-startStop-2] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesJdbc The web application [ROOT] registered the JDBC driver [com.mysql.jdbc.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
2）有时结束时会报：16-Sep-2017 15:41:03.694 信息 [Abandoned connection cleanup thread] org.apache.catalina.loader.WebappClassLoaderBase.checkStateForResourceLoading Illegal access: this web application instance has been stopped already. Could not load []. The following stack trace is thrown for debugging purposes as well as to attempt to terminate the thread which caused the illegal access.
3）entity中日期类型加@Temporal(TemporalType.TIMESTAMP)注解运行报错

疑惑的问题：
1）jsp调试如何是否所有变量都能动态显示
2）使用uuid还没有实验
3）大文件没有实验
4）jsp整个运行流程还不够熟悉
5）使用gardle哪些库在发布时是不需要的，如何编写脚本打包只需要的库（jar包）
6）网站如何发布到linux系统下
7）怎样使用MD5等方式保存密码
8）真正的项目中权限控制是如何做的？
9）批量操作数据库还没有实验
10）使用注解建表时，not null不起作用




解决的问题：
1）@GeneratedValue(strategy = GenerationType.AUTO)：即为默认值时，mysql数据库会生成主键表（"hibernate_sequence"?），
造成数据插入失败，改为IDENTITY即可
2）目前的配置在数据库日志上看，发送了非常多的语句，会否对数据库造成压力？
  实验：没有断开连接的话，每次插入就一句，断开了连接就会插入很多，
  通过ApplicationContext中maxIdleTime参数控制，修改完成后重新打war包即可
3）AutoWired注入还不太理解，到底注入的是什么？
  答：注入的是根据类型自动匹配的对象实例
4）springMVC的action中无法得到url中参数的问题：通过在web.xml中增加org.springframework.web.context.request.RequestContextListener
5）idea热部署
6）使用getCurrentSession怎样都不行，而使用openSession就可以：ApplicationContext.xml中没有加<tx:annotation-driven/>

得到验证的问题：
1）不同的DAO使用：
        @Autowired
        private SessionFactory sessionFactory;
        注入的都是同一个SessionFactory
2）web.xml中<url-pattern>/</url-pattern>的值是否为"*.do"与@RequestMapping("/views/login.do")的写法没有关系；


功能：
1）注册终于正常了
2）自定义分页标签
3）集成log4j2
4）idea热部署
5）