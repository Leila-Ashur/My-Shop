package com.example.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.api.ApiClient
import com.example.myshop.api.ApiInterface
import com.example.myshop.databinding.ActivityMainBinding
import com.example.myshop.models.Product
import com.example.myshop.models.ProductsResponse
import com.example.myshop.viewmodel.ProductsViewModel
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productsViewModel:ProductsViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        productsViewModel.fetchProducts()
        super.onResume()
        productsViewModel.productsLiveData
            .observe(this, Observer { ProductList ->


                Toast.makeText(
                    baseContext,
                    "fetched ${ProductList?.size} products",
                    Toast.LENGTH_LONG
                ).show()
                binding.rvAdapter.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvAdapter.adapter = ProductsRvAdapter(ProductList)


            })
        productsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(
                baseContext,error,
                Toast.LENGTH_LONG
            ).show()

        })
    }}


