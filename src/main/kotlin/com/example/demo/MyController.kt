package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {
    @Autowired
    lateinit var userService: IUser

    // http://localhost:8888/user/2
    @GetMapping("/user/{userId}/")
    fun queryUserById(@PathVariable userId: String): List<UserInfo> {
        var user = UserInfo(userId.toLong(),"","")
        var userList = userService.queryUser(user)
        return userList
    }

    //http://localhost:8888/user/zhang1/abc/
    @GetMapping("/user/{name}/{pwd}/")
    fun addUser(@PathVariable name: String, @PathVariable pwd: String): Int {
        var user = UserInfo(0,name,pwd)
        var index = userService.addUser(user)
        return index
    }
}