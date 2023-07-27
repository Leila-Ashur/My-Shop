package com.example.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.models.Product
import com.example.myshop.models.User
import com.example.myshop.repository.ProductsRepository
import com.example.myshop.repository.UserRepository
import kotlinx.coroutines.launch

class UsersViewModel: ViewModel() {
    //    one to hold the data if success or other if it fails
    val userRepo= UserRepository()
    val userLiveData= MutableLiveData<List<User>>()
    var errorLiveData= MutableLiveData<String>()

    fun fetchUsers(){
//    view model should be in different activity
//    suspend keyword make a function a coroutin
//    launch repo for creating your coroutine
        viewModelScope.launch {
            val response=userRepo.getUser()
            if (response.isSuccessful){
                userLiveData.postValue(response.body()?.users)

            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}