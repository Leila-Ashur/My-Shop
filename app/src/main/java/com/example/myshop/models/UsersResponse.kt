package com.example.myshop.models

data class UsersResponse(
    var users:List<User>,
    var total:Int,
    var skip:Int,
    var limit:Int
)

