package com.howettl.mvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.howettl.mvvm.data.typeConverter.DataConverter

@Entity
data class Employeesd(@field:PrimaryKey val id: Int, val name: String, val username: String, val email: String, val img: String, val phone: String, val website: String, @TypeConverters(DataConverter::class) val address:Address,@TypeConverters(DataConverter::class)  val company:Company  )