package com.ekipa2.o7task.ui.main

import androidx.lifecycle.*
import com.ekipa2.o7task.data.EmployeeRepository
import java.util.*

class AnalyticsViewModel constructor(private val
   repository: EmployeeRepository
): ViewModel() {

// var liveDataString: LiveData<String> = repository.getAverageAge().map

val test ="neki"
    val salary: LiveData<Long> = repository.getMaxSalary().asLiveData()

    val ratio = repository.getGenderRatio().asLiveData()

    val age =repository.getAverageAge().asLiveData()

}