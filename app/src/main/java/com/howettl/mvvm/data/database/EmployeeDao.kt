package com.howettl.mvvm.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.howettl.mvvm.data.model.Employees

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM Employees")
    fun all(): LiveData<List<Employees>>

    @Query("SELECT * FROM Employees WHERE id=:userId")
    fun getById(userId: Int): LiveData<Employees>

    @get:Query("SELECT count(*) FROM Employees")
    val count: Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg employees: Employees)

}