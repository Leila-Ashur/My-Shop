package com.example.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.R
import com.example.myshop.databinding.ActivityMainBinding
import com.example.myshop.databinding.ActivityUserBinding
import com.example.myshop.viewmodel.ProductsViewModel
import com.example.myshop.viewmodel.UsersViewModel

class UserActivity : AppCompatActivity() {
    val userViewModel:UsersViewModel by viewModels()
    lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
     userViewModel.fetchUsers()
        userViewModel.userLiveData.observe(this, Observer{ UserList ->
                Toast.makeText(
                    baseContext,
                    "fetched ${UserList?.size} users",
                    Toast.LENGTH_LONG
                ).show()
                binding.rvRecycler.layoutManager = LinearLayoutManager(this@UserActivity)
                binding.rvRecycler.adapter = UserAdapter(UserList)
            })
        userViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(
                baseContext,error,
                Toast.LENGTH_LONG
            ).show()
        })
    }}


