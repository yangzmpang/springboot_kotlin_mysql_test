# Kotlin Spring Boot

`Kotlin` is a cool language, not just working in Android. It also can be used to develop Spring Boot, as it has a good interop with Java.

这个例子用了 mysql 来存储数据表，用kolin来写访问数据库的操作。

1. 用idea 建立 maven的spring boot initializer 工程, 语言选择kotlin。

2. 建立数据表mysql   yzm -> user  表

CREATE TABLE `user` (

  `id` int(11) NOT NULL AUTO_INCREMENT,
  
  `name` varchar(80) NOT NULL,
  
  `pwd` varchar(255) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


3.  运行时增加用户： 

http://localhost:8888/user/zhang1/abc/

4.  查询数据：

http://localhost:8888/user/2
