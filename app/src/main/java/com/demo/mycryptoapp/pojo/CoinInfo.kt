package com.demo.mycryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo(
    @SerializedName("Name")
    @Expose
    val name: String? = null,
    @SerializedName("FullName")
@Expose
val fullName: String? =  "fullName"
)
