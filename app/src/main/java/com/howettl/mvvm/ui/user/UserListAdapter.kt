package com.howettl.mvvm.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.howettl.mvvm.R
import com.howettl.mvvm.data.model.Employees
import com.howettl.mvvm.databinding.ItemUserBinding
import com.squareup.picasso.Picasso

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    var employeesList: List<Employees>? = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_user, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = employeesList?.get(position) ?: return
        holder.bind(user)

        holder.itemView.setOnClickListener { view ->
            val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment()
            action.setUserId(user.id)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = employeesList?.size ?: 0

    inner class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(employees: Employees) {
            binding.user = employees
            Picasso.get().load(employees.profile_image).into(binding.img)
        }
    }

}