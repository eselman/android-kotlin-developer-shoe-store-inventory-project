package com.eselman.android.shoestore.ui.customView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.eselman.android.shoestore.databinding.ShoeItemBinding
import com.eselman.android.shoestore.models.Shoe

class ShoeItemView(context: Context, val root: LinearLayout, val shoe: Shoe): View(context) {
    fun bindItem() {
        val binding: ShoeItemBinding =
                ShoeItemBinding.inflate(LayoutInflater.from(context), root, true)
        binding.shoe = shoe
    }
}