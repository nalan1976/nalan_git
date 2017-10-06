功能：
1）


技术点：
1）使用Hibernate的初始化方法：在resources目录下生成import.sql进行数据库初始化；
但生产环境还没有办法用
2）hibernate的配置中可以只扫描entity组件
3）entity组件不要进行注入（@Entity注解不是Bean）
4）注入时要使用接口，而非class
5）插件失效原因：Settings–>Build,Execution,Deployment–>Compiler–>Annotation Processors，没有选中Enable annotation processing//nalan_*:IDE:idea:*;
