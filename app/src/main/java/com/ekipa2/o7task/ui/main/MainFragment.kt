package com.ekipa2.o7task.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ekipa2.o7task.MainActivity
import com.ekipa2.o7task.MainApplication
import com.ekipa2.o7task.R
import com.ekipa2.o7task.adapters.EmployeeAdapter
import com.ekipa2.o7task.data.Employee
import com.ekipa2.o7task.databinding.MainFragmentBinding
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private  val viewModel: MainViewModel  by viewModels{
        EmployeeViewModelFactory((this.activity?.application as MainApplication).repository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding= MainFragmentBinding.inflate(inflater,container,false)
        context ?: return binding.root

        val adapter=EmployeeAdapter()
        binding.listMainFragmentEmployees.adapter = adapter


       viewModel.getEmployee().observe(this.viewLifecycleOwner, Observer<List<Employee>>{ employees ->
            adapter.submitList(employees)
           Log.i("ana",employees.toString())
       })

        binding.btnAnalytics.setOnClickListener{
            this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToAnalyticsFragment())
        }

        binding.fabMainFragmentAddEmployee.setOnClickListener{
            this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddEmplFragment())
           // viewModel.insertEmployee(employee = Employee(1,"bob", Calendar.getInstance(),"ž",123))
            Log.d("bob","helopoooooooooooooo")
            //this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToAnalyticsFragment())
        }
        return binding.root
    }



}