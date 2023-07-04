package com.example.myshop.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.models.Product
import com.example.myshop.repository.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel:ViewModel() {

//    one to hold the data if success or other if it fails
    val productsRepo=ProductsRepository()
    val productsLiveData= MutableLiveData<List<Product>>()
    var errorLiveData=MutableLiveData<String>()

fun fetchProducts(){
//    view model should be in different activity
//    suspend keyword make a function a coroutin
//    launch repo for creating your coroutine
 viewModelScope.launch {
     val response=productsRepo.getProducts()
     if (response.isSuccessful){
         productsLiveData.postValue(response.body()?.products)

     }
     else{
         errorLiveData.postValue(response.errorBody()?.string())
     }
 }
}
}