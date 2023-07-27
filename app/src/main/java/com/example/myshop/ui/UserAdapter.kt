package com.example.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.AddProductBinding
import com.example.myshop.databinding.AddUserBindingBinding
import com.example.myshop.models.Product
import com.example.myshop.models.User
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class UserAdapter (var user: List<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            AddUserBindingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserAdapter.UserViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = user.get(position)
        val binding = holder.binding
        binding.tvId.text = currentUser.id.toString()
        binding.tvFast.text = currentUser.firstName
        binding.tvLast.text = currentUser.lastName
        binding.tvPassword.text = currentUser.password.toString()
        binding.tvAge.text = currentUser.age.toString()
        binding.tvGender.text = currentUser.gender.toString()
        binding.tvEmail.text = currentUser.email
        binding.imageView.tag = currentUser.image
        binding.tvPhone.text = currentUser.phone
        Picasso
            .get().load(currentUser.image)
            .resize(400, 400)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.imageView)
    }


    override fun getItemCount(): Int {
        return user.size

    }

    class UserViewHolder(var binding: AddUserBindingBinding) :
        RecyclerView.ViewHolder(binding.root)
}


