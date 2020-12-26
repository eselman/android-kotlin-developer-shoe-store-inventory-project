package com.eselman.android.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Evangelina Selman
 */
@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable