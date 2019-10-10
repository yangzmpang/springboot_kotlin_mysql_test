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

3. 

##// 生成对应的实体类
data class UserInfo(var id: Long=0, var name: String="", var pwd: String="")

4. 
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
5. 

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

6.  运行时增加用户： 

http://localhost:8888/user/zhang1/abc/

7.  查询数据：

http://localhost:8888/user/2
