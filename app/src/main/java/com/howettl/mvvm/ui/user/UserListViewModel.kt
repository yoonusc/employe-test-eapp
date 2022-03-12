package com.howettl.mvvm.ui.user

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.howettl.mvvm.base.AsyncViewModel
import com.howettl.mvvm.data.model.Employees
import com.howettl.mvvm.data.repository.EmployeeRepository
import kotlinx.coroutines.launch

class UserListViewModel(
    private val employeeRepository: EmployeeRepository
) :
    AsyncViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadUsers() }

    val users: LiveData<List<Employees>> = employeeRepository.getUsers()

    init {
        loadingVisibility.value = View.GONE
        loadUsers()
    }

    fun loadUsers() {
        launch {
            if (employeeRepository.getCachedCount() == 0) {
                loadingVisibility.value = View.VISIBLE
            }

            employeeRepository.refreshUsers()

            loadingVisibility.value = View.GONE
        }
    }
}