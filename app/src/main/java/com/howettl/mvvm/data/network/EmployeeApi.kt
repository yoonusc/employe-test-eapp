package com.howettl.mvvm.data.network

import com.howettl.mvvm.data.model.Employees
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface EmployeeApi {
    @GET("/v2/5d565297300000680030a986")
    fun getUsers(): Deferred<List<Employees>>

}