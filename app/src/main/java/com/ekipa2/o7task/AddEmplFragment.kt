package com.ekipa2.o7task

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ekipa2.o7task.data.Employee
import com.ekipa2.o7task.databinding.AddEmplFragmentBinding
import com.ekipa2.o7task.databinding.MainFragmentBinding
import com.ekipa2.o7task.ui.main.EmployeeViewModelFactory
import java.util.*

class AddEmplFragment : Fragment() {

    companion object {
        fun newInstance() = AddEmplFragment()
    }

    private val viewModel: AddEmplViewModel  by viewModels{
        EmployeeViewModelFactory((this.activity?.application as MainApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding= AddEmplFragmentBinding.inflate(inflater,container,false)
        context ?: return binding.root

        binding.btnSelectBirthday.setOnClickListener {
            showDatePicker()
        }
        binding.btnInsert.setOnClickListener {
            viewModel.insertEmployee(employee = Employee(1,
                binding.textInputLayout.editText?.text.toString(),
                Calendar.getInstance(),binding.genderSpinner.selectedItem.toString(),
                binding.textInputLayout2.editText?.text.toString().toLong()))

        }


      //
        return binding.root
    }



    fun showDatePicker(){
        DatePickerFragment(DatePickerDialog.OnDateSetListener { _, year, month, day ->
            val c = Calendar.getInstance()
            c.set(Calendar.YEAR, year)
            c.set(Calendar.MONTH, month)
            c.set(Calendar.DAY_OF_MONTH, day)


            Log.i("AddEmplFragment", "showDatePicker: " + c.timeInMillis )
viewModel.goToDayFrom(c)

        }).show(parentFragmentManager, "datePicker")
    }

}