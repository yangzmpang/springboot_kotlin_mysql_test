package com.example.demo

interface IUser{
    fun queryUser(userInfo: UserInfo): List<UserInfo>
    fun addUser(userInfo: UserInfo): Int
}