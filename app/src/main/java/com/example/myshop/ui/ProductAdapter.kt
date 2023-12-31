package com.example.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.AddProductBinding
import com.example.myshop.models.Product
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsRvAdapter (var products:List<Product>): RecyclerView.Adapter<ProductsRvAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding =
            AddProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsRvAdapter.ProductsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentProduct = products.get(position)
        val binding = holder.binding
        binding.tvId.text = currentProduct.id.toString()
        binding.tvBrands.text = currentProduct.brand
        binding.tvCategory.text = currentProduct.category
        binding.tvPrice.text = currentProduct.price.toString()
        binding.tvRatings.text = currentProduct.rating.toString()
        binding.tvStock.text = currentProduct.stock.toString()
        binding.tvTitle.text = currentProduct.title
        binding.ivAdd.tag = currentProduct.thumbnail
        binding.tvDescription.text = currentProduct.description
        Picasso
            .get().load(currentProduct.thumbnail)
            .resize(400, 400)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivAdd)
    }


    override fun getItemCount(): Int {
        return products.size

    }

    class ProductsViewHolder(var binding: AddProductBinding) :
        RecyclerView.ViewHolder(binding.root)
}










