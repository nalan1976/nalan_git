项目现况：
1）对应关系没有完全做完，做到了一对多带连接表的双向映射；
2）所有Session关闭应该是有问题的，应该使用HibernateUtil中的closeSession
3）每个.java文件中都做了注释，写明学到了哪些和有哪些应该注意或未确认的问题
4）所有项目都编译通过，并可正常运行










//部分sql语句用于删表

DROP TABLE ADDRESS_11tab_sx;
 drop table if exists ADDRESS_1ntab
 drop table if exists join_1ntab
 drop table if exists PERSON_1ntab