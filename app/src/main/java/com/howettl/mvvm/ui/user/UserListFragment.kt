package com.howettl.mvvm.ui.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.howettl.mvvm.R
import com.howettl.mvvm.data.model.Employees
import com.howettl.mvvm.databinding.FragmentUserListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class UserListFragment: Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val viewModel: UserListViewModel by viewModel()
    private var errorSnackbar: Snackbar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        binding.userList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        var listOfemp= arrayListOf<Employees>()
        val adapter = UserListAdapter()
        viewModel.users.observe(this, Observer {
            listOfemp.clear()
            listOfemp.addAll(it)
            adapter.employeesList = it
        })
        binding.adapter = adapter

        binding.etSearchBox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(s?.toString()?.length?:0>0)
                {
                    var filterliste=listOfemp.filter { it.name.toLowerCase().contains(s.toString())||it.email.toLowerCase().contains(s.toString()) }
                    adapter.employeesList = filterliste
                }
                else
                {
                    adapter.employeesList = listOfemp
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }

    override fun onResume() {
        super.onResume()

        viewModel.loadUsers()
    }

    private fun showError(@StringRes message: Int) {
        errorSnackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}