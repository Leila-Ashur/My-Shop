package com.example.myshop.repository

import com.example.myshop.api.ApiClient
import com.example.myshop.api.ApiInterface
import com.example.myshop.models.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response

class UserRepository {
        val apiClient =ApiClient.buildClient(ApiInterface::class.java)
        suspend fun getUser():retrofit2.Response<UsersResponse>{
            return withContext(Dispatchers.IO){
                apiClient.getUsers()
            }

        }

    }
