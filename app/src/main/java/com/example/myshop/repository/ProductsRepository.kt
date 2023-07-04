

//co ruotines somethingg that coperates with another ..co rouines initiated in a background thread and one thread  stop executing and let other functions continue will suspends itself and let the other
//direction of execution of a product is  a thread.... callback wil only create new thread will be blocked while waiting for response
package com.example.myshop.repository

import com.example.myshop.api.ApiClient
import com.example.myshop.api.ApiInterface
import com.example.myshop.models.ProductsResponse
import com.example.myshop.ui.ProductsRvAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductsRepository {

val apiClient=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getProducts():Response<ProductsResponse>{

        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }







}