package com.ekipa2.o7task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekipa2.o7task.data.Employee
import com.ekipa2.o7task.data.EmployeeRepository
import kotlinx.coroutines.launch
import java.util.*

class AddEmplViewModel constructor(private val
                                   repository: EmployeeRepository
)
    : ViewModel() {

    fun insertEmployee(employee: Employee) = viewModelScope.launch {
        repository.createEmployee(employee.name,_theFromDate.value!!,employee.gender,employee.salary)
    }

    private val _theFromDate = MutableLiveData<Calendar>()
    val theFromDate: LiveData<Calendar>
        get() = _theFromDate

    fun goToDayFrom(calendar: Calendar) {
         _theFromDate.value = calendar
    }

}