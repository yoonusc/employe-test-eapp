package com.howettl.mvvm.data.model
import com.google.gson.annotations.SerializedName


data class Company (

  @SerializedName("name"        ) var name        : String? = null,
  @SerializedName("catchPhrase" ) var catchPhrase : String? = null,
  @SerializedName("bs"          ) var bs          : String? = null

)
{
  override fun toString(): String {
    return "Name:"+name+",catchPhrase:"+catchPhrase+",bs:"+bs
  }
}