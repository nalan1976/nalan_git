功能：
1）


注意：
1）hibernate中常用的函数返回值是什么？
    a）save：成功返回主键值，失败返回小于0的int值？
2）对泛型类完全没有理解：BaseDao的编写和使用都很混乱


技术点：
1）使用Hibernate的初始化方法：在resources目录下生成import.sql进行数据库初始化；
但生产环境还没有办法用
2）hibernate的配置中可以只扫描entity组件
3）entity组件不要进行注入（@Entity注解不是Bean？）
4）注入时要使用接口，而非class
5）插件失效原因：Settings–>Build,Execution,Deployment–>Compiler–>Annotation Processors，没有选中Enable annotation processing//nalan_*:IDE:idea:*;
6）userGroupService没有继承IUserGroupService接口，导致没有bean可注入，真坑人啊！
7）添加接口/方法（并实现）后，热部署失效，必须重启
8）在同一个事务中，先插入数据，后使用hql进行from UserGroup，导致hibernate报错：数据还没入库，在插入数据后立即flush即可
9）一个类要转化为json类型，必须实现Serializablel接口，get、set方法；
10）jQuery使用after动态生成table时，要特别注意选择器，应包含table这一级，而不能去掉这一级，否则可能不成功；
11）填充ArrayList时使用的是类的属性，所以每次填充的都是同一个属性，导致返回值全部相同（一直以为是js解析json对象有问题，晕倒！）
12）@RequestMapping("addUserGroup2")映射字符串只与前端发起的url有关
13）在Service层的类上或每个方法上使用@Transactional注解并不能取代数据不同步时flush的作用（也就是说flush该加的地方一个不能少）
14）BaseDao泛型及其实现要与子类（实体Dao类）的声明配合起来用才有意义！！！
15）容器使用前应进行有效性判断（判断size()！= 0，还是 != null比较好？）


