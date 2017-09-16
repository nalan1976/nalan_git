目前存在的问题：
1）结束时会报：16-Sep-2017 15:11:29.331 警告 [localhost-startStop-2] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesJdbc The web application [ROOT] registered the JDBC driver [com.mysql.jdbc.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
2）
3）有时结束时会报：16-Sep-2017 15:41:03.694 信息 [Abandoned connection cleanup thread] org.apache.catalina.loader.WebappClassLoaderBase.checkStateForResourceLoading Illegal access: this web application instance has been stopped already. Could not load []. The following stack trace is thrown for debugging purposes as well as to attempt to terminate the thread which caused the illegal access.

疑惑的问题：


解决的问题：
1）@GeneratedValue(strategy = GenerationType.AUTO)：即为默认值时，mysql数据库会生成主键表，
造成数据插入失败，改为IDENTITY即可
2）目前的配置在数据库日志上看，发送了非常多的语句，会否对数据库造成压力？
  实验：没有断开连接的话，每次插入就一句，断开了连接就会插入很多，
  通过ApplicationContext中maxIdleTime参数控制，修改完成后重新打war包即可
3）AutoWired注入还不太理解，到底注入的是什么？
  答：注入的是根据类型自动匹配的对象实例
