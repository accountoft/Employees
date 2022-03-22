package com.ekipa2.o7task.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ekipa2.o7task.data.Employee
import com.ekipa2.o7task.databinding.ListItemEmployeeBinding

class EmployeeAdapter : ListAdapter<Employee, RecyclerView.ViewHolder>(EmployeeDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EmployeeViewHolder(
            ListItemEmployeeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val employee = getItem(position)
        (holder as EmployeeViewHolder).bind(employee)

    }
    class EmployeeViewHolder(
        private val binding: ListItemEmployeeBinding
        ): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.employee?.let { employee ->
                    //  navigateToEmployee(employee, it)
                }
            }
        }
        fun bind(item: Employee) {
            binding.apply {
                employee = item
                executePendingBindings()
            }
        }
    }

}

private class EmployeeDiffCallback : DiffUtil.ItemCallback<Employee>() {

    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.employeeId == newItem.employeeId
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }
}