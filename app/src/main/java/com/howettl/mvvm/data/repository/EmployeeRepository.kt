package com.howettl.mvvm.data.repository

import com.howettl.mvvm.data.database.EmployeeDao
import com.howettl.mvvm.data.network.EmployeeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class EmployeeRepository(private val employeeDao: EmployeeDao, private val employeeApi: EmployeeApi) {

    fun getUsers() = employeeDao.all()

    suspend fun getCachedCount() = withContext(Dispatchers.IO) {
        employeeDao.count
    }

    suspend fun refreshUsers() {
        withContext(Dispatchers.IO) {
            try {
                var lsit =employeeApi.getUsers().await().toTypedArray()
                employeeDao.insert(*lsit)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun getUserById(id: Int) = employeeDao.getById(id)



}