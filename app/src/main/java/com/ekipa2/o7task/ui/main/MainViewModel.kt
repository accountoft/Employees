package com.ekipa2.o7task.ui.main

import androidx.lifecycle.*
import com.ekipa2.o7task.AddEmplViewModel
import com.ekipa2.o7task.data.AppDatabase.Companion.getInstance
import com.ekipa2.o7task.data.Employee
import com.ekipa2.o7task.data.EmployeeDao
import com.ekipa2.o7task.data.EmployeeRepository
import kotlinx.coroutines.launch

class MainViewModel constructor(private val
repository: EmployeeRepository
) : ViewModel() {

    private val employees: LiveData<List<Employee>> =repository.getEmployees().asLiveData()

    fun getEmployee(): LiveData<List<Employee>> {
        return employees
    }

    fun insertEmployee(employee: Employee) = viewModelScope.launch {
        repository.createEmployee(employee.name,employee.birthdayDate,employee.gender,employee.salary)
    }

}

class EmployeeViewModelFactory(private val repository: EmployeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(AddEmplViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddEmplViewModel(repository) as T

        }
        if (modelClass.isAssignableFrom(AnalyticsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnalyticsViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}