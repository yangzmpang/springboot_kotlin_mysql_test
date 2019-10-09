package com.example.demo

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Param

@Mapper
interface UserMapper {
    @Select("select id, name, pwd from user where id=#{userInfo.id}")
    fun queryUser(@Param("userInfo") userInfo: UserInfo): List<UserInfo>

    @Insert("insert into user (name, pwd) values (#{userInfo.name}, #{userInfo.pwd})")
    fun addUser(@Param("userInfo") userInfo: UserInfo): Int
}