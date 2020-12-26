package com.eselman.android.shoestore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eselman.android.shoestore.models.Shoe

class ShoesViewModel: ViewModel() {
    val shoesListLiveData = MutableLiveData<List<Shoe>>()
    private val shoesList = mutableListOf<Shoe>()
    val shoeAddedEvent = MutableLiveData<Boolean>()

    fun loadShoesList() {
        shoesListLiveData.value = shoesList
        shoeAddedEvent.value = false
    }

    fun addShoe(newShoe: Shoe) {
        shoesList.add(newShoe)
        shoeAddedEvent.value = true
    }
}