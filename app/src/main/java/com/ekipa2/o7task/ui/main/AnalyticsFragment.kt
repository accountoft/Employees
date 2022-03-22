package com.ekipa2.o7task.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ekipa2.o7task.MainApplication
import com.ekipa2.o7task.R
import com.ekipa2.o7task.databinding.AnalyticsFragmentBinding
import com.ekipa2.o7task.databinding.MainFragmentBinding
import java.util.*

class AnalyticsFragment : Fragment() {

    companion object {
        fun newInstance() = AnalyticsFragment()
    }

    private val viewModel: AnalyticsViewModel  by viewModels{
        EmployeeViewModelFactory((this.activity?.application as MainApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding=AnalyticsFragmentBinding.inflate(inflater,container,false)
        context ?: return binding.root

        viewModel.age.observe(this.viewLifecycleOwner){
            val age= it.map { Calendar.getInstance().get(Calendar.YEAR)-it.get(Calendar.YEAR) }
            binding.AverageAgeViewTxt.text=age.average().toString()
            binding.MedianAgeViewTxt.text= age[age.size/2].toString()
        }


        viewModel.salary.observe(this.viewLifecycleOwner) { it ->
            binding.MaxSalaryViewTxt.text = it.toString()
        }
        viewModel.ratio.observe(this.viewLifecycleOwner) { it ->
            binding.RatioViewtxt.text = (it.first().toFloat()/it.last().toFloat()).toString()
        }


        return binding.root
    }



}