package com.example.myshop.models

import java.io.FileDescriptor

data class Product(
    var id:Int,
    var title:String,
    var description:String,
    var price:Double,
    var rating:Double,
    var stock:Int,
    var brand:String,
    var category:String,
    var thumbnail:String,
    var image:String,

)
