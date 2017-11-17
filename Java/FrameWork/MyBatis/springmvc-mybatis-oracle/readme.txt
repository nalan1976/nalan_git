功能：
1）mybatis+spring+springMVC+Oracle实现了最简单的框架，各个层次结构都已经具备；
2）利用mybatis标准方法，即*mapper.xml+POJO+Interface实现了一个插入操作；

技术点：
1）mybatis多参数绑定：
    a.使用@Param传递参数：xml文件中要写明jdbcType的类型，否则参数可能会乱
2）oracle不能使用sys用户建触发器等数据对象；需要建新用户并授予权限
3）建立一个自增长的序列至少要3条语句

建表语句：
CREATE TABLE T_TEST(
id NUMBER(11) CONSTRAINT pk_test_value PRIMARY KEY,
username VARCHAR2(14),
password VARCHAR2(14)) ;

建序列（运行时要去除注释）
/**
create sequence seq_test_id --序列名
start with 3 --初始化为3
increment by 1 --每次增加1
maxvalue 99999 --最大值
nocache --无缓存
nocycle --无循环，一直累加
*/
(无注释版)
create sequence seq_test_id
start with 3
increment by 1
maxvalue 99999
nocache
nocycle
/

建触发器
create or replace trigger tri_t_test
before insert on T_TEST
for each row
begin
select seq_test_id.nextval into :new.id from dual;
end tri_t_test;
/