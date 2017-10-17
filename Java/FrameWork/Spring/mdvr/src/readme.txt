功能：
1）


注意：
1）hibernate中常用的函数返回值是什么？
    a）save：成功返回主键值，失败返回小于0的int值？
2）更改用户名的action中，接收数据部分实现的极为恶心！！！暂时没有时间更改
3）

设计相关：
1）返回到前台的数据尽量完整、统一，暂时不用的数据可以为空；尤其是绘制动态表格的数据，组织不好，前台实现起来很麻烦
2）所有数据库相关特性必须控制在Dao层以内，否则就失去了分层的实际意义，而且也容易产生破窗效应
3）cascade在这个项目中是否应该只在增加的时候关联（CascadeType.PERSIST）？
答：一般使用CascadeType.MERGE
4）Action必须是多实例，其它一般都是单实例，因为无需保存状态


疑问：
1）在不同的service对象中，自动注入同一个BaseDao的子类，这些子类指向的是同一个实例吗？
2）qr.setParameter(i + 1, values[i]);//nalan???    为什么序号要从1开始，百思不得其解

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
15）容器使用前应进行有效性判断（应该用size()！= 0，我开始在程序中返回null不符合惯用的规则）
16）前端传过来的字符串（只要合法），action中可以直接以函数参数声明为Integer的方式转化为int
17）局部对象定义后没有被初始化，在调试时显示变量不可访问
18）实体对象中cascade属性确实要谨慎使用，相关操作太多了，效率较低
19）自己new的对象是不会享受到自动注入的待遇，: )
20）Bean转Json时，若2个对象中有集合属性互相引用，会造成递归出错，需要在一方的属性上使用@JsonIgnore，禁止Json转化此属性
21）前台的一维数组，转化为Json到后台时是以0,1,2等为键值的map（注意接收入参的地方必须加@RequestBody注解）；




