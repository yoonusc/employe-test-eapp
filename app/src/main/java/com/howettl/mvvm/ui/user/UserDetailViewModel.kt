package com.howettl.mvvm.ui.user

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.howettl.mvvm.base.AsyncViewModel
import com.howettl.mvvm.data.model.Employees

import com.howettl.mvvm.data.repository.EmployeeRepository
import kotlinx.coroutines.launch

class UserDetailViewModel(
    private val employeeRepository: EmployeeRepository
) : AsyncViewModel() {

    private val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    private val errorMessage: MutableLiveData<Int> = MutableLiveData()

    lateinit var employees: LiveData<Employees>

    fun loadUser(userId: Int) {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null

        employees = employeeRepository.getUserById(userId)
    }
}