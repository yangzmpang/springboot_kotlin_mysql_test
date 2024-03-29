# Kotlin Spring Boot

## 主要功能

* 这个例子用了mysql来存储数据表，用kolin来写访问数据库的操作。
* 语言 kotlin
* 数据库 mysql
* 访问方式 control 直接用 url 访问
* 数据访问用 mybatis 的注解方式实现

## 数据配置 application.yml 文件内容
```
server:
  port: 8888

spring:
  datasource:
    driverClassName: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/yzm
    username: root
    password: 123456
```

## 实现过程

1. 用idea 建立 maven的spring boot initializer 工程, 语言选择kotlin。

2. 建立数据表mysql   yzm -> user  表
```javascript
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
```
3. 生成实体类
```javascript
// 生成对应的实体类
data class UserInfo(var id: Long=0, var name: String="", var pwd: String="")
```
4. 定义mapper
```javascript
// 定义mapper
@Mapper
interface UserMapper {
    @Select("select id, name, pwd from user where id=#{userInfo.id}")
    fun queryUser(@Param("userInfo") userInfo: UserInfo): List<UserInfo>
    @Insert("insert into user (name, pwd) values (#{userInfo.name}, #{userInfo.pwd})")
    fun addUser(@Param("userInfo") userInfo: UserInfo): Int
}
```
5. service 的实现
```javascript
// 实现 service:
@Service
class UserServiceImpl:IUser {
    @Autowired
    lateinit var userMapper: UserMapper

    override fun queryUser(userInfo: UserInfo): List<UserInfo> {
        return userMapper.queryUser(userInfo)
    }

    override fun addUser(userInfo: UserInfo): Int {
        return userMapper.addUser(userInfo);
    }
}
```

6. 调用增加用户
```javascript
运行时增加用户： 
http://localhost:8888/user/zhang1/abc/
```
7. 查询用户信息
```javascript
查询数据：
http://localhost:8888/user/2
```

## 关于作者

```javascript
    Name  : "杨子民",
    nickname: "yangzmpang"
    mail : "yangzmpang@sina.com"
```
