package com.howettl.mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.howettl.mvvm.data.model.Employees
import com.howettl.mvvm.data.typeConverter.DataConverter

@Database(entities = [Employees::class], version = 2, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): EmployeeDao

}