package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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